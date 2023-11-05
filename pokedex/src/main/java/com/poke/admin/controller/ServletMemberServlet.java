package com.poke.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poke.model.dto.Member;
import com.poke.model.service.MemberService;

/**
 * Servlet implementation class ServletMemberServlet
 */
@WebServlet("/admin/searchmember.do")
public class ServletMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Member> members= new MemberService().searchMemberKeyword(keyword);
		String csv="";
		for(int i=0; i<members.size(); i++) {
			if(i!=0)csv+=",";
			csv+=members.get(i).getMemberId();
		}
		System.out.println(csv);
		
		response.setContentType("text/csv;charset=utf-8");
		response.getWriter().print(csv);
//		request 객체를 보낸 곳으로 데이터를 전달. 
//		오류 없이 실핼될 경우 success : function()의 매개변수로 들어간다.
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
