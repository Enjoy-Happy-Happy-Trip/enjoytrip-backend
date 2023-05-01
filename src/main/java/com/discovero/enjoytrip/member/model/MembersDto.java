package com.discovero.enjoytrip.member.model;

public class MembersDto {
	private String user_id;
	private String user_name;
	private String user_password;
	private String email_id;
	private String email_domain;
	private String join_date;
	private String student_no;
	private int flag;

	public MembersDto() {
		super();
	}

	public MembersDto(String user_id, String user_name, String user_password, String email_id, String email_domain,
			String join_date, String student_no, int flag) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.email_id = email_id;
		this.email_domain = email_domain;
		this.join_date = join_date;
		this.student_no = student_no;
		this.flag = flag;
	}
	
	public MembersDto(String user_id, String user_name, String user_password, String email_id, String email_domain,
			String join_date, String student_no) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.email_id = email_id;
		this.email_domain = email_domain;
		this.join_date = join_date;
		this.student_no = student_no;
	}

	public MembersDto(String user_id, String user_name, String user_password, String email_id, String email_domain, String student_no, int flag) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.email_id = email_id;
		this.email_domain = email_domain;
		this.student_no = student_no;
		this.flag = flag;
	}
	
	public MembersDto(String user_id, String user_name, String user_password, String email_id, String email_domain, String student_no) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.email_id = email_id;
		this.email_domain = email_domain;
		this.student_no = student_no;
	}
	
	public MembersDto(String user_id, String user_name, String user_password, String email_id, String email_domain) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.email_id = email_id;
		this.email_domain = email_domain;
	}

	public MembersDto(String user_id, String user_password) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
	}

	@Override
	public String toString() {
		return "MembersDto [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", email_id=" + email_id + ", email_domain=" + email_domain + ", join_date=" + join_date + "]";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
