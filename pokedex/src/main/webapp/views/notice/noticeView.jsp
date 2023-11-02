<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.poke.notice.model.dto.Notice" %>
<%
	Notice n=(Notice)request.getAttribute("notice");
%>    
<%@ include file="/views/common/header.jsp"%>
<style>
    section#notice-container{width:100%; margin: 20px auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{height:300px; width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    #download-container{cursor: pointer;}
</style>
<section id="notice-container">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=n.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=n.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
            	<%if(n.getFilePath()!=null){ %>
            	<div id="download-container">
           			<img src="<%=request.getContextPath()%>/images/file.png" 
           			width="25"><span><%=n.getFilePath() %></span>
           		</div>
           		<%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=n.getNoticeContent() %></td>
        </tr>
        <tr>
            <th colspan="2">
            <%if(loginMember!=null&&loginMember.getMemberId().equals("admin")){ %>
                <input type="button" value="수정하기" onclick="location.href='<%=request.getContextPath()%>/notice/noticeUpdate.do'">
                <input type="button" value="삭제하기" onclick="">
            <%} else {%>
            	<input type="button" value="수정하기" onclick="alert('권한이 없습니다.');">
                <input type="button" value="삭제하기" onclick="alert('권한이 없습니다.');">
            <%} %>
            </th>
        </tr>
    </table>
</section>
<script>
	$("#download-container").click(e=>{
		location.assign("<%=request.getContextPath()%>/filedownload.do?fname=<%=n.getFilePath()%>")
	});
	
</script>

<%@ include file="/views/common/footer.jsp"%>