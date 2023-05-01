package com.ssafy.edu.model;

import java.util.List;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService bservice = new BoardServiceImpl();

	private BoardServiceImpl() {
		bdao = new BoardDaoImpl();
	}

	public static IBoardService getInstance() {
		return bservice;
	}

	private IBoardDao bdao;

	@Override
	public boolean boardWrite(BoardDto dto) {
		return bdao.boardWrite(dto);
	}

	@Override
	public List<BoardDto> boardlist() {
		return bdao.boardlist();
	}

	@Override
	public BoardDto boardDetail(int article_no) {
		bdao.updateHit(article_no);
		return bdao.boardDetail(article_no);
	}

	@Override
	public boolean boardDelete(int article_no) {
		return bdao.delete(article_no);
	}

	@Override
	public boolean boardUpdate(BoardDto dto) {
		return bdao.updateBoard(dto);
	}

	@Override
	public List<BoardDto> boardSearch(String category, String keyword) {
		return bdao.boardSearch(category, keyword);
	}

}
