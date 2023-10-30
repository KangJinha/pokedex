package com.poke.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.poke.common.JDBCTemplate;
import com.poke.model.dto.Member;
import static com.poke.common.JDBCTemplate.*;

public class MemberDAO {
	private static MemberDAO memberdao;
	private Properties sql = new Properties();
	{
		String path = MemberDAO.class
				.getResource("/sql/member/member_sql.properties")
				.getPath();
		try(FileReader fr=new FileReader(path);) {
			sql.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDAO() {}
	
	public static MemberDAO getMemberDAO() {
		if(memberdao == null) memberdao = new MemberDAO();
		return memberdao;
	}
	
	public Member searchMemberByIdAndPw(Connection con, String id, String pw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql.getProperty("searchMemberByIdAndPw"));
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = getMember(rs);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}
	
	public int insertMember (Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
//		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,DEFAULT)";
		try {
			pstmt = con.prepareStatement(sql.getProperty("insertMember"));
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberNickName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection con, Member m) {
		PreparedStatement pst = null;
		int result = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PW=?, MEMBER_NICKNAME=?, AGE=?, EMAIL=?, PHONE=? WHERE MEMBER_ID=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, m.getMemberPw());
			pst.setString(2, m.getMemberNickName());
			pst.setInt(3, m.getAge());
			pst.setString(4, m.getEmail());
			pst.setString(5, m.getPhone());
			pst.setString(6, m.getMemberId());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pst);
		}
		return result; 
		
		
		// 수정할아이디 수정할데이터번호 수정할데이터
		// Statememt를 사용
//		Statement stmt = null;
//		int result = 0;
//		String sql = "UPDATE MEMBER SET #col = '"+ list.get(2) +"' WHERE MEMBER_ID = '"+ list.get(0)+"' ";
//		try {
//			stmt = con.createStatement();
//			
//			// 수정할데이터 받아온것
//			int num = (int) list.get(1);
//			switch (num) {
//			case 1: sql = sql.replace("#col", "MEMBER_ID");break;
//			case 2: sql = sql.replace("#col", "MEMBER_PW");break;
//			case 3: sql = sql.replace("#col", "MEMBER_NICKNAME");break;
//			case 4: sql = sql.replace("#col", "AGE");break;
//			case 5: sql = sql.replace("#col", "EMAIL");break;
//			case 6: sql = sql.replace("#col", "PHONE");break;
//			}
//			result = stmt.executeUpdate(sql);
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally {
//			close(stmt);
//		}
//		return result;
	}
	public int deleteMember (Connection con, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	private Member getMember(ResultSet rs)
			throws SQLException{
				return Member.builder()
						.memberId(rs.getString("member_id"))
						.memberPw(rs.getString("member_pw"))
						.memberNickName(rs.getString("member_nickname"))
						.age(rs.getInt("age"))
						.email(rs.getString("email"))
						.phone(rs.getString("phone"))
						.enrollDate(rs.getDate("enroll_date"))
						.build();
			}
}
