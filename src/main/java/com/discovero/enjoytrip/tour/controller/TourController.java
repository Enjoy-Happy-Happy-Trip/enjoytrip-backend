package com.discovero.enjoytrip.tour.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.discovero.enjoytrip.tour.model.ITourService;

@Controller
@RequestMapping("/tour")
public class TourController {
	private static final Logger logger = LoggerFactory.getLogger(TourController.class);
	
	private ITourService tourService;
	
	@Autowired
	public TourController(ITourService tourService) {
		this.tourService = tourService;
	}
	
	// TODO: Controller 메서드 구현
}
