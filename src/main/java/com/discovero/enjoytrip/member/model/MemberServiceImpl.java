package com.discovero.enjoytrip.member.model;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discovero.enjoytrip.util.model.EmailDto;
import com.discovero.enjoytrip.util.model.EmailServiceImpl;
import com.discovero.enjoytrip.util.model.IEmailService;

@Service
public class MemberServiceImpl implements IMemberService {

	private IEmailService emailService;
	private MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper, IEmailService emailService) {
		super();
		this.memberMapper = memberMapper;
		this.emailService =emailService;
	}

	@Override
	public boolean register(MembersDto dto) throws Exception{
		dto.setUser_password(encryptData(dto.getUser_password()));
		return memberMapper.register(dto);
	}

	@Override
	public MembersDto login(MembersDto dto) {
		dto.setUser_password(encryptData(dto.getUser_password()));
		return memberMapper.login(dto);
	}

	@Override
	public String findpassword(String student_no) {
		return memberMapper.findpassword(student_no);
	}

	@Override
	public List<MembersDto> memberlist() {
		return memberMapper.memberlist();
	}

	@Override
	public MembersDto memberDetail(String user_id) {
		return memberMapper.memberDetail(user_id);
	}

	@Override
	public boolean memberDelete(String user_id) {
		return memberMapper.memberDelete(user_id);
	}

	@Override
	public boolean memberUpdate(MembersDto dto) {
		return memberMapper.memberUpdate(dto);
	}
	
	public String encryptData(String str) {
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] md5encrypt = md5.digest();
            
            for(int i = 0 ; i < md5encrypt.length ; i++){
                sb.append(Integer.toHexString((int)md5encrypt[i] & 0xFF));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return sb.toString();
    }

	@Override
	public void saveRefreshToken(String user_id, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);		
	}

	@Override
	public void deleRefreshToken(String user_id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);		
	}

	@Override
	public Object getRefreshToken(String user_id) throws Exception {
		return memberMapper.getRefreshToken(user_id);
	}

	@Override
	public String resetPwd(MembersDto mdto) {
		// 1. 입력된 정보에 해당하는 user가 있는지 확인
		MembersDto targetUser = memberMapper.selectMemberByIdAndEmail(mdto);
		if (targetUser == null) {
			return "fail";
		}
		
		// 2. 입력된 정보에 해당하는 user가 있다면
		// 2-1. 인증코드를 메일로 보내고
		// 2-2. 인증코드를 프론트에게로도 보낸다.
		String authCode = "123456"; // TODO : 랜덤 설정으로 바꾸기
		EmailDto edto = new EmailDto(mdto.getEmail(), "[EnjoyTrip] 인증코드", authCode);
		emailService.sendEmail(edto);
		return authCode;
	}

}
