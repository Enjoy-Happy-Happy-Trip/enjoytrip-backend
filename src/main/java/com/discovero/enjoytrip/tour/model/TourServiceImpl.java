package com.ssafy.edu.model;

import java.util.List;

public class TourServiceImpl implements ITourService {
	
	private static ITourService tservice = new TourServiceImpl();
	
	private TourServiceImpl() {
		tdao = new TourDaoImpl();
	}
	
	public static ITourService getInstance() {
		return tservice;
	}
	
	private ITourDao tdao;
	

	@Override
	public TourDto tourDetail(int article_no) {
		return tdao.tourDetail(article_no);
	}

	@Override
	public List<TourDto> tourlist(int sido_code, int content_type_id, String word) {
		// TODO Auto-generated method stub
		return tdao.tourlist(sido_code, content_type_id, word);
	}

	@Override
	public boolean savePlan(String[] placeNames) {
		return tdao.savePlan(placeNames);
	}

}
