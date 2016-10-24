<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navs.jsp"%>

<div class="ui two column centered grid" style="margin-top: 5%;">
    <div class="column">
        <div class="ui raised very padded text container segment">
            <form class="ui form" id="resetPassForm" action="${contextPath}/admin/reset/pass.action" method="post">
                <div class="field">
                    <label>用户名</label>
                    <input type="text" name="userName" id="userName" value="${adminLogin.userName}" readonly>
                </div>
                <div class="field">
                    <label>旧密码</label>
                    <input type="text" name="userPass" placeholder="请填写旧密码" id="userPass">
                </div>
                <div class="field">
                    <label>新密码</label>
                    <input type="text" name="userPassNew" placeholder="请填写新密码" id="userPassNew">
                </div>
                <div class="field">
                    <label>新密码</label>
                    <input type="text" name="userPassNewRe" placeholder="请填写新密码" id="userPassNewRe">
                </div>
                <button class="ui yellow button" type="submit"><i class="edit icon"></i> &nbsp; 更改密码</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    $("#resetPassForm").validate({
        rules : {
            userPass: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            userPassNew: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            userPassNewRe: {
                required: true,
                minlength: 5,
                maxlength: 20,
                equalTo: "#userPassNew"
            }
        },
        messages: {
            userPass: {
                required: "请填写登录密码",
                minlength: "请确定登录密码长度大于3",
                maxlength: "请确定登录密码长度小于20"
            },
            userPassNew: {
                required: "请填写登录密码",
                minlength: "请确定登录密码长度大于3",
                maxlength: "请确定登录密码长度小于20"
            },
            userPassNewRe: {
                required: "请填写登录密码",
                minlength: "请确定登录密码长度大于3",
                maxlength: "请确定登录密码长度小于20",
                equalTo: "请确定两次填写的新密码是相同的"
            }
        }
    })
</script>

<%@include file="/WEB-INF/include/footer.jsp"%>