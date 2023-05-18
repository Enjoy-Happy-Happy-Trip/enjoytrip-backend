package com.discovero.enjoytrip.tour.controller;

import java.util.List;

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
	public ResponseEntity<String> saveplan(@RequestBody String json, HttpSession session) {
	    ObjectMapper mapper = new ObjectMapper();
	    MembersDto mdto = (MembersDto) session.getAttribute("login");
	    String user_id = mdto.getUser_id();
	    
	    try {
	        String[] tmp = mapper.readValue(json, String[].class);
	        String plan_title = tmp[tmp.length-3];
	        String start_date = tmp[tmp.length-2];
	        String end_date = tmp[tmp.length-1];
	        
	        String[] placeNames = new String[tmp.length-3];
	        
	        for (int i = 0; i < tmp.length-3; i++) {
				placeNames[i] = tmp[i];
			}
	        
	        tourService.savePlan(placeNames, user_id, plan_title, start_date, end_date);
	        return ResponseEntity.ok("Success");
	    } catch (JsonProcessingException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting JSON to data");
	    }
	}
}
