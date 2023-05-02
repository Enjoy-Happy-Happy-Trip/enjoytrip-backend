package com.discovero.enjoytrip.attraction.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AttractionServiceImpl implements IAttractionService{
	
	private AttractionMapper attractionMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<AttractionDto> searchAttractionList(AttractionSearchDto asDto) {
		return attractionMapper.selectAttractionsBySearchInfo(asDto);
	}
}
