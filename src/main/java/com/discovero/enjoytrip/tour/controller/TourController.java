package com.discovero.enjoytrip.tour.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.member.model.MembersDto;
import com.discovero.enjoytrip.tour.model.ITourService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.discovero.enjoytrip.tour.model.SidoGugunCodeDto;
import com.discovero.enjoytrip.tour.model.UserPlanDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/tour")
@Api("사용자 계획 컨트롤러  API V1")
public class TourController {
	private static final Logger logger = LoggerFactory.getLogger(TourController.class);

	private ITourService tourService;

	@Autowired
	public TourController(ITourService tourService) {
		this.tourService = tourService;
	}

	@ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		logger.info("sido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(tourService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군 정보", notes = "전국의 구군을 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(
			@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
		logger.info("gugun - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(tourService.getGugunInSido(sido), HttpStatus.OK);
	}

	@PostMapping("/saveplan")
	public ResponseEntity<String> saveplan(@RequestBody UserPlanDto udto) {
		logger.info("saveplan - 호출");
		
		String[] places = udto.getPlan();
		int[] content_ids = udto.getContent_ids();
		String user_id = udto.getUser_id();
		String plan_title = udto.getPlanTitle();
		String start_date = udto.getStartDate();
		String end_date = udto.getEndDate();
		
		tourService.savePlan(places, content_ids, user_id, plan_title, start_date, end_date);
		return ResponseEntity.ok("Success");
	}
	
}
