<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.poke.notice.model.dto.Notice" %>
<%
	List<Notice> notices=(List<Notice>)request.getAttribute("notices");
%>    
<%@ include file="/views/common/header.jsp"%>
 <style>
    section#notice-container{width:600px; margin:20px auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse;}
    table#tbl-notice th, table#tbl-notice td {border:1px solid; padding: 5px 0; text-align:center;}
    table#tbl-notice .title{
    	cursor:pointer;
    }
    table#tbl-notice .title:hover{
    	background-color:lime;
    }
    button {
		background-color: yellow;
	}
</style>
<section id="notice-container">
        <h2>공지사항</h2>
        <%if(loginMember!=null&&loginMember.getMemberId().equals("admin")) {%>
        	<button onclick="location.assign('<%=request.getContextPath()%>/notice/noticewrite.do')">글쓰기</button>
        <%} %>
        <table id="tbl-notice">
            <tr>
            
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>첨부파일</th>
                <th>작성일</th>
            </tr>
			<%if(!notices.isEmpty()){
				for(Notice n:notices){%>
				<tr>
					<td><%=n.getNoticeNo() %></td>
					<td class="title" onclick="fn_noticeview(<%=n.getNoticeNo()%>);">
						<%-- <a href="<%=request.getContextPath()%>/notice/noticeView.do?no=<%=n.getNoticeNo()%>"> --%>
							<%=n.getNoticeTitle() %>
						<!-- </a> -->
					</td>
					<td><%=n.getNoticeWriter() %></td>
					<td><%if(n.getFilePath()!=null){ %>
						<img src="<%=request.getContextPath()%>/images/file.png"
						 width="25"><sub><%=n.getFilePath() %></sub>
					<%} %></td>
					<td><%=n.getNoticeDate() %></td>
				</tr>
			<%} 
			}%>
        </table>
        <div id="pageBar">
        	<%=request.getAttribute("pageBar") %>
        </div>
    </section>
	<script>
		const fn_noticeview=(noticeNo)=>{
			location.assign('<%=request.getContextPath()%>/notice/noticeView.do?no='+noticeNo);
		}
	</script>

<%@ include file="/views/common/footer.jsp"%>