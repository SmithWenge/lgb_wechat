<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<%@ include file="/WEB-INF/include/navs.jsp"%>

<script>window.PROJECT_CONTEXT="${contextPath}"</script>
<form class="form" action="${contextPath}/admin/article/add.action" method="post" enctype="multipart/form-data">
    <div class="panel panel-default" style="margin-left: 1%; margin-right: 1%; margin-top: 10px;">
        <div class="panel-heading">

            <ul class="nav nav-pills">
                <li role="presentation" ><a href="#">文章添加</a></li>
                <li role="presentation" style="float: right">
                    <button type="submit" class="btn btn-success">保存</button>
                </li>
            </ul>
        </div>
        <div class="panel-body">

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputArticleTitle" class="col-sm-3 control-label" style="margin-top: 5px;">文章标题</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="inputArticleTitle" placeholder="文章标题" name="articleTitle">
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="inputArticleAuthor" class="col-sm-2 control-label" style="margin-top: 5px;">作者</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputArticleAuthor" placeholder="作者姓名" name="articleAuthor">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 5px;">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="selectArticleType" class="col-sm-3 control-label" style="margin-top: 5px;">文章类别</label>
                        <div class="col-sm-9">
                            <select class="form-control" name="articleType" id="selectArticleType">
                                <option value="0">--请选择--</option>
                                <option value="jwgg">教务公告</option>
                                <option value="zxjy">在线教育</option>
                                <option value="cjcx">成绩查询</option>
                                <option value="wyj">外语角</option>
                                <option value="jqhd">近期活动</option>
                                <option value="lszk">历史周刊</option>
                                <option value="xxjj">学校简介</option>
                                <option value="bz">帮助</option>
                            </select>
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
                <ol class="breadcrumb">
                    <li><a>文章内容</a></li>
                </ol>
                <script>window.PROJECT_CONTEXT="${contextPath}"</script>
                <script type="text/javascript" src="${contextPath}/static/plugins/ueditor/ueditor.config.js" ></script>
                <script type="text/javascript" src="${contextPath}/static/plugins/ueditor/ueditor.all.js" ></script>
                <script type="text/javascript" src="${contextPath}/static/plugins/ueditor/lang/zh-cn/zh-cn.js" ></script>

                <script id="editor" type="text/plain" style="width: 100%; height:500px;" name="articleContent"></script>

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