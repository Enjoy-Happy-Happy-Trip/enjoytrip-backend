package com.discovero.enjoytrip.place.model;

import java.util.List;

public interface IPlaceService {
	void writeReview(PlaceReviewDto prDto);
	void deleteReviewById(int reviewId);
	List<PlaceReviewDto> findtAllPlaceReview();
	List<HotPlaceDto> findTopNPlace(int count);
}
