package com.discovero.enjoytrip.tour.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TourMapper {
	List<TourDto> tourlist(Map<String, Object> map);
	TourDto tourDetail(int article_no); // TODO: xml에 구현하기
	void savePlan(String placeName); // TODO: xml에 구현하기
}
