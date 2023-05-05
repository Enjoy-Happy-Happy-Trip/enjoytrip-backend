package com.discovero.enjoytrip.plan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.member.model.MembersDto;
import com.discovero.enjoytrip.plan.model.IPlanService;
import com.discovero.enjoytrip.plan.model.UserScheduleDto;

@RestController
@RequestMapping("/plan")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	private IPlanService planService;
	
	@Autowired
	public PlanController(IPlanService planService) {
		this.planService = planService;
	}
	
	@GetMapping("/getmyplan")
	public List<UserScheduleDto> getmyplan(HttpSession session) throws Exception {
		logger.info("GET getmyplan called");
		
		MembersDto mdto = (MembersDto) session.getAttribute("login");
		String user_id = mdto.getUser_id();
		
		List<UserScheduleDto> schedules = planService.getMyPlan(user_id);
		
		return schedules;
	}
	
	@GetMapping("/detail/{schedule_id}")
	@ResponseBody
	public UserScheduleDto detail(HttpSession session, @PathVariable int schedule_id) throws Exception {
		logger.debug("GET detail called");
		
		UserScheduleDto schedule = planService.getDetail(schedule_id);
		
		return schedule;
	}
}














