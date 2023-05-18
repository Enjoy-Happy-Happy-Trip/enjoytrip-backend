package com.discovero.enjoytrip.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.discovero.enjoytrip.board.model.IBoardService;
import com.discovero.enjoytrip.board.controller.BoardController;
import com.discovero.enjoytrip.board.model.BoardDto;
import com.discovero.enjoytrip.board.model.IBoardService;
import com.discovero.enjoytrip.member.model.MembersDto;
import com.discovero.enjoytrip.util.PageNavigation;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러  API V1")
public class BoardController {	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Value("${file.path}")
	private String uploadPath;
	
	@Value("${file.imgPath}")
	private String uploadImgPath;

	private IBoardService boardService;

	public BoardController(IBoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping("/boardwrite")
	public String boardwrite(Model model) {
		logger.debug("GET boardwrite called");
		return "redirect:/board/boardwrite";
	}
	
	@PostMapping("/bwrite")
	public String bwrite(BoardDto bdto, Model model) {
		logger.debug("POST brwite called {}", bdto.toString());
		
		boolean isS = boardService.boardWrite(new BoardDto(bdto.getUser_id(), bdto.getSubject(), bdto.getContent()));
		
		return "redirect:/board/boardlist";
	}
	
	@GetMapping("/boardlist")
	public List<BoardDto> boardlist(Model model) {
		logger.info("GET boardlist called");
		List<BoardDto> boards = boardService.boardlist();
		return boards;
	}
	
	@GetMapping("/detail/{article_no}")
	public BoardDto detail(@PathVariable String article_no) {
		logger.debug("GET detail called");
		int articleNo = Integer.parseInt(article_no);

		BoardDto bdto = boardService.boardDetail(articleNo);
		System.out.println(bdto.toString());
		return bdto;
	}
	
	@GetMapping("/delete")
	public String delete(BoardDto bdto, Model model) {
		logger.debug("GET delete called");
		int article_no = bdto.getArticle_no();
		
		model.addAttribute("board", boardService.boardDelete(article_no));
		return "redirect:/board/boardlist";
	}
	
	@GetMapping("/updateboard")
	public String updateboard(BoardDto bdto, Model model) {
		logger.debug("GET updateboard called");
		int article_no = bdto.getArticle_no();
		
		model.addAttribute("board", boardService.boardDetail(article_no));
		return "board/boardupdate";
	}
	
	@GetMapping("/updatego")
	public String updatego(BoardDto bdto, Model model) {
		logger.debug("GET updatego called");
		int article_no = bdto.getArticle_no();
		
		boardService.boardUpdate(new BoardDto(bdto.getArticle_no(), bdto.getSubject(), bdto.getContent()));
		
		model.addAttribute("board", boardService.boardDetail(article_no));
		return "board/boarddetail";
	}
	
	@GetMapping("/filter")
	public String filter(String key, String word, Model model) {
		logger.debug("GET filter called {}", key, word);
		model.addAttribute("boards", boardService.boardSearch(key, word));
		
		return "board/boardlist";
	}
	
}
