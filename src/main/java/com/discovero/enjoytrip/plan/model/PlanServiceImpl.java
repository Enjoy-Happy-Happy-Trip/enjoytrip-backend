package com.discovero.enjoytrip.plan.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.discovero.enjoytrip.tour.model.TourMapper;

@Service
public class PlanServiceImpl implements IPlanService {
	
	private PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	@Override
	public List<PlanDto> getMyPlan(String user_id) {
		List<PlanDto> myPlan = planMapper.getMyPlan(user_id);
		
		for (int i = 0; i < myPlan.size(); i++) {
			System.out.println(myPlan.get(i).toString());
		}
		
		return myPlan;
	}

}
