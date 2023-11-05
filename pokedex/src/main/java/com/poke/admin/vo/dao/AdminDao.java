package com.poke.admin.vo.dao;

import static com.poke.common.JDBCTemplate.*;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.poke.model.dto.Member;
import com.poke.model.dao.MemberDAO;

public class AdminDao {
	private MemberDAO dao = new MemberDAO();
	private Properties sql=new Properties();
	{
		String path=AdminDao.class
				.getResource("/sql/admin/admin_sql.properties").getPath();
		try(FileReader fr=new FileReader(path)) {
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public List<Member> selectMemberAll(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> result=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberAll"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(dao.getMember(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
}
