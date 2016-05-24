<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<%@ include file="/WEB-INF/include/navs.jsp"%>

<script>window.PROJECT_CONTEXT="${contextPath}"</script>
<form class="form" action="${contextPath}/admin/article/image/edit.action" method="post" enctype="multipart/form-data">
    <div class="panel panel-default" style="margin-left: 1%; margin-right: 1%; margin-top: 10px;">
        <div class="panel-heading">

            <ul class="nav nav-pills">
                <li role="presentation" ><a href="#">图片修改</a></li>
                <li role="presentation" style="float: right">
                    <button type="submit" class="btn btn-success">保存</button>
                </li>
            </ul>
        </div>
        <div class="panel-body">
            <input type="hidden" name="id" value="${document._id}">
            <input type="hidden" name="articleType" value="${document.articleType}">
            <input type="hidden" name="oldPictureUrl" value="${document.pictureUrl}">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputAuthor" class="col-sm-3 control-label" style="margin-top: 5px;">文章标题</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="inputAuthor" placeholder="文章标题" name="articleTitle" value="${document.articleTitle}" readonly>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputArticlePicture" class="col-sm-2 control-label" style="margin-top: 5px;">图片</label>
                        <div class="col-sm-10">
                            <input type="file" id="inputArticlePicture" name="articlePicture">
                            <p class="help-block">请添加jpg或者png格式的图片</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-12" style="margin-top: 5px;">
                <img src="${document.pictureUrl}">
            </div>
        </div>
    </div>
</form>

<%@ include file="/WEB-INF/include/javascript.jsp"%>

<%@ include file="/WEB-INF/include/footer.jsp"%>