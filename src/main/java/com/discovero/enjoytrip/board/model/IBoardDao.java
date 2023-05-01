package com.ssafy.edu.model;

import java.util.List;

public interface IBoardDao {
	boolean boardWrite(BoardDto dto);

	List<BoardDto> boardlist();

	BoardDto boardDetail(int article_no);

	boolean updateHit(int article_no);

	boolean delete(int article_no);
	
	boolean updateBoard(BoardDto dto);

	List<BoardDto> boardSearch(String category, String keyword);

}
