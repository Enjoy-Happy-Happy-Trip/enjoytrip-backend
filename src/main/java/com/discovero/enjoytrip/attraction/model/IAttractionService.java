package com.discovero.enjoytrip.attraction.model;

import java.util.List;

import com.discovero.enjoytrip.util.PageNavigation;

public interface IAttractionService {

	List<AttractionDto> searchAttractionList(AttractionSearchDto asDto);
	AttractionDto selectAttractionById(int content_id);
	PageNavigation findPageNavInfo(AttractionSearchDto asDto);
}
