package com.discovero.enjoytrip.plan.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.attraction.model.AttractionMapper;

@Service
public class PlanServiceImpl implements IPlanService {

	private PlanMapper planMapper;
	private AttractionMapper attractionMapper;

	public PlanServiceImpl(PlanMapper planMapper, AttractionMapper attractionMapper) {
		super();
		this.planMapper = planMapper;
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<UserScheduleDto> getMyPlan(String user_id, boolean isShared) {
		return planMapper.getMyPlan(user_id, isShared);
	}

	@Override
	public UserScheduleDto getDetail(int schedule_id) {
		UserScheduleDto udto = planMapper.getSchedule(schedule_id);
		udto.setAttractions(findAttractionsByPlanId(udto.getPlan_id()));
		return udto;
	}

	@Override
	public List<AttractionDto> findAttractionsByPlanId(int plan_id) {
		int[] attractionIds = planMapper.getAttractionId(plan_id);
		List<AttractionDto> attractions = new ArrayList<>();

		for (int id : attractionIds) {
			attractions.add(attractionMapper.selectAttractionById(id));
		}

		return attractions;
	}

	@Override
	public List<PlanDto> findAllPlans() {
		return planMapper.selectAllPlans();
	}

	@Override
	public PlanDto findPlanById(int planId) {
		return planMapper.selectPlanById(planId);
	}

	@Override
	public void modifyPlanDetail(PlanDto pdto) {
		planMapper.updatePlan(pdto);
	}

	@Override
	public List<UserScheduleDto> getPastPlan(String user_id) {
		return planMapper.getPastPlan(user_id);
	}

	@Override
	public List<UserScheduleDto> getFuturePlan(String user_id) {
		return planMapper.getFuturePlan(user_id);
	}

	@Override
	@Transactional
	public void deleteUserSchedule(int plan_id) {
		planMapper.deleteUserSchedule(plan_id);
		planMapper.deletePlanDetail(plan_id);
		planMapper.deletePlan(plan_id);
	}

	@Override
	public void deleteSharedPlan(int plan_id) {
		planMapper.deleteSharedPlan(plan_id);
	}


}
