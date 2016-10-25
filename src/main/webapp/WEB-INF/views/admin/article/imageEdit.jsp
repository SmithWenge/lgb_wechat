<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navs.jsp"%>

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
    <div class="ui grid">
        <div class="two column row">
            <div class="left floated column">
                <form class="ui form" action="${contextPath}/admin/article/image/edit.action" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${document._id}">
                    <input type="hidden" name="articleType" value="${document.articleType}">
                    <input type="hidden" name="oldPictureUrl" value="${document.pictureUrl}">
                    <div class="field">
                        <label>文章标题</label>
                        <input type="text" name="articleTitle" value="${document.articleTitle}" readonly>
                    </div>
                    <div class="field">
                        <label>图片</label>
                        <input type="file" name="articlePicture">
                    </div>
                    <button class="ui yellow button" type="submit">更改</button>
                </form>
            </div>
            <div class="right floated two column">
                <img src="${document.pictureUrl}">
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    /**
     * 设置导航栏选中状态
     */
    $(function () {
        $("#article").attr('class', 'active item');
    });
</script>

<%@ include file="/WEB-INF/include/footer.jsp"%>