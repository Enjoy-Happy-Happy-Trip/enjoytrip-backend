package com.discovero.enjoytrip.place.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.attraction.model.AttractionDto;
import com.discovero.enjoytrip.member.model.MembersDto;
import com.discovero.enjoytrip.place.model.IPlaceService;
import com.discovero.enjoytrip.place.model.PlaceReviewDto;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("place")
@Api("여행지 컨트롤러  API V1")
public class PlaceController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

	private IPlaceService placeService;
	
	@Autowired
	public PlaceController(IPlaceService placeService) {
		this.placeService = placeService;
	}
	
	@PostMapping("/writereview")
	@ResponseBody
	public ResponseEntity<String> write(@RequestBody PlaceReviewDto prDto) {
		logger.info("POST write called");
		logger.info("received review : {}", prDto);
		placeService.writeReview(prDto);
		// TODO: review 게시판 구현시 변경하기
		return ResponseEntity.ok("review was written successfully!");
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
	
	@GetMapping("/detail/{review_id}")
	@ResponseBody
	public PlaceReviewDto review(@PathVariable String review_id) throws Exception {
		logger.debug("GET review called");
		PlaceReviewDto rv = placeService.getReview(Integer.parseInt(review_id));
		return rv;
	}
	
	/*
	 * @GetMapping("/detail/{planId}")
	 * 
	 * @ResponseBody public <>
	 */
	
}
