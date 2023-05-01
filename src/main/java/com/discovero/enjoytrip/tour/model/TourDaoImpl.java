package com.ssafy.edu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.edu.util.DBUtil;

public class TourDaoImpl implements ITourDao {
	
	DBUtil dbutil;
	
	public TourDaoImpl() {
		dbutil = new DBUtil();
	}
	@Override
	public TourDto tourDetail(int article_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TourDto> tourlist(int sido_code, int content_type_id, String word) {
		List<TourDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn =dbutil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select first_image, title, addr1, latitude, longitude from attraction_info ");
			sql.append("where sido_code = ? and content_type_id =? and title like  concat('%', ?, '%')");

			System.out.println("투어 임: "+ sido_code+ content_type_id+word);
			
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, sido_code);
			psmt.setInt(2, content_type_id);
			psmt.setString(3, word);
			System.out.println(psmt.toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				TourDto dto = new TourDto();
				dto.setImageUrl(rs.getString("first_image"));
				dto.setPlaceName(rs.getString("title"));
				dto.setAddress(rs.getString("addr1"));
				dto.setLatitude(rs.getBigDecimal("latitude"));
				dto.setLongitude(rs.getBigDecimal("longitude"));
				
				list.add(dto);
			}
			
			System.out.println(list.get(0).toString());
		} catch (SQLException e) {
			System.out.println("tourlist exception :"+e);
		}finally {
			dbutil.close(rs, psmt, conn);
		}
		
		return list;
	}
	@Override
	public boolean savePlan(String[] placeNames) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		for (int i = 0; i < placeNames.length; i++) {
			try {
				conn =dbutil.getConnection();
				StringBuilder sql = new StringBuilder();
				
				sql.append(" select i.title, i.addr1, i.addr2, i.first_image, d.overview");
				sql.append(" from attraction_info i, attraction_description d");
				sql.append(" where i.content_id = d.content_id and d.content_id = (select content_id from attraction_info where title =?)");
				
				System.out.println(placeNames[i]);
				
				psmt = conn.prepareStatement(sql.toString());
				psmt.setString(1, placeNames[i]);
				System.out.println(psmt.toString());
				rs = psmt.executeQuery();
				while (rs.next()) {					
					String title = rs.getString("title");
					String addr1 = rs.getString("addr1");
					String addr2 = rs.getString("addr2");
					String first_image = rs.getString("first_image");
					String overview = rs.getString("overview");
					
					
					sql = new StringBuilder();
					sql.append(" insert into members(user_id,user_name,user_password, ")
							.append(" email_id,email_domain,join_date,student_no, flag ) ").append(" values(?,?,?,?,?,now(), ?, ?) ");
					conn = null;
					psmt = null;
					int count = 0;
					
					conn = DBUtil.getConnection();
					psmt = conn.prepareStatement(sql.toString());
					int j = 1;
					
					psmt.setString(j++, title);
					psmt.setString(j++, addr1);
					psmt.setString(j++, addr2);
					psmt.setString(j++, first_image);
					psmt.setString(j++, overview);
					count = psmt.executeUpdate();

					return count > 0 ? true : false;	
				}
				
			} catch (SQLException e) {
				System.out.println("tourlist exception :"+e);
			}finally {
				dbutil.close(rs, psmt, conn);
			}
		}
		
		return true;
	}

}
