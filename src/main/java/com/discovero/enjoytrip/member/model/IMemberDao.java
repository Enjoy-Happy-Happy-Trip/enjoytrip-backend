package com.ssafy.edu.model;

import java.util.List;

public interface IMemberDao {
	boolean registry(MembersDto dto);

	MembersDto login(MembersDto dto);

	String findpassword(String student_no);

	List<MembersDto> memberlist();

	MembersDto memberDetail(String user_id);

	boolean memberDelete(String user_id);

	boolean memberUpdate(MembersDto dto);

	String encryptData(String str);
}
