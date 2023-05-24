package com.discovero.enjoytrip.place.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlaceMapper {
	void insertReview(PlaceReviewDto prDto);
	void deleteReviewById(int reviewId);
	List<PlaceReviewDto> selectAllPlaceReview();
	HotPlaceDto selectHotPlaceByContentId(int contentId);
	void updateHotPlaceReviewCountById(int content_id, int updateValue);
	List<HotPlaceDto> selectTopNPlace(int count);
	PlaceReviewDto getReview(int review_id);
	void insertHotPlace(int content_id);
	int getHotPlace(int content_id);
	void deleteZeroCountHotplace();
	List<Integer> selectContentIdsByUserId(String user_id);
	void updateSharedToFalseByUserId(String user_id);
}
