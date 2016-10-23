<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="ui two column centered grid" style="margin-top: 5%;">
    <div class="column">
        <form class="ui form" id="loginForm" action="${contextPath}/admin/login.action" method="post">
            <div class="field">
                <label>用户名</label>
                <input type="text" name="userName" placeholder="请填写登录名" id="userName">
            </div>
            <div class="field">
                <label>密码</label>
                <input type="text" name="userPass" placeholder="请填写密码" id="userPass">
            </div>
            <button class="ui positive button" type="submit">登录</button>
        </form>
    </div>
</div>

<%-- 验证码 --%>
<%--<div class="form-group">--%>
<%--<label for="authCode" class="col-sm-4 control-label" style="padding: 0;font-weight: 800;">验证码</label>--%>
<%--<div class="col-sm-8">--%>
<%--<input type="text" class="form-control" id="authCode" name="authCode" placeholder="验证码不区分大小写">--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--<div class="col-md-4"></div>--%>
<%--<div class="col-md-8">--%>
<%--<a id="change" href="#">--%>
<%--<img id="authCodeImg" src="${contextPath}/admin/captchaImage.action"/>--%>
<%--<span style="line-height: 40px;"><em> &nbsp;换一张</em></span>--%>
<%--</a>--%>
<%--</div>--%>
<%--</div>--%>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<%@include file="/WEB-INF/include/footer.jsp"%>