package com.ssafy.edu.model;

import java.util.List;

public class MemberServiceImpl implements IMemberService {

	private static IMemberService mservice = new MemberServiceImpl();

	private MemberServiceImpl() {
		mdao = new MemberDaoImpl();
	}

	public static IMemberService getInstance() {
		return mservice;
	}

	private IMemberDao mdao;

	@Override
	public boolean registry(MembersDto dto) {
		return mdao.registry(dto);
	}

	@Override
	public MembersDto login(MembersDto dto) {
		return mdao.login(dto);
	}

	@Override
	public String findpassword(String student_no) {
		return mdao.findpassword(student_no);
	}

	@Override
	public List<MembersDto> memberlist() {
		return mdao.memberlist();
	}

	@Override
	public MembersDto memberDetail(String user_id) {
		return mdao.memberDetail(user_id);
	}

	@Override
	public boolean memberDelete(String user_id) {
		return mdao.memberDelete(user_id);
	}

	@Override
	public boolean memberUpdate(MembersDto dto) {
		return mdao.memberUpdate(dto);
	}

}
