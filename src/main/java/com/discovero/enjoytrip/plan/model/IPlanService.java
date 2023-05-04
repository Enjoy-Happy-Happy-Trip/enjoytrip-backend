package com.discovero.enjoytrip.plan.model;

import java.util.List;

public interface IPlanService {

	List<UserSceduleDto> getMyPlan(String user_id);
	
}
