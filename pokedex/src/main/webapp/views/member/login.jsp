<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Poke Login</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
            rel="stylesheet"
        />
</head>
<body>
	<header class="welcome_header">
            <h1 class="welcome_header-title">환영합니다</h1>
            <p class="welcome_header-text">
                아이디가 있다면,<br />
                이메일이나 휴대폰번호를 입력해주세요
            </p>
        </header>

        <form action="<%=request.getContextPath() %>/login.do" method="post" id="login_form">
            <input
                name="userId"
                type="text"
                placeholder="ID"
                maxlength="20"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='Email or phone number'"
            />
            <input
                name="userPw"
                type="password"
                placeholder="PASSWORD"
                maxlength="13"
                onfocus="this.placeholder=''"
                onblur="this.placeholder='password'"
            />
            <input type="submit" value="Log in" />
            <a href="#">Find POKE Account or Password</a>
        </form>

        <script
            src="https://kit.fontawesome.com/8f05e1d322.js"
            crossorigin="anonymous"
        ></script>
</body>
</html>