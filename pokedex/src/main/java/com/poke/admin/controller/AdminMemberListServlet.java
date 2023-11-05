package com.poke.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.poke.admin.vo.service.AdminService;
import com.poke.model.dto.Member;
import com.poke.model.service.MemberService;
import com.poke.notice.model.dto.Notice;
import com.poke.notice.model.service.NoticeService;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet("/admin/searchmemberall.do")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage=1;
		int numPerpage=20;
//		if(request.getParameter("cPage")!=null) cPage=request;
//		try {
//			cPage=Integer.parseInt(request.getParameter("cPage"));
//		}catch(NumberFormatException e) {
//			cPage=1;
//		}
		
		List<Member> members=new AdminService().selectMemberAll(cPage,numPerpage);
//		int totalData=new NoticeService().selectNoticeCount();
//		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
//		int pageBarSize=5;
//		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
//		int pageEnd=pageNo+pageBarSize-1;
//		
//		String pageBar="";
//		if(pageNo==1) {
//			pageBar+="<span>[이전]</span>";
//		}else {
//			pageBar+="<a href='"+request.getRequestURI()
//						+"?cPage="+(pageNo-1)+"'>[이전]</a>";
//		}
//		while(!(pageNo>pageEnd||pageNo>totalPage)) {
//			if(pageNo==cPage) {
//				pageBar+="<span>"+pageNo+"</span>";
//			}else {
//				pageBar+="<a href='"+request.getRequestURI()
//						+"?cPage="+pageNo+"'>"+pageNo+"</a>";
//			}
//			pageNo++;
//		}
//		if(pageNo>totalPage) {
//			pageBar+="<span>[다음]</span>";
//		}else {
//			pageBar+="<a href='"+request.getRequestURI()
//					+"?cPage="+pageNo+"'>[다음]</a>";
//		}
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(members,response.getWriter());
		
//		request.setAttribute("notices",members); 
//		request.setAttribute("pageBar",pageBar);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
