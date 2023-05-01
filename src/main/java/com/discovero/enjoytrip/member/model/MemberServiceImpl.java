package com.discovero.enjoytrip.member.model;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {

	private MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public boolean registry(MembersDto dto) {
		dto.setUser_password(encryptData(dto.getUser_password()));
		return memberMapper.registry(dto);
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

}
