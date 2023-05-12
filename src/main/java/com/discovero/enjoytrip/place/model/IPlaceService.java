package com.discovero.enjoytrip.place.model;

import java.util.List;

import com.discovero.enjoytrip.attraction.model.AttractionDto;

public interface IPlaceService {
	void writeReview(PlaceReviewDto prDto);
	void deleteReviewById(int reviewId);
	List<PlaceReviewDto> findAllPlaceReview();
	List<AttractionDto> findTopPlace();
	PlaceReviewDto getReview(int review_id);
}
