package com.discovero.enjoytrip.place.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void writeReview(PlaceReviewDto prDto) {
		placeMapper.insertReview(prDto);
		
		if(placeMapper.getHotPlace(prDto.getContent_id()) > 0) {			
			placeMapper.updateHotPlaceReviewCountById(prDto.getContent_id(), INCREASE);
			return;
		}
		
		placeMapper.insertHotPlace(prDto.getContent_id());
		placeMapper.updateHotPlaceReviewCountById(prDto.getContent_id(), INCREASE);
	}

	@Override
	@Transactional
	public void deleteReviewById(int reviewId, int content_id) {
		placeMapper.deleteReviewById(reviewId);
		placeMapper.updateHotPlaceReviewCountById(content_id, DECREASE);
		placeMapper.deleteZeroCountHotplace();
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
				.map(hotplace -> {
					AttractionDto adto = attractionMapper.selectAttractionById(hotplace.getContent_id());
					adto.setReview_count(hotplace.getReview_count());
					return adto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public PlaceReviewDto getReview(int review_id) {
		PlaceReviewDto review = placeMapper.getReview(review_id);
		review.setTitle(attractionMapper.selectAttractionById(review.getContent_id()).getTitle());
		return review;
	}
}
