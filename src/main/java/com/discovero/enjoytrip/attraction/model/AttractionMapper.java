package com.discovero.enjoytrip.attraction.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttractionMapper {

	List<AttractionDto> selectAttractionsBySearchInfo(AttractionSearchDto asDto);
	

}
