<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<style>
    section#notice-container{width:600px; margin:30px auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
</style>
  <section id="notice-container">
    <form action="<%=request.getContextPath() %>/notice/noticewriteend.do" method="post">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" required 
            value="<%=loginMember!=null?loginMember.getMemberId():""%>"></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input type="file" name="upfile" ></td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><textarea cols="46" rows="10" name="content"
            style="resize:none;"></textarea></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="수정하기" onclick="">
            </th>
        </tr>
    </table>
    </form>
</section>
<%@ include file="/views/common/footer.jsp" %>