package com.poke.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poke.notice.model.dto.Notice;
import com.poke.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeWriteEndServlet
 */
@WebServlet("/notice/noticewriteend.do")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String file = request.getParameter("upfile");
		String content = request.getParameter("content");
		
		Notice n = Notice.builder()
				.noticeTitle(title)
				.noticeWriter(writer)
				.filePath(file)
				.noticeContent(content)
				.build();
		
		int result = new NoticeService().insertNotice(n);
		
		String msg,loc;
		if(result>0) {
			msg="등록 성공 :)";
			loc="/noticeList.do";
		} else {
			msg="등록 실패 :(";
			loc="/noticeList.do";
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
