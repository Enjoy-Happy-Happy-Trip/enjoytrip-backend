package com.ssafy.edu.model;

import java.util.List;

public interface IBoardService {
	boolean boardWrite(BoardDto dto);

	List<BoardDto> boardlist();

	BoardDto boardDetail(int article_no);

	boolean boardDelete(int article_no);

	boolean boardUpdate(BoardDto dto);

	List<BoardDto> boardSearch(String category, String keyword);
}
