<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="ui two column centered grid" style="margin-top: 5%;">
    <div class="column">
        <div class="ui raised very padded text container segment">
            <form class="ui form" id="loginForm" action="${contextPath}/admin/login.action" method="post">
                <div class="field">
                    <label>用户名</label>
                    <input type="text" name="userName" placeholder="请填写登录名" id="userName">
                </div>
                <div class="field">
                    <label>密码</label>
                    <input type="text" name="userPass" placeholder="请填写密码" id="userPass">
                </div>
                <button class="ui positive button" type="submit"><i class="sign in icon"></i> &nbsp; 登录</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    $("#loginForm").validate({
        rules : {
            userName: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            userPass: {
                required: true,
                minlength: 5,
                maxlength: 20
            }
        },
        messages: {
            userName: {
                required: "请添加登录名",
                minlength: "请确定登录名的长度大于3",
                maxlength: "请确定登录名的长度小于20"
            },
            userPass: {
                required: "请填写登录密码",
                minlength: "请确定登录密码长度大于3",
                maxlength: "请确定登录密码长度小于20"
            }
        }
    });
</script>

<%@include file="/WEB-INF/include/footer.jsp"%>