<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>window.PROJECT_CONTEXT="${contextPath}"</script>
<script type="text/javascript" src="${contextPath}/static/plugins/ueditor/ueditor.config.js" ></script>
<script type="text/javascript" src="${contextPath}/static/plugins/ueditor/ueditor.all.js" ></script>
<script type="text/javascript" src="${contextPath}/static/plugins/ueditor/lang/zh-cn/zh-cn.js" ></script>

<script id="editor" type="text/plain" style="width: 100%; height:500px;" name="content"></script>

<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
</script>