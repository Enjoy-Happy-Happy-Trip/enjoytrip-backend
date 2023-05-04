package com.discovero.enjoytrip.plan.model;

import java.util.List;

public interface IPlanService {

	List<PlanDto> getMyPlan(String user_id);
	
}
