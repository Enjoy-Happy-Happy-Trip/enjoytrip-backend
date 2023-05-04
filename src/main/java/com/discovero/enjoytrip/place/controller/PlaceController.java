package com.discovero.enjoytrip.place.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.place.model.IPlaceService;
import com.discovero.enjoytrip.place.model.PlaceReviewDto;

@Controller
@RequestMapping("place")
public class PlaceController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

	private IPlaceService placeService;
	
	@Autowired
	public PlaceController(IPlaceService placeService) {
		this.placeService = placeService;
	}
	
	
	@PostMapping("/writereview")
	public String write(PlaceReviewDto prDto) {
		logger.debug("POST write called");
		placeService.writeReview(prDto);
		// TODO: review 게시판 구현시 변경하기
		return "redirect:/";
	}
	
	@GetMapping("/reviewlist")
	@ResponseBody
	public List<PlaceReviewDto> reviewlist() {
		logger.info("GET reviewlist called");
		List<PlaceReviewDto> list = placeService.findAllPlaceReview();
		return list;
	}
	
	@DeleteMapping("/deletereview")
	public String deletereivew(int reviewId) {
		logger.debug("DELETE deletereivew called");
		placeService.deleteReviewById(reviewId);
		// TODO: review 게시판 구현시 변경하기
		return "redirect:/";
	}
	
	@GetMapping("/hotplace")
	@ResponseBody
	public List<AttractionDto> hotplace() {
		logger.debug("GET hotplace called");
		List<AttractionDto> hotplaces = placeService.findTopPlace();
		return hotplaces;
	}
	
}
