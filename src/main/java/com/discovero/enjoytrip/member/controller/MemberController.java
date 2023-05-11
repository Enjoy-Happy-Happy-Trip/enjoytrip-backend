package com.discovero.enjoytrip.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.discovero.enjoytrip.member.model.IMemberService;
import com.discovero.enjoytrip.member.model.MembersDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	private IMemberService memberService;

	@Autowired
	public MemberController(IMemberService memberService) {
		this.memberService = memberService;
	}
	
	// 회원가입을 누르면 회원가입 페이지로 이동합니다.
	@GetMapping("/registry")
	public String registry() throws Exception {
		logger.debug("GET registry called");
		return "/member/registry";
	}
	
	// 로그인 페이지 이동
	@GetMapping("/signin")
	public String signin() throws Exception {
		logger.debug("GET regisigninstry called");
		return "/member/signin";
	}
	
	// 회원가입페이지에서 가입 버튼을 누르면 회원 가입이 되고 이후 index 페이지로 이동합니다.
	@PostMapping("/registryaf")
	public String registryaf(MembersDto mdto) throws Exception {
		logger.debug("POST registryaf called");
		memberService.registry(mdto);
		return "redirect:/";
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
	
	// TODO: 비밀번호 찾기 페이지는 비밀번호 재설정으로 변경해서 재구현
	
	// 관리자에게 회원 목록을 보여줍니다.
	@GetMapping("/memberlist")
	public String memberlist(Model model) throws Exception {
		logger.debug("GET memberlist called");
		model.addAttribute("members", memberService.memberlist());
		return "/member/adminpage";
	}
	
	// 관리자에게 회원 상세 정보를 보여줍니다.
	@GetMapping("/detail")
	public String detail(String userId, Model model) throws Exception {
		logger.debug("GET detail called");
		model.addAttribute("member", memberService.memberDetail(userId));
		return "/member/memberupdate";
	}
	
	// TODO: REST api로 구성하기 위해서는 url상에서 delete는 없애야 함.
	// 관리자가 회원을 삭제합니다.
	@DeleteMapping("/delete")
	public String delete(String userId) throws Exception {
		memberService.memberDelete(userId);
		return "redirect:/member/memberlist";
	}
	
	// TODO: REST api로 구성하기 위해서는 url상에서 Go는 없애야 함.
	// 관리자가 회원 정보를 수정합니다.
	@PutMapping("updateGo")
	public String update(MembersDto mdto) throws Exception {
		memberService.memberUpdate(mdto);
		return "redirect:/member/memberlist";
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
}














