package com.discovero.enjoytrip.member.model;

public class ResetPwdInfoDto {
	private String userId;
	private String authCode;
	public ResetPwdInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ResetPwdInfoDto(String authCode) {
		super();
		this.authCode = authCode;
	}

	public ResetPwdInfoDto(String userId, String authCode) {
		super();
		this.userId = userId;
		this.authCode = authCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
}
