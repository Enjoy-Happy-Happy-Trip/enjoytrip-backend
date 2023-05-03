package com.discovero.enjoytrip.tour.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements ITourService {
	
	private TourMapper tourMapper;

	public TourServiceImpl(TourMapper tourMapper) {
		super();
		this.tourMapper = tourMapper;
	}

	@Override
	public TourDto tourDetail(int article_no) {
		return tourMapper.tourDetail(article_no);
	}

	@Override
	public List<TourDto> tourlist(int sido_code, int content_type_id, String word) {
		Map<String, Object> map = new HashMap<>();
		map.put("sideCode", sido_code);
		map.put("contentTypeId", content_type_id);
		map.put("word", word);
		return tourMapper.tourlist(map);
	}

	@Override
	public void savePlan(String[] placeNames, String user_id, String plan_title, String start_date, String end_date) {
		tourMapper.savePlan(user_id, plan_title);
		
		int order = 1;
		int plan_id = tourMapper.getLastInsertId();

		for (String placeName : placeNames) {
			int content_id = tourMapper.getContentId(placeName);
			System.out.println(content_id);
			
			tourMapper.savePlanDetail(content_id, plan_id, order++);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("plan_id", plan_id);
		map.put("start_date", start_date);
		map.put("end_date", end_date);
		
		tourMapper.saveUserSchedule(map);
	}

}
