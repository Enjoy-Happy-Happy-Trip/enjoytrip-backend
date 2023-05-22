package com.discovero.enjoytrip.attraction.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.discovero.enjoytrip.util.PageNavigation;

@Service
public class AttractionServiceImpl implements IAttractionService{
	
	private AttractionMapper attractionMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<AttractionDto> searchAttractionList(AttractionSearchDto asDto) {
		int offset = (asDto.getPageNo()-1) * PageNavigation.COUNT_PER_PAGE;
		asDto.setOffset(offset);
		asDto.setItemCount(PageNavigation.COUNT_PER_PAGE);
		return attractionMapper.selectAttractionsBySearchInfo(asDto);
	}
	
	@Override
	public PageNavigation findPageNavInfo(AttractionSearchDto asDto) {
		// page nav에서 몇번째인지
		int pageNo = asDto.getPageNo();
		int totalCount = attractionMapper.selectCountBySearchInfo(asDto);
		
		return new PageNavigation(pageNo, totalCount);
		
		
	}
	

	@Override
	public AttractionDto selectAttractionById(int content_id) {
		return attractionMapper.selectAttractionById(content_id);
	}
}
