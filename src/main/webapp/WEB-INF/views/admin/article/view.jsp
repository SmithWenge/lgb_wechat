<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/include/header.jsp"%>
<%@include file="/WEB-INF/include/navs.jsp"%>

<h3 class="ui top attached header">
    <div class="ui grid">
        <div class="nine column row">
            <div class="left floated three columns">
                <a href="#">${document.articleTitle}</a>
            </div>
            <div class="right floated column">
                <a href="${contextPath}/admin/article/route/edit/${document.articleType}/${document._id}.action">
                    <i class="edit icon"></i>
                </a>
                <a onclick="window.history.back(-1);">
                    <i class="reply icon"></i>
                </a>
            </div>
        </div>
    </div>
</h3>
<div class="ui attached segment">
    ${document.articleContent}
</div>
<h3 class="ui bottom attached header">
    作者 : ${document.articleAuthor} &nbsp;&nbsp;&nbsp; 时间 : ${document.articleTime}
</h3>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    /**
     * 设置导航栏选中状态
     */
    $(function () {
        $("#article").attr('class', 'active item');
    });
</script>

<%@include file="/WEB-INF/include/footer.jsp"%>