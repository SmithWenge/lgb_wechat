<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<%@ include file="/WEB-INF/include/navs.jsp"%>

<script>window.PROJECT_CONTEXT="${contextPath}"</script>
<form class="form" action="${contextPath}/admin/article/edit.action" method="post">
    <div class="panel panel-default" style="margin-left: 1%; margin-right: 1%; margin-top: 10px;">
        <div class="panel-heading">

            <ul class="nav nav-pills">
                <li role="presentation" ><a href="#">文章编辑</a></li>
                <li role="presentation" style="float: right">
                    <button type="submit" class="btn btn-success">保存</button>
                </li>
            </ul>
        </div>
        <div class="panel-body">
            <input type="hidden" name="id" value="${document._id}">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputAuthor" class="col-sm-3 control-label" style="margin-top: 5px;">文章标题</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="inputAuthor" placeholder="文章标题" name="articleTitle" value="${document.articleTitle}">
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label" style="margin-top: 5px;">作者</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputPassword3" placeholder="作者姓名" name="articleAuthor" value="${document.articleAuthor}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 5px;">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputAuthor" class="col-sm-3 control-label" style="margin-top: 5px;">文章类别</label>
                        <div class="col-sm-9">
                            <tags:dicselect name="articleType" key="articleType" value="${document.articleType}" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-12" style="margin-top: 5px;">
                <ol class="breadcrumb">
                    <li><a>文章内容</a></li>
                </ol>
                <script>window.PROJECT_CONTEXT="${contextPath}"</script>
                <script type="text/javascript" src="${contextPath}/static/plugins/ueditor/ueditor.config.js" ></script>
                <script type="text/javascript" src="${contextPath}/static/plugins/ueditor/ueditor.all.js" ></script>
                <script type="text/javascript" src="${contextPath}/static/plugins/ueditor/lang/zh-cn/zh-cn.js" ></script>

                <script id="editor" type="text/plain" style="width: 100%; height:500px;" name="articleContent">${document.articleContent}</script>

                <script type="text/javascript">

                    //实例化编辑器
                    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                    var ue = UE.getEditor('editor');
                </script>
            </div>
        </div>
    </div>
</form>

<%@ include file="/WEB-INF/include/javascript.jsp"%>

<%@ include file="/WEB-INF/include/footer.jsp"%>