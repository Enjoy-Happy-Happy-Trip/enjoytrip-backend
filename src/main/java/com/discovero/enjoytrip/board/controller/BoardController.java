package com.discovero.enjoytrip.board.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.discovero.enjoytrip.board.model.IBoardService;
import com.ssafy.board.controller.BoardController;

@Controller("/board")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	IBoardService bservice;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String root = request.getContextPath();
		System.out.println(root);
		
		bservice = BoardServiceImpl.getInstance();
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("boardwrite")) {
			response.sendRedirect("./board/boardwrite.jsp");
		} else if (action.equalsIgnoreCase("home")) {
			response.sendRedirect(root + "/index.jsp");
		} else if (action.equalsIgnoreCase("bwrite")) {
			String user_id = request.getParameter("user_id");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			boolean isS = bservice.boardWrite(new BoardDto(user_id, subject, content));
			
			response.sendRedirect(root + "/board?action=boardlist");
		} else if (action.equalsIgnoreCase("boardlist")) {
			request.setAttribute("boards", bservice.boardlist());
			RequestDispatcher dispatcher = request.getRequestDispatcher("./board/boardlist.jsp");
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("detail")) {
			String sarticle_no = request.getParameter("article_no");
			int article_no = Integer.parseInt(sarticle_no);
			
			request.setAttribute("board", bservice.boardDetail(article_no));
			RequestDispatcher dispatcher = request.getRequestDispatcher("./board/boarddetail.jsp");
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("delete")) {
			String sarticle_no = request.getParameter("article_no");
			int article_no = Integer.parseInt(sarticle_no);
			
			bservice.boardDelete(article_no);
			response.sendRedirect(root + "/board?action=boardlist");
		} else if (action.equalsIgnoreCase("updateBoard")) {
			String sarticle_no = request.getParameter("article_no");
			int article_no = Integer.parseInt(sarticle_no);
			
			request.setAttribute("board", bservice.boardDetail(article_no));
			RequestDispatcher dispatcher = request.getRequestDispatcher("./board/boardupdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("updateGo")) {
			String sarticle_no = request.getParameter("article_no");
			int article_no = Integer.parseInt(sarticle_no);

			String subject = request.getParameter("subject");
			String content = request.getParameter("content");

			bservice.boardUpdate(new BoardDto(article_no, subject, content));

			request.setAttribute("board", bservice.boardDetail(article_no));

			RequestDispatcher dispatcher = request.getRequestDispatcher("./board/boarddetail.jsp");
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("filter")) {
			String category = request.getParameter("key");
			String keyword = request.getParameter("word");
			
			System.out.println(category + " " + keyword);
			
			request.setAttribute("boards", bservice.boardSearch(category, keyword));
			RequestDispatcher dispatcher = request.getRequestDispatcher("./board/boardlist.jsp");
			dispatcher.forward(request, response);
		} 
	}
}
