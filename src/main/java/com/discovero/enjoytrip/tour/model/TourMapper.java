package com.discovero.enjoytrip.tour.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TourMapper {
	List<TourDto> tourlist(Map<String, Object> map);
	TourDto tourDetail(int article_no);
	void savePlan(String placeName); 
	int getLastInsertId();
	int getContentId(String placeName);
	void savePlanDetail(int content_id, int plan_id, int order);
	void saveUserSchedule(String user_id, int plan_id);
}
