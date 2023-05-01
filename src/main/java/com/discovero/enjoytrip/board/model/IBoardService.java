package com.discovero.enjoytrip.board.model;

import java.util.List;

public interface IBoardService {
	boolean boardWrite(BoardDto dto);

	List<BoardDto> boardlist();

	BoardDto boardDetail(int article_no);

	boolean boardDelete(int article_no);

	boolean boardUpdate(BoardDto dto);

	List<BoardDto> boardSearch(String category, String keyword);
	
	boolean KMP(String parent, String pattern);
	
	int[] makeTable(String pattern);
}
