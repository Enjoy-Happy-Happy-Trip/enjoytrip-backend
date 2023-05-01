package com.ssafy.edu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.edu.util.DBUtil;

public class BoardDaoImpl implements IBoardDao {

	DBUtil dbutil;

	public BoardDaoImpl() {
		dbutil = new DBUtil();
	}

	@Override
	public boolean boardWrite(BoardDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into board(user_id,subject,content,hit,register_time) ");
		sql.append(" values(?,?,?,0,now()) ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i = 1;
			psmt.setString(i++, dto.getUser_id());
			psmt.setString(i++, dto.getSubject());
			psmt.setString(i++, dto.getContent());
			count = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("boardWrite exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		return count > 0 ? true : false;
	}

	@Override
	public List<BoardDto> boardlist() {
		List<BoardDto> boards = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select article_no, user_id,subject,content, ");
		sql.append(" hit,register_time from board ");
		sql.append(" order by article_no ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				BoardDto dto = new BoardDto(rs.getInt(j++), rs.getString(j++), rs.getString(j++), rs.getString(j++),
						rs.getInt(j++), rs.getString(j++));
				boards.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("boardlist exception :" + e);
		} finally {
			DBUtil.close(rs, psmt, conn);
		}
		return boards;
	}

	@Override
	public BoardDto boardDetail(int article_no) {
		BoardDto bdto = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select article_no, user_id,subject, content,");
		sql.append(" hit,register_time from board ");
		sql.append(" where article_no=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, article_no);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				bdto = new BoardDto(rs.getInt(j++), rs.getString(j++), rs.getString(j++), rs.getString(j++),
						rs.getInt(j++), rs.getString(j++));
			}

		} catch (SQLException e) {
			System.out.println("boardDetail exception :" + e);
		} finally {
			DBUtil.close(rs, psmt, conn);
		}
		return bdto;
	}

	@Override
	public boolean updateHit(int article_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update board set hit=hit+1 ");
		sql.append(" where article_no=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, article_no);

			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateHit exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		return count > 0 ? true : false;
	}

	@Override
	public boolean delete(int article_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from board ");
		sql.append(" where article_no=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, article_no);

			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		return count > 0 ? true : false;
	}

	@Override
	public boolean updateBoard(BoardDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update board set subject=?, content=? ");
		sql.append(" where article_no=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			
			psmt.setString(i++, dto.getSubject());
			psmt.setString(i++, dto.getContent());
			psmt.setInt(i++, dto.getArticle_no());

			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateBoard exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		return count > 0 ? true : false;
	}

	@Override
	public List<BoardDto> boardSearch(String category, String keyword) {	    
		List<BoardDto> boards = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append(" select * from board ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
	
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				
				int article_no = rs.getInt(j++);
				String user_id = rs.getString(j++);
				String subject = rs.getString(j++);
				String content = rs.getString(j++);
				int hit = rs.getInt(j++);
				String register_time = rs.getString(j++);
				
				boolean flag = false;
				
				if(category.equals("content")) {
					flag = KMP(content, keyword); 
				} else if(category.equals("user_id")) {
					flag = KMP(user_id, keyword);
				} else {
					flag = KMP(subject, keyword);
				}
				
				if(flag) {
					BoardDto dto = new BoardDto(article_no, user_id, subject, content, hit, register_time);
					boards.add(dto);
				}
				
			}

		} catch (SQLException e) {
			System.out.println("boardSearch exception :" + e);
		} finally {
			DBUtil.close(rs, psmt, conn);
		}
		return boards;
	}
	
	static boolean KMP(String parent, String pattern) {
	    int[] table = makeTable(pattern);
	        
	    int n1 = parent.length();
	    int n2 = pattern.length();
	        
	    int idx = 0;
	    for(int i=0; i< n1; i++) {
	        while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
	            idx = table[idx-1];
	        }

	        if(parent.charAt(i) == pattern.charAt(idx)) {
	            if(idx == n2-1) {
	            	return true;
	            }else {
	                idx += 1;
	            }
	        }
	    }
	    
	    return false;
	}
	
	static int[] makeTable(String pattern) {
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
