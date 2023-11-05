<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
<script src="<%=request.getContextPath() %>/js/makeMemberTable.js"></script>
<style>
	button {
		cursor: pointer;
	}
	#memberList>table>tr>td{
	    padding: 10px;
	}
	.searchBox{
		display: flex;
		flex-direction:column;
	}
	section{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
</style>
<section style="margin:100px">
	<h2 align="center">
		안녕하세요, 관리자 페이지 입니다.
	</h2>
	<div class="searchBox">
		<div class="search">
			<button onclick="searchAllMember();">모든회원조회</button>
			<div>
				<input type="search" id="searchMember" name="searchMember" list="data">
				<datalist id="data"></datalist>
				<button>회원검색</button>
			</div>
			<div>
				<input type="text" id="key">
				<button onclick="searchNickName();">닉네임으로 조회</button>
			</div>
		</div>
		<div id="memberList"></div>
	</div>
	<script>
		function searchNickName() {
			$.post("<%=request.getContextPath()%>/admin/searchnickname.do",
					{"key":$("#key").val()},
				data=>{
					$("#memberList").html(makeMemberTable(data));
				});
		};
	
		 function searchAllMember() {
			$.get("<%=request.getContextPath()%>/admin/searchmemberall.do",
				data=>{
					$("#memberList").html(makeMemberTable(data));
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