package com.discovero.enjoytrip.plan.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanMapper {
	List<PlanDto> getMyPlan(String user_id);
}
