<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="ui secondary pointing menu">
    <a class="item" href="${contextPath}/admin/route/login.action" id="index">
        <i class="home icon"></i> 首页
    </a>
    <a class="item" href="${contextPath}/admin/article/list.action" id="article">
        <i class="book icon"></i> 文章
    </a>
    <div class="right menu">
        <div class="ui pointing dropdown link item">
            <span class="text">管理员: &nbsp; ${sessionScope.adminLogin.userName}</span>
            <i class="dropdown icon"></i>
            <div class="menu">
                <a class="item" href="${contextPath}/admin/route/pass.action"><i class="edit icon"></i> 修改密码</a>
            </div>
        </div>
        <a class="item" href="${contextPath}/admin/logout.action">
            <i class="sign out icon"></i> 退出
        </a>
    </div>
</div>