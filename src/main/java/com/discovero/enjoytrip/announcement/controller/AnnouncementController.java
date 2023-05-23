package com.discovero.enjoytrip.announcement.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.discovero.enjoytrip.announcement.model.AnnouncementDto;
import com.discovero.enjoytrip.announcement.model.IAnnouncementService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/announcement")
@Api("공지사항 컨트롤러  API V1")
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
		List<AnnouncementDto> announcements = announcementService.findAllAnouncements();
		return new ResponseEntity<List<AnnouncementDto>>(announcements, HttpStatus.OK);
	}
	
	@GetMapping("/{announcementId}")
	public ResponseEntity<AnnouncementDto> announcement(
			@PathVariable int announcementId, 
			@RequestParam(value = "viewcount", defaultValue = "false") boolean isViewed) {
		logger.info("GET announcement called");
		AnnouncementDto announcement = announcementService.findAnnouncementById(announcementId, isViewed);
		return new ResponseEntity<AnnouncementDto>(announcement, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Void> announcementAdd(@RequestBody AnnouncementDto adto) {
		logger.info("POST announcementAdd called");
		announcementService.addAnnouncement(adto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{announcementId}")
	public ResponseEntity<Void> announcementModify(@RequestBody AnnouncementDto adto) {
		logger.info("PUT announcementModify called");
		announcementService.modifyAnnouncementById(adto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{announcementId}")
	public ResponseEntity<Void> announcementRemove(@PathVariable int announcementId) {
		announcementService.removeAnnouncementById(announcementId);
		logger.info("DELETE announcementRemove called");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
