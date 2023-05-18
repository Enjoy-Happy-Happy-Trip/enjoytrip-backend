package com.discovero.enjoytrip.member.model;

import java.util.List;

public interface IMemberService {
	boolean register(MembersDto dto);

	MembersDto login(MembersDto dto);
	
	String findpassword(String student_no);

	List<MembersDto> memberlist();

	MembersDto memberDetail(String user_id);

	boolean memberDelete(String user_id);

	boolean memberUpdate(MembersDto dto);

	void saveRefreshToken(String user_id, String refreshToken) throws Exception;
	
	void deleRefreshToken(String user_id) throws Exception;
	
	Object getRefreshToken(String user_id) throws Exception;

}
