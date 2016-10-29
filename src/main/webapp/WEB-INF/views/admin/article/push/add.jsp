<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>

<%@ include file="/WEB-INF/include/navs.jsp"%>

<form class="ui form" action="${contextPath}/admin/article/push/add.action" method="post" enctype="multipart/form-data">
    <h3 class="ui top attached header">
        <div class="ui eight column grid">
            <div class="row">
                <div class="left floated column">
                    <div class="field">
                        <button class="ui button" type="button" onclick="window.history.back(-1);">
                            <i class="reply icon"></i>
                        </button>
                    </div>
                </div>
                <div class="right floated column">
                    <div class="field">
                        <button class="ui violet button" type="submit">
                            保存
                            <i class="save icon"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </h3>
    <div class="ui attached segment">
        <div class="three fields">
            <div class="field">
                <label>文章标题</label>
                <input type="text" name="articleTitle" placeholder="请填写文章标题">
            </div>
            <div class="field">
                <label>文章作者</label>
                <input type="text" name="articleAuthor" placeholder="请填写作者">
            </div>
            <div class="field">
                <label>图片</label>
                <input type="file" name="articlePicture">
            </div>
        </div>
        <div class="field">
            <label>文章简短描述</label>
            <textarea rows="1" name="articleDescription"></textarea>
        </div>
        <div class="field">
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
</form>

<%@ include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    /**
     * 设置导航栏选中状态
     */
    $(function () {
        $("#push").attr('class', 'active item');
    });
</script>

<%@ include file="/WEB-INF/include/footer.jsp"%>