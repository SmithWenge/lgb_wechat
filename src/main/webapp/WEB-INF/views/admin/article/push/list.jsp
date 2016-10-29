<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/include/header.jsp"%>

<%@include file="/WEB-INF/include/navs.jsp"%>

<div class="ui center segment">
    <div class="ui ten column grid">
        <div class="right floated column">
            <a class="field" href="${contextPath}/admin/article/push/route/add.action">
                <button class="ui green button" type="button">
                    添加
                    <i class="plus icon"></i>
                </button>
            </a>
        </div>
    </div>

</div>

<div class="ui center segment">
    <table class="ui very basic collapsing celled table" id="articleTable">
        <thead>
            <tr>
                <th>序号</th>
                <th>文章标题</th>
                <%--<th>文章类型</th>--%>
                <th>发布时间</th>
                <th>文章描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${documents}" var="document" varStatus="status">
                <tr>
                    <td class="ui center aligned header"><h1>${status.index + 1}</h1></td>
                    <td>
                        <h4 class="ui image header">
                            <img src="${document.pictureUrl}" class="ui mini rounded image">
                            <div class="content">
                                标题
                                <div class="sub header">${document.articleTitle}</div>
                            </div>
                        </h4>
                    </td>
                    <%--<tags:dictd groupValue="articleType" itemKey="${document.articleType}" />--%>
                    <td>${document.articleTime}</td>
                    <td>${document.articleDescription}</td>
                    <td>
                        <a href="${contextPath}/admin/article/push/view/${document.articleType}/${document._id}.action">
                            <button type="button" class="ui green button">查看</button>
                        </a>
                        <a href="${contextPath}/admin/article/push/route/edit/${document._id}.action">
                            <button type="button" class="ui yellow button">编 &nbsp; 辑</button>
                        </a>
                        <%--<a href="${contextPath}/admin/article/push/delete/${document.articleType}/${document._id}.action">--%>
                            <%--<button type="button" class="ui red button">删 &nbsp; 除</button>--%>
                        <%--</a>--%>
                        <a href="${contextPath}/admin/article/push/broadcast/${document._id}.action">
                            <button type="button" class="ui primary button">推 &nbsp; 送</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    /**
     * 设置导航栏选中状态
     */
    $(function () {
       $("#push").attr('class', 'active item');
    });
</script>

<%@include file="/WEB-INF/include/footer.jsp"%>