package com.discovero.enjoytrip.plan.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements IPlanService {
	
	private PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	@Override
	public List<UserSceduleDto> getMyPlan(String user_id) {
		List<UserSceduleDto> myScedules = planMapper.getMyPlan(user_id);
		
		for (int i = 0; i < myScedules.size(); i++) {
			System.out.println(myScedules.get(i).toString());
		}
		
		return myScedules;
	}

}
