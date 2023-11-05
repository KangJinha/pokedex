package com.poke.admin.vo.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.poke.admin.vo.dao.AdminDao;
import com.poke.common.JDBCTemplate;
import com.poke.model.dao.MemberDAO;
import com.poke.model.dto.Member;
import static com.poke.common.JDBCTemplate.*; //JDBCTemplate 안에있는 모든 static메소드 임포트

public class AdminService {
	// Connection객체를 관리하는 역할
	// Connection를 생성, 트랜잭션처리
	private static AdminService service = new AdminService();
	public static AdminService getService() {
		if(service ==null) service = new AdminService();
		return service;
	}
	private AdminDao dao = new AdminDao();

	public List<Member> selectMemberAll(int cPage, int numPerpage){
		Connection con = getConnection();
		List<Member> result = dao.selectMemberAll(con, cPage, numPerpage);
		close(con);
		return result;
	}
	public List<Member> selectMemberNickname(String key, int cPage, int numPerpage){
		Connection con = getConnection();
		List<Member> result = dao.selectMemberNickname(con, key, cPage, numPerpage);
		close(con);
		return result;
	}
	
}
