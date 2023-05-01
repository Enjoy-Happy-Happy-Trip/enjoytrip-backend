package com.discovero.enjoytrip.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	boolean boardWrite(BoardDto dto);

	List<BoardDto> boardlist();

	BoardDto boardDetail(int article_no);

	boolean updateHit(int article_no);

	boolean delete(int article_no);
	
	boolean updateBoard(BoardDto dto);

	List<BoardDto> boardSearch();
}
