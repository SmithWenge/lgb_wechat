<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="row" style="margin-left: 2%; margin-right: 2%; margin-top: 1%;">
    <div class="col-md-12">
        <ul class="nav nav-pills">
            <li role="presentation"><a href="${contextPath}/admin/routePass.action">修改密码</a></li>
            <li role="presentation"><a href="${contextPath}/admin/article/list/zxjy.action">文章管理</a></li>
            <li role="presentation" style="float: right"><a>管理员: ${sessionScope.adminLogin.userName}</a></li>
        </ul>
    </div>
</div>