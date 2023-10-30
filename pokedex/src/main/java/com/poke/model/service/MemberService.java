package com.poke.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.poke.common.JDBCTemplate;
import com.poke.model.dao.MemberDAO;
import com.poke.model.dto.Member;
import static com.poke.common.JDBCTemplate.*; //JDBCTemplate 안에있는 모든 static메소드 임포트

public class MemberService {
	// Connection객체를 관리하는 역할
	// Connection를 생성, 트랜잭션처리
	private static MemberService service = new MemberService();
	public static MemberService getService() {
		if(service ==null) service = new MemberService();
		return service;
	}
	private MemberDAO dao = MemberDAO.getMemberDAO();
	
	public Member searchMemberByIdAndPw(String id, String pw){
		Connection con = getConnection();
		Member result = dao.searchMemberByIdAndPw(con, id, pw);
		close(con);
		return result;
	}
	public int insertMember(Member m){
		Connection con = getConnection();
		int result = dao.insertMember(con, m);
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	public int updateMember(Member m){
		Connection con = getConnection();
		int result = dao.updateMember(con, m);
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	public int deleteMember(String id){
		Connection con = getConnection();
		int result = dao.deleteMember(con, id);
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
}
