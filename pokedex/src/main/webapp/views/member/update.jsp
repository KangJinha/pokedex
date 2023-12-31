<%@page import="com.poke.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = (Member)request.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Poke Edit</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/join.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
            rel="stylesheet"
        />
</head>
<body>
	<header class="welcome_header">
            <h1 class="welcome_header-title">회원수정</h1>
    </header>

        <form action="<%=request.getContextPath() %>/member/updateend.do" method="post" id="login_form">
        	<input
                name="userId"
                type="hidden"
                value="<%=loginMember.getMemberId() %>"
                readonly="readonly"
                placeholder="아이디"
            />
        	<input
                name="userPw"
                id="userPw"
                type="password"
                placeholder="비밀번호"
                maxlength="20"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='비밀번호'"
            />
            <input
                name="userPwCheck"
                id="userPwCheck"
                type="password"
                placeholder="비밀번호확인"
                maxlength="20"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='비밀번호확인'"
            >
            <span id="result" style="font-size: 1.5rem">비밀번호 일치여부</span>
            <input
                name="nickName"
                type="text"
                value="<%=loginMember.getMemberNickName() %>"
                placeholder="닉네임"
                maxlength="20"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='닉네임'"
            />
            <input
                name="age"
                type="text"
                value="<%=loginMember.getAge() %>"
                placeholder="나이"
                maxlength="3"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='나이'"
            />
            <input
                name="email"
                type="email"
                value="<%=loginMember.getEmail() %>"
                placeholder="이메일"
                maxlength="20"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='이메일'"
            />
            <input
                name="phone"
                type="text"
                value="<%=loginMember.getPhone() %>"
                placeholder="휴대폰번호"
                maxlength="13"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='휴대폰번호'"
            />
            <input type="submit" value="수정하기" />
            <a href="#">Find POKE Account or Password</a>
        </form>

        <script src="/pokemonstory/js/pwcheck.js"></script>
        
</body>
</html>