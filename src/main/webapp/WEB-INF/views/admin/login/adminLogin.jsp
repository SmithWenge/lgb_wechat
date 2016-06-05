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
</head>


<body>
    <div id="inquire_box" style="width:500px;margin: 100px 300px">
        <form name="search-form" id="search-form" action="${contextPath}/admin/login.action" method="post" class="form-horizontal col-sm-offset-3">
            <div class="form-group">
                <label for="userName" class="col-sm-4 control-label" style="padding: 0;font-weight: 800;">用户名</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="userName" name="userName" />
                </div>
            </div><br/>
            <div class="form-group">
                <label for="userPass" class="col-sm-4 control-label" style="padding: 0;font-weight: 800;">密码</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="userPass" name="userPass" />
                </div>
            </div>
            <div class="form-group">
                <label for="authCode" class="col-sm-4 control-label" style="padding: 0;font-weight: 800;">验证码</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="authCode" name="authCode" placeholder="验证码不区分大小写">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-4"></div>
                <div class="col-md-8">
                    <a id="change" href="#">
                        <img id="authCodeImg" src="${contextPath}/admin/captchaImage.action"/>
                        <span style="line-height: 40px;"><em> &nbsp;换一张</em></span>
                    </a>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-8 col-sm-offset-4">
                    <button type="submit" class="btn btn-primary" value="登录" style="width: 300px">登录</button>
                </div>
            </div>
        </form>
    </div>
<%@include file="/WEB-INF/include/javascript.jsp"%>

    <script type="text/javascript">
        $(function() {
            $("#change").on('click', function() {
                $("#authCodeImg").attr("src", "${contextPath}/admin/captchaImage.action?ran=" + new Date() / 100);
            });

            $("#search-form").validate({
                rules : {
                    authCode : {
                        required : true,
                        remote: {
                            url : "${contextPath}/admin/validateCode.action",
                            type : "post",
                            dataType : "json",
                            data : {
                                authCode : function() {
                                    return $("#authCode").val();
                                }
                            }
                        }
                    }
                },
                messages : {
                    authCode : {
                        required : "请填写验证码",
                        remote: "请输入正确的验证码"
                    }
                }
            });
        });
    </script>
<%@include file="/WEB-INF/include/footer.jsp"%>