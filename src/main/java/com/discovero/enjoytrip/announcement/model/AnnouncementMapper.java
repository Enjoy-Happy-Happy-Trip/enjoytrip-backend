package com.discovero.enjoytrip.announcement.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnnouncementMapper {

	List<AnnouncementDto> selectAnnouncements();

	AnnouncementDto selectAnnouncementById(int announcementId);

	void updateHitByAddingOneById(int announcementId);

	void insertAnnouncement(AnnouncementDto adto);

	void updateAnnouncementById(AnnouncementDto adto);

	void deleteAnnouncementById(int announcementId);

}
