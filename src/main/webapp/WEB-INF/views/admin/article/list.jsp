<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/include/header.jsp"%>

<%@include file="/WEB-INF/include/navs.jsp"%>

<div class="panel panel-default" style="margin-left: 2%; margin-right: 2%; margin-top: 1%;">
    <div class="panel-heading">
        <ul class="nav nav-pills">
            <li role="presentation" ><a href="${contextPath}/admin/article/list/zxjy.action">文章管理</a></li>
            <li role="presentation" style="float: right">
                <a href="${contextPath}/admin/article/route/add.action">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    添加文章
                </a>
            </li>
        </ul>
    </div>
    <div class="panel-body">

        <div class="row" style="margin-top: 5px;">
            <div class="col-md-12">
                <table class="table" id="paginationTable" align="center">
                    <tr style="background-color: #2aabd2;">
                        <th>序号</th>
                        <th>文章标题</th>
                        <th>文章类型</th>
                        <th>发布时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${documents}" var="document" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${document.articleTitle}</td>
                            <tags:dictd groupValue="articleType" itemKey="${document.articleType}" />
                            <td>${document.articleTime}</td>
                            <td style="padding-top: 0px; padding-bottom: 0px">
                                <a href="${contextPath}/admin/article/view/${document.articleType}/${document._id}.action" style="text-decoration: none;">
                                    <button type="button" class="btn btn-success">查看</button>
                                </a>
                                <a href="${contextPath}/admin/article/route/edit/${document.articleType}/${document._id}.action" style="text-decoration: none;">
                                    <button type="button" class="btn btn-warning">编辑</button>
                                </a>
                                <a href="${contextPath}/admin/article/delete/${document.articleType}/${document._id}.action" style="text-decoration: none;" >
                                    <button type="button" class="btn btn-danger">删除</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<%@include file="/WEB-INF/include/footer.jsp"%>