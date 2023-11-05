<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
<section style="margin:100px" align="center">
	<h2>
		안녕하세요, 관리자 페이지 입니다.
	</h2>
	<button style="cursor: pointer;">회원검색</button>
	<input type="search" id="searchMember" name="searchMember" list="data">
	<datalist id="data"></datalist>
	<button onclick="searchAllMember();" style="cursor: pointer;">모든회원조회</button>
	<div id="memberList"></div>
	<script>
		 function searchAllMember() {
			$.get("<%=request.getContextPath()%>/admin/searchmemberall.do",
				data=>{
					const $table = $("<table>");
					const $header = $("<tr>");
					$header.html("<th>아이디</th>"
					+"<th>닉네임</th><th>나이</th><th>이메일</th>"
					+"<th>전화번호</th><th>등록일</th>");
					$table.append($header);
					console.log(data);	
					data.forEach(e=>{
						const $tr = $("<tr>");
						const $memberId = $("<td>").text(e['memberId']);
						const $memberNickName = $("<td>").text(e['memberNickName']);
						const $age = $("<td>").text(e['age']);
						const $email = $("<td>").text(e['email']);
						const $phone = $("<td>").text(e['phone']);
						const $enrolldate = $("<td>").text(e['enrollDate']);
						console.log($memberId);
						$tr.append($memberId)
						.append($memberNickName).append($age).append($email)
						.append($phone).append($enrolldate);
						$table.append($tr);
						console.log($table);
					});
					$("#memberList").html($table);
				}
			)
		};
		
		$("#searchMember").keyup(e=>{
			const value= e.target.value;
			$.ajax({
				url:"<%=request.getContextPath()%>/admin/searchmember.do",
				data:{"keyword":value},
				success:data=>{
					const userIds = data.split(",");
					$("#data").html("");
					userIds.forEach(e=>{
						const $op=$("<option>").attr("value",e).text(e);
						$("#data").append($op)
					});
				}
			});
		});
	</script>
</section>
<%@ include file="/views/common/footer.jsp" %>