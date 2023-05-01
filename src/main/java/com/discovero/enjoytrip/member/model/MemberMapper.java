package com.discovero.enjoytrip.member.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	// TODO: MemberMapper 구현하기
	
	boolean registry(MembersDto dto);

	MembersDto login(MembersDto dto);

	String findpassword(String student_no);

	List<MembersDto> memberlist();

	MembersDto memberDetail(String user_id);

	boolean memberDelete(String user_id);

	boolean memberUpdate(MembersDto dto);
}
