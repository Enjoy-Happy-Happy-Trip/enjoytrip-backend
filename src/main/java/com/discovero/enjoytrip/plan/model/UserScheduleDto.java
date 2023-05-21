package com.discovero.enjoytrip.plan.model;

import java.util.List;

import com.discovero.enjoytrip.attraction.model.AttractionDto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserScheduleDto : 사용자 스케줄 정보", description = "사용자 스케줄의 상세 정보를 나타낸다.")
public class UserScheduleDto {
	private int schedule_id;
	private String user_id;
	private int plan_id;
	private String schedule_title;
	private String start_date;
	private String end_date;
	private List<AttractionDto> attractions;
	
	public UserScheduleDto() {
		super();
	}

	public UserScheduleDto(int schedule_id, String user_id, int plan_id, String schedule_title, String start_date, String end_date) {
		super();
		this.schedule_id = schedule_id;
		this.user_id = user_id;
		this.plan_id = plan_id;
		this.schedule_title = schedule_title;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public UserScheduleDto(int schedule_id, String user_id, int plan_id, String start_date, String end_date) {
		super();
		this.schedule_id = schedule_id;
		this.user_id = user_id;
		this.plan_id = plan_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getSchedule_title() {
		return schedule_title;
	}

	public void setSchedule_title(String schedule_title) {
		this.schedule_title = schedule_title;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public List<AttractionDto> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<AttractionDto> attractions) {
		this.attractions = attractions;
	}
}
