package com.discovero.enjoytrip.plan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.plan.model.IPlanService;
import com.discovero.enjoytrip.plan.model.PlanDto;
import com.discovero.enjoytrip.plan.model.UserScheduleDto;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/plan")
@Api("여행계획 컨트롤러  API V1")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	private IPlanService planService;
	
	@Autowired
	public PlanController(IPlanService planService) {
		this.planService = planService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<PlanDto>> planList() throws Exception {
		logger.info("GET planList called");
		List<PlanDto> plans = planService.findAllPlans();
		return new ResponseEntity<List<PlanDto>>(plans, HttpStatus.OK);
	}
	
	@GetMapping("/{plan_id}")
	public ResponseEntity<PlanDto> plan(@PathVariable int plan_id) throws Exception {
		logger.info("GET plan called");
		PlanDto plan = planService.findPlanById(plan_id);
		return new ResponseEntity<PlanDto>(plan, HttpStatus.OK);
	}
	
	@PutMapping("/{plan_id}")
	public ResponseEntity<Void> planDetailModify(@PathVariable int plan_id, @RequestBody PlanDto pdto) throws Exception {
		logger.info("PUT planDetailModify called, planDesc : {}", pdto);
		planService.modifyPlanDetail(pdto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/getmyplan/{user_id}")
	public List<UserScheduleDto> getmyplan(@PathVariable String user_id, @RequestParam(value = "unshared", defaultValue="true") boolean shared) throws Exception {
		logger.info("GET getmyplan called, isShared -> {}", !shared);
		return planService.getMyPlan(user_id, !shared);
	}
	
	@GetMapping("/getplans/{user_id}")
	public List<UserScheduleDto> getmyplan(@PathVariable String user_id, @RequestParam(value = "time") int time) throws Exception {
		logger.info("GET getplans called, time -> {}", time);
		List<UserScheduleDto> schedule;
		
		if(time == 1) {
			schedule = planService.getPastPlan(user_id);
		} else {
			schedule = planService.getFuturePlan(user_id);
		}
		
		return schedule;
	}
	

	// plan_detail을 조회해서 plan_detail에 들어있는 content_id의 Attraction
	@GetMapping("/detail/{plan_id}")
	public ResponseEntity<List<AttractionDto>> detail(@PathVariable int plan_id) throws Exception {
		logger.debug("GET detail called");
		
		// plan 리스트랑 각각의 사진
		List<AttractionDto> planDetails = planService.findAttractionsByPlanId(plan_id);
		
		return new ResponseEntity<List<AttractionDto>>(planDetails, HttpStatus.OK);
	}
	
	@GetMapping("/mydetail/{schedule_id}")
	public UserScheduleDto detail(@PathVariable String schedule_id) throws Exception {
		logger.debug("GET mydetail called");
		
		int id = Integer.parseInt(schedule_id);
		
		UserScheduleDto schedule = planService.getDetail(id);
		
		return schedule;
	}
	
	@DeleteMapping("/{plan_id}")
	public void deleteUserSchedule(@PathVariable int plan_id) throws Exception {
		logger.debug("DELETE deleteUserSchedule called");
				
		planService.deleteUserSchedule(plan_id);
	}
	
	@PutMapping("/shared/{plan_id}")
	public void deleteSharedPlan(@PathVariable int plan_id) throws Exception {
		logger.debug("PUT deleteSharedPlan called");
		
		planService.deleteSharedPlan(plan_id);
	}
	
	@PutMapping("/myplan/{scheduleId}")
	public ResponseEntity<Void> scheduleModify(
			@RequestBody UserScheduleDto udto,
			@RequestParam(value="planmodified", defaultValue = "true") boolean hasPlanModified) {
		logger.debug("PUT scheduleModify called, Schedule : {}", udto);
		logger.debug("plan modified : {}", hasPlanModified);
		planService.modifySchedule(udto, hasPlanModified);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}















