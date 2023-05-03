package com.discovero.enjoytrip.place.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements IPlaceService {
	static final int INCREASE = 1;
	static final int DECREASE = -1;
	
	private PlaceMapper placeMapper;
	
	public PlaceServiceImpl(PlaceMapper placeMapper) {
		super();
		this.placeMapper = placeMapper;
	}

	@Override
	public void writeReview(PlaceReviewDto prDto) {
		placeMapper.insertReview(prDto);
		placeMapper.updateHotPlaceReviewCountById(prDto.getReview_id(), INCREASE);
	}

	@Override
	public void deleteReviewById(int reviewId) {
		placeMapper.deleteReviewById(reviewId);
		placeMapper.updateHotPlaceReviewCountById(reviewId, DECREASE);
	}

	@Override
	public List<PlaceReviewDto> findtAllPlaceReview() {
		return placeMapper.selectAllPlaceReview();
	}

	@Override
	public List<HotPlaceDto> findTopNPlace(int count) {
		return placeMapper.selectTopNPlace(count);
	}
	
	
}
