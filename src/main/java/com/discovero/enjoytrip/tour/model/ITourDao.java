package com.ssafy.edu.model;

import java.util.List;

public interface ITourDao {
	List<TourDto> tourlist(int sido_code, int content_type_id, String word);
	TourDto tourDetail(int article_no);
	boolean savePlan(String[] placeNames);
}
