package com.ssafy.edu.model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.edu.util.DBUtil;

public class MemberDaoImpl implements IMemberDao {

	DBUtil dbutil;

	public MemberDaoImpl() {
		dbutil = new DBUtil();
	}

	@Override
	public boolean registry(MembersDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into members(user_id,user_name,user_password, ")
				.append(" email_id,email_domain,join_date,student_no, flag ) ").append(" values(?,?,?,?,?,now(), ?, ?) ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i = 1;
			psmt.setString(i++, dto.getUser_id());
			psmt.setString(i++, dto.getUser_name());
			psmt.setString(i++, encryptData(dto.getUser_password()));
			psmt.setString(i++, dto.getEmail_id());
			psmt.setString(i++, dto.getEmail_domain());
			psmt.setString(i++, dto.getStudent_no());
			psmt.setInt(i++, 0);
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDaoImpl registry :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}

		return count > 0 ? true : false;
	}

	@Override
	public MembersDto login(MembersDto dto) {
		MembersDto login=null;
		StringBuilder sql=new StringBuilder();
		sql.append(" select user_id,user_name, email_id,email_domain  ");
		sql.append(" from members where user_id=? and user_password=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=dbutil.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			int i=1;
			psmt.setString(i++, dto.getUser_id());
			psmt.setString(i++, encryptData(dto.getUser_password()));
			rs=psmt.executeQuery();
			while(rs.next()) {
				int j=1;
				login=new MembersDto(
						rs.getString(j++), 
						rs.getString(j++), 
						"", 
						rs.getString(j++), 
						rs.getString(j++));
			}
			
		} catch (SQLException e) {
			System.out.println("login exception :"+e);
		}finally {
			dbutil.close(rs,psmt,conn);
		}
		return login;
	}
	
	public String findpassword(String student_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select user_password from members where student_no=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String password = "";
		
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
					
			int i = 1;
			psmt.setString(i++, student_no);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				password = rs.getString(j++);
			}

		} catch (SQLException e) {
			System.out.println("findpassword exception :" + e);
		} finally {
			DBUtil.close(rs, psmt, conn);
		}
		
		return password;
	}

	@Override
	public List<MembersDto> memberlist() {
		List<MembersDto> members = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select user_id, user_name,user_password,email_id, ");
		sql.append(" email_domain, join_date, student_no from members ");
		sql.append(" where flag=0 order by user_id ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				MembersDto dto = new MembersDto(rs.getString(j++), rs.getString(j++), rs.getString(j++), rs.getString(j++),
						rs.getString(j++), rs.getString(j++), rs.getString(j++));
				members.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("adminpage exception :" + e);
		} finally {
			DBUtil.close(rs, psmt, conn);
		}
		return members;
	}

	@Override
	public MembersDto memberDetail(String user_id) {
		MembersDto mdto = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select user_id, user_name, user_password, email_id,");
		sql.append(" email_domain, join_date, student_no from members ");
		sql.append(" where user_id=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				mdto = new MembersDto(rs.getString(j++), rs.getString(j++), rs.getString(j++), rs.getString(j++),
						rs.getString(j++), rs.getString(j++), rs.getString(j++));
			}

		} catch (SQLException e) {
			System.out.println("memberDetail exception :" + e);
		} finally {
			DBUtil.close(rs, psmt, conn);
		}
		return mdto;	}

	@Override
	public boolean memberDelete(String user_id) {
		StringBuilder sql = new StringBuilder();
//		sql.append(" update members set flag=?");
//		sql.append(" where user_id=? ");
		
		sql.append(" delete from board where user_id=?");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, user_id);
			
			System.out.println(psmt.toString());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		
		sql = new StringBuilder();
		sql.append(" delete from members where user_id=?;");
		
		conn = null;
		psmt = null;
		count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, user_id);
			
			System.out.println(psmt.toString());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		
		return count > 0 ? true : false;
	}

	@Override
	public boolean memberUpdate(MembersDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update members set user_name=?, user_password=?, ");
		sql.append(" email_id=?, email_domain=? ");
		sql.append(" where user_id=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			
			psmt.setString(i++, dto.getUser_name());
			psmt.setString(i++, dto.getUser_password());
			psmt.setString(i++, dto.getEmail_id());
			psmt.setString(i++, dto.getEmail_domain());
			psmt.setString(i++, dto.getUser_id());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateBoard exception :" + e);
		} finally {
			DBUtil.close(psmt, conn);
		}
		return count > 0 ? true : false;
	}
	
	 @Override
    public String encryptData(String str) {
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] md5encrypt = md5.digest();
            
            for(int i = 0 ; i < md5encrypt.length ; i++){
                sb.append(Integer.toHexString((int)md5encrypt[i] & 0xFF));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return sb.toString();
    }

}
