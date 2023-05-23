package com.discovero.enjoytrip.announcement.model;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

	private AnnouncementMapper announcementMapper;

	public AnnouncementServiceImpl(AnnouncementMapper announcementMapper) {
		super();
		this.announcementMapper = announcementMapper;
	}

	@Override
	public List<AnnouncementDto> findAllAnouncements() {
		return announcementMapper.selectAnnouncements();
	}

	@Override
	@Transactional
	public AnnouncementDto findAnnouncementById(int announcementId, boolean isViewed) {
		AnnouncementDto announcement = announcementMapper.selectAnnouncementById(announcementId);
		if (isViewed) {
			announcementMapper.updateHitByAddingOneById(announcementId);
		}
		return announcement;
	}

	@Override
	public void addAnnouncement(AnnouncementDto adto) {
		announcementMapper.insertAnnouncement(adto);
		
	}

	@Override
	public void modifyAnnouncementById(AnnouncementDto adto) {
		announcementMapper.updateAnnouncementById(adto);
		
	}

	@Override
	public void removeAnnouncementById(int announcementId) {
		announcementMapper.deleteAnnouncementById(announcementId);
	}
	
}
