package com.discovero.enjoytrip.place.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.attraction.model.AttractionMapper;

@Service
public class PlaceServiceImpl implements IPlaceService {
	static final int INCREASE = 1;
	static final int DECREASE = -1;
	static final int HOT_PLACE_CNT = 100;
	
	private PlaceMapper placeMapper;
	private AttractionMapper attractionMapper;
	
	public PlaceServiceImpl(PlaceMapper placeMapper, AttractionMapper attractionMapper) {
		super();
		this.placeMapper = placeMapper;
		this.attractionMapper = attractionMapper;
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
	public List<PlaceReviewDto> findAllPlaceReview() {
		List<PlaceReviewDto> reviews = placeMapper.selectAllPlaceReview();
		
		System.out.println("reviews successfully called");
		
		for (PlaceReviewDto review : reviews) {
			review.setTitle(attractionMapper.selectAttractionById(review.getContent_id()).getTitle());
		}
		
		return reviews;
	}

	@Override
	public List<AttractionDto> findTopPlace() {
		List<HotPlaceDto> hotList = placeMapper.selectTopNPlace(HOT_PLACE_CNT);
		return hotList.stream()
				.map(hotplace -> attractionMapper.selectAttractionById(hotplace.getContent_id()))
				.collect(Collectors.toList());
	}
}
