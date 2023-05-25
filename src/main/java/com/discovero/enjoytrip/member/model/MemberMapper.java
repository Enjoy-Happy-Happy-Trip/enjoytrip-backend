package com.discovero.enjoytrip.member.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	// TODO: MemberMapper 구현하기
	
	boolean register(MembersDto dto);

	MembersDto login(MembersDto dto);

	String findpassword(String student_no);

	List<MembersDto> selectMembers();

	MembersDto memberDetail(String user_id);

	void deleteMemeberById(String user_id);

	boolean memberUpdate(MembersDto dto);

	void saveRefreshToken(Map<String, String> map) throws SQLException;
	
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	Object getRefreshToken(String user_id) throws SQLException;

	MembersDto selectMemberByIdAndEmail(MembersDto mdto);

	void updatePasswordById(MembersDto mdto);

	MembersDto selectMemberById(String userId);

}
