package com.discovero.enjoytrip.plan.model;

import java.util.List;

import com.discovero.enjoytrip.attraction.model.AttractionDto;

public interface IPlanService {

	List<UserScheduleDto> getMyPlan(String user_id, boolean isShared);
	
	List<AttractionDto> findAttractionsByPlanId(int plan_id);

	UserScheduleDto getDetail(int schedule_id);

	List<PlanDto> findAllPlans();

	PlanDto findPlanById(int planId);

	void modifyPlanDetail(PlanDto pdto);

	List<UserScheduleDto> getPastPlan(String user_id);

	List<UserScheduleDto> getFuturePlan(String user_id);

	void deleteUserSchedule(int plan_id);

	void deleteSharedPlan(int plan_id);
	
}
