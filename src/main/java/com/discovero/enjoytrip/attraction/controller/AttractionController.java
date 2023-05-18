package com.discovero.enjoytrip.attraction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.attraction.model.AttractionSearchDto;
import com.discovero.enjoytrip.attraction.model.IAttractionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/attraction")
@Api("장소 컨트롤러  API V1")
public class AttractionController {
	private static final Logger logger = LoggerFactory.getLogger(AttractionController.class);
	
	private IAttractionService attractionService;
	
	@Autowired
	public AttractionController(IAttractionService attractionService) {
		this.attractionService = attractionService;
	}
	
	// 관광지 검색시 조건에 맞는 관광지 List를 반환합니다.
	@ApiOperation(value = "장소 리스트 불러오기", notes = "모든 장소를 불러온다", response = String.class)
	@GetMapping("/attractionlist")
	@ResponseBody
	public List<AttractionDto> attractionlist(AttractionSearchDto asDto) throws Exception {
		logger.info("GET attractionlist called, asDto : {}", asDto);
		List<AttractionDto> list = attractionService.searchAttractionList(asDto);
		logger.info("GET attractionlist return list : {}", list);
		return list;
	}
	
	@ApiOperation(value = "장소 불러오기", notes = "content_id를 기반으로 특정 장소를 불러온다.", response = String.class)
	@GetMapping("/{content_id}")
	@ResponseBody
	public AttractionDto attraction(String content_id) {
		logger.info("GET attraction called, content_id : {}", content_id);
		AttractionDto attr = attractionService.selectAttractionById(Integer.parseInt(content_id));
		logger.info("GET attraction return attraction : {}", attr);
		return attr;
	}
	
}
