package com.discovero.enjoytrip.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.member.model.IMemberService;
import com.discovero.enjoytrip.member.model.JwtServiceImpl;
import com.discovero.enjoytrip.member.model.MembersDto;
import com.discovero.enjoytrip.member.model.ResetPwdInfoDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/member")
@Api("회원 컨트롤러  API V1")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private IMemberService memberService;
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	public MemberController(IMemberService memberService) {
		this.memberService = memberService;
	}
	
	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MembersDto mdto) {
		
		logger.debug("GET login called loginInfo : {}", mdto);

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MembersDto loginUser = memberService.login(mdto);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("user_id", loginUser.getUser_id());// key, data
				String refreshToken = jwtService.createRefreshToken("user_id", loginUser.getUser_id());// key, data
				memberService.saveRefreshToken(mdto.getUser_id(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{user_id}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("user_id") @ApiParam(value = "인증할 회원의 아이디.", required = true) String user_id,
			HttpServletRequest request) {
//		logger.debug("user_id : {} ", user_id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				MembersDto mdto = memberService.memberDetail(user_id);
				resultMap.put("userInfo", mdto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{user_id}")
	public ResponseEntity<?> removeToken(@PathVariable("user_id") String user_id) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberService.deleRefreshToken(user_id);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody MembersDto mdto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, mdto);
		if (jwtService.checkToken(token)) {
			if (token.equals(memberService.getRefreshToken(mdto.getUser_id()))) {
				String accessToken = jwtService.createAccessToken("user_id", mdto.getUser_id());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불가!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 회원가입페이지에서 가입 버튼을 누르면 회원 가입
	@PostMapping("")
	public ResponseEntity<Void> register(@RequestBody MembersDto mdto) throws Exception {
		logger.debug("POST registry called, form : {}", mdto);
		memberService.register(mdto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 로그인 버튼을 누르면 로그인을 시도합니다.
	@PostMapping("/loginaf")
	@ResponseBody
	public ResponseEntity<MembersDto> loginaf(@RequestBody MembersDto mdto, HttpSession session) throws Exception {
		logger.debug("GET loginaf called loginInfo : {}", mdto);
		MembersDto login = memberService.login(mdto);
		
		if (login != null) {
			session.setAttribute("login", login);
			ResponseEntity<MembersDto> responseEntity = new ResponseEntity<MembersDto>(login, HttpStatus.OK);
			return responseEntity;
		} else {
			session.invalidate();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	// 로그아웃 버튼을 누르면 로그아웃을 합니다.
	@GetMapping("/signout")
	@ResponseBody
	public ResponseEntity<Void> signout(HttpSession session) throws Exception {
		logger.debug("GET signout called");
		session.invalidate();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// 관리자에게 회원 목록을 보여줍니다.
	@GetMapping("/memberlist")
	public String memberlist(Model model) throws Exception {
		logger.debug("GET memberlist called");
		model.addAttribute("members", memberService.memberlist());
		return "/member/adminpage";
	}
	
	// 관리자에게 회원 상세 정보를 보여줍니다.
	@GetMapping("/detail")
	public String detail(String user_id, Model model) throws Exception {
		logger.debug("GET detail called");
		model.addAttribute("member", memberService.memberDetail(user_id));
		return "/member/memberupdate";
	}
	
	// 관리자가 회원을 삭제합니다.
	@DeleteMapping("/{user_id}")
	public ResponseEntity<Void> memberRemove(@PathVariable String user_id) throws Exception {
		memberService.removeMemberById(user_id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// TODO: REST api로 구성하기 위해서는 url상에서 Go는 없애야 함.
	// 관리자가 회원 정보를 수정합니다.
	@PutMapping("/{user_id}")
	public ResponseEntity<Void> update(@RequestBody MembersDto mdto) throws Exception {
		memberService.modifyPasswordById(mdto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// login여부를 front에게 알려줍니다. (1 : login 되어있음, 2 : admin, 0 : login 안되어 있음)
	@GetMapping("/check")
	@ResponseBody
	public Map<String, Integer> check(HttpSession session) {
		logger.info("GET check called");
		Map<String, Integer> loginInfo = new HashMap<>();
		MembersDto login = (MembersDto) session.getAttribute("login");
		if (login == null) {
			loginInfo.put("isLogin", 0);
		} else if (login.getUser_id().equals("admin")) {
			loginInfo.put("isLogin", 2);
		} else {
			loginInfo.put("isLogin", 1);
		}
		return loginInfo;
	}
	
	@PostMapping("/resetPwd")
	public ResponseEntity<ResetPwdInfoDto> resetPwd(@RequestBody MembersDto mdto) throws Exception {
		logger.debug("GET resetPwd called findForm : {}", mdto);
		ResetPwdInfoDto resetPwdInfo = memberService.resetPwd(mdto);
		
		return new ResponseEntity<ResetPwdInfoDto>(resetPwdInfo, HttpStatus.OK);
		
	}
}














