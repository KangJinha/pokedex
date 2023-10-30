package com.poke.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poke.model.dto.Member;
import com.poke.model.service.MemberService;

/**
 * Servlet implementation class PokeLoginServlet
 */
@WebServlet(name = "login",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트가 보낸 아이디와 패스워드를 받아온다.
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		//2. DB의 member테이블에서 보낸 아이디와 패스워드가 일치하는 회원을 가져온다.
		Member m = new MemberService().searchMemberByIdAndPw(userId,userPw);
		//3. 결과를 출력한다(응답페이지를 선택한다.)
		if(m!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", m);
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			request.setAttribute("msg", "아이디나 패스워드가 일치하지 않습니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
