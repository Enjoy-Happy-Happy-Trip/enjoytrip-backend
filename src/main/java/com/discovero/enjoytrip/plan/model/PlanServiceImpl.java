package com.discovero.enjoytrip.plan.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
	public List<UserScheduleDto> getMyPlan(String user_id) {
		List<UserScheduleDto> mySchedules = planMapper.getMyPlan(user_id);
		
		for (int i = 0; i < mySchedules.size(); i++) {
			System.out.println(mySchedules.get(i).toString());
		}
		
		return mySchedules;
	}

	@Override
	public UserScheduleDto getDetail(int schedule_id) {
		UserScheduleDto udto = planMapper.getSchedule(schedule_id);
		udto.setAttractions(findAttractionsByPlanId(udto.getPlan_id()));
		
		String plan_title = planMapper.getPlanTitle(udto.getPlan_id());
		udto.setPlan_title(plan_title);
		
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
		planMapper.updatePlanDesc(pdto);
	}

}
