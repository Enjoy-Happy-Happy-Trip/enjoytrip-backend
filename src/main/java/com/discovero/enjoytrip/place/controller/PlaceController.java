package com.discovero.enjoytrip.place.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.discovero.enjoytrip.place.model.IPlaceService;

@Controller
@RequestMapping("place")
public class PlaceController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

	private IPlaceService placeService;
	
	@Autowired
	public PlaceController(IPlaceService placeService) {
		this.placeService = placeService;
	}
	
	
}
