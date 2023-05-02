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
	public void savePlan(String[] placeNames) {
		for (String placeName : placeNames) {
			tourMapper.savePlan(placeName);
		}
	}

}
