<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>老干部大学微信后台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <%--<meta http-equiv="X-UA-Compatible" content="IE=8" />--%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${contextPath}/static/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="${contextPath}/static/plugins/bootstrap/css/bootstrap-theme.css" />
    <title>老干部大学微信后台</title>
    <style>
        .content{
            margin: 200px auto 0;
            width: 420px;
            background: #fff;
            height: 255px;
            opacity: 0.8;
            padding:10px ;
        }

        .right_div{
            width: 400px;
            padding: 16px 40px;
            margin: 0 auto;
        }
        #userName,#userName{
            width: 270px;
            height: 40px;
            margin-top: 10px;
            opacity: 0.9;
        }
        #sub{
            width: 270px;
            height: 35px;
            margin: 15px 20px 0;
        }
    </style>
</head>


<body>
<form action="${contextPath}/weinxin/admin/login.action" method="post" id="adminLoginForm">
    <div class="content">
        <div class="right_div">
            <label for="userName"><span class="glyphicon glyphicon-user"></span><span>&nbsp;</span><span>&nbsp;</span></label>
            <input type="text" id="userName" name="userName" placeholder="admin" /><br />
            <label for="userPass"><span class="glyphicon glyphicon-lock"></span><span>&nbsp;</span><span>&nbsp;</span></label>
            <input type="password" id="userPass" name="userPass" placeholder="密码" /><br />
            <span>&nbsp;</span><button class="btn btn-info" type="submit" id="sub">登录</button>
        </div>
    </div>
</form>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<%@include file="/WEB-INF/include/footer.jsp"%>