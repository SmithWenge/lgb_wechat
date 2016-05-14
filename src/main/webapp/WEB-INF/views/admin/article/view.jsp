<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/include/header.jsp"%>

<%@include file="/WEB-INF/include/navs.jsp"%>

<div class="panel panel-default" style="margin-left: 2%; margin-right: 2%; margin-top: 1%;">
    <div class="panel-heading">
        <ul class="nav nav-pills">
            <li role="presentation" ><a href="#">查看文章 (${document.articleTitle})</a></li>
            <li role="presentation" style="float: right">
                <a href="${contextPath}/admin/article/route/edit/${document.articleType}/${document._id}.action">
                    编辑文章
                </a>
            </li>
        </ul>
    </div>
    <div class="panel-body">

        <div class="row" style="margin-top: 5px;">
            <div class="col-md-12">
                ${document.articleContent}
            </div>
        </div>
    </div>
    <div class="panel-footer">
        作者 : ${document.articleAuthor} &nbsp;&nbsp;&nbsp; 时间 : ${document.articleTime}
    </div>
</div>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<%@include file="/WEB-INF/include/footer.jsp"%>