package com.discovero.enjoytrip.announcement.model;

import java.util.List;

public interface IAnnouncementService {

	List<AnnouncementDto> findAllAnouncements();

	AnnouncementDto findAnnouncementById(int announcementId, boolean isViewed);

	void addAnnouncement(AnnouncementDto adto);

	void modifyAnnouncementById(AnnouncementDto adto);

	void removeAnnouncementById(int announcementId);

}
