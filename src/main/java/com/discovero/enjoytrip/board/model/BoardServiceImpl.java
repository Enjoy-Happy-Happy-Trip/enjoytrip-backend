package com.discovero.enjoytrip.board.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements IBoardService {

	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	@Transactional
	public boolean boardWrite(BoardDto dto) {
		return boardMapper.boardWrite(dto);
	}

	@Override
	@Transactional
	public List<BoardDto> boardlist() {		
		return boardMapper.boardlist();
	}

	@Override
	@Transactional
	public BoardDto boardDetail(int article_no) {
		boardMapper.updateHit(article_no);
		return boardMapper.boardDetail(article_no);
	}

	@Override
	@Transactional
	public boolean boardDelete(int article_no) {
		return boardMapper.delete(article_no);
	}

	@Override
	@Transactional
	public boolean boardUpdate(BoardDto dto) {
		return boardMapper.updateBoard(dto);
	}

	@Override
	@Transactional
	public List<BoardDto> boardSearch(String category, String keyword) {
		List<BoardDto> boards = boardMapper.boardSearch();
		List<BoardDto> ret = new ArrayList<>();
		
		for (BoardDto bdto : boards) {
			boolean flag = false;
			String content = bdto.getContent();
			String user_id = bdto.getUser_id();
			String subject = bdto.getSubject();
					
			if(category.equals("content")) {
				flag = KMP(content, keyword); 
			} else if(category.equals("user_id")) {
				flag = KMP(user_id, keyword);
			} else {
				flag = KMP(subject, keyword);
			}
			
			if(flag) {
				BoardDto dto = new BoardDto(bdto.getArticle_no(), user_id, subject, content, bdto.getHit(), bdto.getRegister_time());
				ret.add(dto);
			}
		}
		
		return ret;
	}

	@Override
	public boolean KMP(String parent, String pattern) {
		int[] table = makeTable(pattern);

		int n1 = parent.length();
		int n2 = pattern.length();

		int idx = 0;
		for (int i = 0; i < n1; i++) {
			while (idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}

			if (parent.charAt(i) == pattern.charAt(idx)) {
				if (idx == n2 - 1) {
					return true;
				} else {
					idx += 1;
				}
			}
		}

		return false;
	}

	@Override
	public int[] makeTable(String pattern) {
		int n = pattern.length();
	    int[] table = new int[n];
	        
	    int idx=0;
	    for(int i=1; i<n; i++) {
	        // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
	        while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
	            idx = table[idx-1];
	        }
	            
	        if(pattern.charAt(i) == pattern.charAt(idx)) {
	            idx += 1;
	            table[i] = idx;  
	        }
	    }
	    return table;
	}

}
