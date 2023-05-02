package com.discovero.enjoytrip.place.model;

import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements IPlaceService {
	
	private PlaceMapper placeMapper;
	
	public PlaceServiceImpl(PlaceMapper placeMapper) {
		super();
		this.placeMapper = placeMapper;
	}
}
