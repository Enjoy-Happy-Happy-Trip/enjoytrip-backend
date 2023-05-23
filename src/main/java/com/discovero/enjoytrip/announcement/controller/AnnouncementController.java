package com.discovero.enjoytrip.announcement.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.announcement.model.AnnouncementDto;
import com.discovero.enjoytrip.announcement.model.IAnnouncementService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/announcement")
@Api("게시판 컨트롤러  API V1")
public class AnnouncementController {
	private final Logger logger = LoggerFactory.getLogger(AnnouncementController.class);
	
	private IAnnouncementService announcementService;

	public AnnouncementController(IAnnouncementService announcementService) {
		super();
		this.announcementService = announcementService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<AnnouncementDto>> announcementList() {
		logger.info("GET announcementList called");
		// TODO: api 작성
		
		return new ResponseEntity<List<AnnouncementDto>>(new ArrayList<AnnouncementDto>(), HttpStatus.OK);
	}
	
	@GetMapping("/{announcementId}")
	public ResponseEntity<AnnouncementDto> announcement(@PathVariable int announcementId) {
		logger.info("GET announcement called");
		// TODO: api 작성
		
		return new ResponseEntity<AnnouncementDto>(new AnnouncementDto(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Void> announcementAdd(@RequestBody AnnouncementDto adto) {
		logger.info("POST announcementAdd called");
		// TODO: api 작성
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{announcementId}")
	public ResponseEntity<Void> announcementModify(@PathVariable int announcementId) {
		logger.info("PUT announcementModify called");
		// TODO: api 작성
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{announcementId}")
	public ResponseEntity<Void> announcementRemove(@PathVariable int announcementId) {
		logger.info("DELETE announcementRemove called");
		// TODO: api 작성
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
