<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="col-md-6 col-md-offset-3">
    <div class="panel panel-default" style="margin-top: 1%;">
        <div class="panel-heading">管理员登录</div>
        <div class="panel-body">
            <form name="search-form" id="search-form" action="${contextPath}/admin/login.action" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="userName" class="col-md-2 control-label">用户名</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="userName" name="userName" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="userPass" class="col-md-2 control-label">密码</label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" id="userPass" name="userPass" />
                    </div>
                </div>
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
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-2">
                        <button type="submit" class="btn btn-success" value="登录">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/include/javascript.jsp"%>

    <%--<script type="text/javascript">--%>
        <%--$(function() {--%>
            <%--$("#change").on('click', function() {--%>
                <%--$("#authCodeImg").attr("src", "${contextPath}/admin/captchaImage.action?ran=" + new Date() / 100);--%>
            <%--});--%>

            <%--$("#search-form").validate({--%>
                <%--rules : {--%>
                    <%--authCode : {--%>
                        <%--required : true,--%>
                        <%--remote: {--%>
                            <%--url : "${contextPath}/admin/validateCode.action",--%>
                            <%--type : "post",--%>
                            <%--dataType : "json",--%>
                            <%--data : {--%>
                                <%--authCode : function() {--%>
                                    <%--return $("#authCode").val();--%>
                                <%--}--%>
                            <%--}--%>
                        <%--}--%>
                    <%--}--%>
                <%--},--%>
                <%--messages : {--%>
                    <%--authCode : {--%>
                        <%--required : "请填写验证码",--%>
                        <%--remote: "请输入正确的验证码"--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>
        <%--});--%>
    <%--</script>--%>
<%@include file="/WEB-INF/include/footer.jsp"%>