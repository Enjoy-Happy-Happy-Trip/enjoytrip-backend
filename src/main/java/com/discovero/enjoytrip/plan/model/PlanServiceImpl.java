package com.discovero.enjoytrip.plan.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.attraction.model.AttractionMapper;
import com.discovero.enjoytrip.tour.model.TourMapper;
import com.discovero.enjoytrip.tour.model.UserPlanDto;

@Service
public class PlanServiceImpl implements IPlanService {
	private static final int NOT_MODIFIED = -1;

	private PlanMapper planMapper;
	private AttractionMapper attractionMapper;
	private TourMapper tourMapper;

	public PlanServiceImpl(PlanMapper planMapper, 
			AttractionMapper attractionMapper, TourMapper tourMapper) {
		super();
		this.planMapper = planMapper;
		this.attractionMapper = attractionMapper;
		this.tourMapper = tourMapper;
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

	@Override
	@Transactional
	public void modifySchedule(UserScheduleDto udto, boolean hasPlanModified) {
		udto.setPlan_id(NOT_MODIFIED);
		if (hasPlanModified) {
			tourMapper.savePlan();
			
			int order = 1;
			int plan_id = tourMapper.getLastInsertId();
			udto.setPlan_id(plan_id);
			
			for (AttractionDto adto : udto.getAttractions()) {
				tourMapper.savePlanDetail(adto.getContentId(), plan_id, order++);
			}
		}
		
		planMapper.updateScheduleById(udto);
		
	}

	@Override
	public void addScheduleByScraping(UserScheduleDto udto) {
		planMapper.insertScheduleByScraping(udto);
	}
	
	
}
