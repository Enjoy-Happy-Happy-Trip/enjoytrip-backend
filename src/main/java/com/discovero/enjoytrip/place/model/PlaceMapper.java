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
	void updateReviewCount(@Param("contentId") int contentId, @Param("updateValue") int updateValue);
	List<HotPlaceDto> selectTopNPlace(int count);
}
