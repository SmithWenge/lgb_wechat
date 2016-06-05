<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>


<style type="text/css">
    #adminPasswordForm {
        margin-top: 2%;
    }
</style>

<form class="form-horizontal col-sm-offset-3" action="${contextPath}/admin/resetPass.action" method="post" id="adminPasswordForm">
    <div class="form-group">
        <label for="adminLoginName" class="col-sm-2 control-label">管理员用户</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="adminLoginName" name="userName" value="${adminLogin.userName}">
        </div>
    </div>
    <div class="form-group">
        <label for="adminLoginPass" class="col-sm-2 control-label">管理员原密码</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="adminLoginPass" name="userPass" placeholder="密码">
        </div>
    </div>
    <div class="form-group">
        <label for="adminLoginPassNew" class="col-sm-2 control-label">管理员新密码</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="adminLoginPassNew" name="userPassNew" placeholder="新密码">
        </div>
    </div>
    <div class="form-group">
        <label for="adminLoginPassNewRe" class="col-sm-2 control-label">管理员新密码</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="adminLoginPassNewRe" name="userPassNewRe" placeholder="再次输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="authCode" class="col-sm-2 control-label">验证码</label>
        <div class="col-sm-5">
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
        <div class="col-sm-offset-2 col-sm-5">
            <button type="submit" class="btn btn-primary">更改密码</button>
        </div>
    </div>
</form>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    $(function() {
        $("#change").on('click', function() {
            $("#authCodeImg").attr("src", "${contextPath}/admin/captchaImage.action?ran=" + new Date() / 100);
        });

        $("#adminPasswordForm").validate({
            rules: {
                adminLoginPassNew: {
                    required: true,
                    minlength: 5,
                    maxlength: 20
                },
                adminLoginPassNewRe: {
                    required: true,
                    minlength: 5,
                    maxlength: 20,
                    equalTo: '#adminLoginPassNew'
                },
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
            messages: {
                adminLoginPassNew: {
                    required: "请输入新密码.",
                    minlength: "请确定新密码的长度为5到20之间.",
                    maxlength: "请确定新密码的长度为5到20之间."
                },
                adminLoginPassNewRe: {
                    required: "请输入新密码.",
                    minlength: "请确定新密码的长度为5到20之间.",
                    maxlength: "请确定新密码的长度为5到20之间.",
                    equalTo: "请保证两次输入的新密码一样."
                },
                authCode : {
                    required : "请填写验证码",
                    remote: "请输入正确的验证码"
                }
            }
        });
    });
</script>

<%@include file="/WEB-INF/include/footer.jsp"%>