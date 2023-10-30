package com.poke.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poke.common.security.AESEncryptor;
import com.poke.model.dto.Member;
import com.poke.model.service.MemberService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("userId");
//		String pw = request.getParameter("userPw");
//		Member m = new MemberService().searchMemberByIdAndPw(id, pw);
		
		// 로그인할때 저장한 세션 정보 가져오기
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginMember");
		//Member m = new MemberService().searchMemberByIdAndPw(loginMember.getMemberId(), loginMember.getMemberPw());
		try {
			String phone=m.getPhone();
			phone=AESEncryptor.decryptData(phone); // 암호화된 phone을 복호화하기
			m.setPhone(phone);// Member가 final로 되어있어서 set이 안됐던것...
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("loginMember", m);
		request.getRequestDispatcher("/views/member/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
