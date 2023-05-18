package com.discovero.enjoytrip.plan.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.discovero.enjoytrip.attraction.model.AttractionDto;

@Mapper
public interface PlanMapper {
	List<UserScheduleDto> getMyPlan(String user_id);
	int[] getAttractionId(int plan_id);
	UserScheduleDto getSchedule(int schedule_id);
	String getPlanTitle(int plan_id);
	List<PlanDto> selectAllPlans();
}
