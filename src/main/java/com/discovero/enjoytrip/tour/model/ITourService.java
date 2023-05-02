package com.discovero.enjoytrip.tour.model;

import java.util.List;

public interface ITourService {
	List<TourDto> tourlist(int sido_code, int content_type_id, String word);
	TourDto tourDetail(int article_no);
	void savePlan(String[] placeNames, String user_id);
}
