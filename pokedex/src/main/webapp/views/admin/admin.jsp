<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<section style="margin:100px" align="center">
	<h2>
		안녕하세요, 관리자 페이지 입니다.
	</h2>
	<input type="text" id="searchMember" name="searchMember"><button>회원검색</button>
	<script>
		$("#searchMember").keyup(e=>{
			console.log(e);
		});
	</script>
</section>
<%@ include file="/views/common/footer.jsp" %>