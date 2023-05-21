package com.discovero.enjoytrip.tour.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void savePlan(String[] placeNames, int[] content_ids, String user_id, String schedule_title, String start_date, String end_date) {
		tourMapper.savePlan();
		
		int order = 1;
		int plan_id = tourMapper.getLastInsertId();
		
		for (int i = 0; i < content_ids.length; i++) {
			tourMapper.savePlanDetail(content_ids[i], plan_id, order++);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("plan_id", plan_id);
		map.put("schedule_title", schedule_title);
		map.put("start_date", start_date);
		map.put("end_date", end_date);
		
		tourMapper.saveUserSchedule(map);
	}

	@Override
	public List<SidoGugunCodeDto> getSido() {
		return tourMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) {
		return tourMapper.getGugunInSido(sido);
	}

}
