<%@page import="com.poke.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
 	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
 	<title>Pokémon</title>
 	<link rel="stylesheet" type="text/css" href="/pokedex/css/style.css"/>
</head>
	<body>
        <header>
            <div class="topbar">
                <div class="menubar">
                    <nav class="menu-bar">
                        <ul class="menu-bar_ul">
                            <li>
                                <a href="<%=request.getContextPath() %>">Pokemon</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath() %>/noticeList.do">
                                    Notice
                                </a>
                            </li>
                            <%if(loginMember==null){ %>
                            <li>
                                <a href="<%=request.getContextPath() %>/homeTologin.do">Login</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath() %>/join.do">Join</a>
                            </li>
                            <%}else if(loginMember.getMemberId().equals("admin")) {%>
                            <li>
                                <a href="<%=request.getContextPath() %>/update.do">Editprofile</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath() %>/logout.do">Logout</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath() %>/adminpage.do">AdminPage</a>
                            </li>
                            <%} else {%>
                            <li>
                                <a href="<%=request.getContextPath() %>/update.do">Editprofile</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath() %>/logout.do">Logout</a>
                            </li>
                            <%} %>
                        </ul>
                    </nav>
                </div>
            </div>
      	</header>