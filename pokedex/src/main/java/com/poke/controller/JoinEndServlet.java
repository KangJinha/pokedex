package com.poke.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poke.common.security.AESEncryptor;
import com.poke.model.dto.Member;
import com.poke.model.service.MemberService;

/**
 * Servlet implementation class Join
 */
@WebServlet(name = "joinend",urlPatterns = "/joinend.do")
public class JoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String nickName = request.getParameter("nickName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		try {
			phone = AESEncryptor.encryptData(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Member m = Member.builder()
				.memberId(userId)
				.memberPw(userPw)
				.memberNickName(nickName)
				.age(age)
				.email(email)
				.phone(phone)
				.build();
		
		int result = new MemberService().insertMember(m);
		String msg,loc;
		if(result>0) {
			msg = m.getMemberNickName() + "님 포켓몬 세계에 오신 것을 환영합니다!";
			loc="/";
		} else {
			msg="회원가입에 실패하셨습니다";
			loc="/join.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
