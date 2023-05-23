package com.discovero.enjoytrip.plan.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.discovero.enjoytrip.attraction.model.AttractionDto;

@Mapper
public interface PlanMapper {
	List<UserScheduleDto> getMyPlan(String user_id, boolean isShared);
	int[] getAttractionId(int plan_id);
	UserScheduleDto getSchedule(int schedule_id);
	String getPlanTitle(int plan_id);
	List<PlanDto> selectAllPlans();
	PlanDto selectPlanById(int planId);
	void updatePlan(PlanDto pdto);
	List<UserScheduleDto> getPastPlan(String user_id);
	List<UserScheduleDto> getFuturePlan(String user_id);
	void deletePlanDetail(int plan_id);
	void deletePlan(int plan_id);
	void deleteUserSchedule(int plan_id);
}
