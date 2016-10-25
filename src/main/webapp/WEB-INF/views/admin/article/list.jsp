<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/include/header.jsp"%>

<%@include file="/WEB-INF/include/navs.jsp"%>

<div class="ui vertical segment">
    <form class="ui form" action="${contextPath}/admin/article/list.action" method="post">
        <div class="inline fields">
            <div class="field">
                <label>文章类型</label>
                <select class="ui search dropdown" name="articleType">
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
            <div class="field">
                <button class="ui violet button" type="submit">
                    查看
                    <i class="search icon"></i>
                </button>
            </div>
            <a class="field" href="${contextPath}/admin/article/route/add.action">
                <button class="ui green button" type="button">
                    添加
                    <i class="plus icon"></i>
                </button>
            </a>
        </div>
    </form>
</div>

<div class="ui vertical segment">
    <table class="ui very basic collapsing celled table" id="articleTable" style="margin-left: 2px;">
        <thead>
            <tr>
                <th>序号</th>
                <th>文章标题</th>
                <th>文章类型</th>
                <th>发布时间</th>
                <th>文章描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${documents}" var="document" varStatus="status">
                <tr>
                    <td class="ui center aligned header"><h1>${status.index + 1}</h1></td>
                    <td>${document.articleTitle}</td>
                    <tags:dictd groupValue="articleType" itemKey="${document.articleType}" />
                    <td>${document.articleTime}</td>
                    <td>${document.articleDescription}</td>
                    <td>
                        <a href="${contextPath}/admin/article/view/${document.articleType}/${document._id}.action">
                            <button type="button" class="ui green button">查看</button>
                        </a>
                        <a href="${contextPath}/admin/article/route/image/modify/${document.articleType}/${document._id}.action">
                            <button type="button" class="ui yellow button">更改图片</button>
                        </a>
                        <a href="${contextPath}/admin/article/route/edit/${document.articleType}/${document._id}.action">
                            <button type="button" class="ui yellow button">编 &nbsp; 辑</button>
                        </a>
                        <a href="${contextPath}/admin/article/delete/${document.articleType}/${document._id}.action">
                            <button type="button" class="ui red button">删 &nbsp; 除</button>
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
       $("#article").attr('class', 'active item');
    });
</script>

<%@include file="/WEB-INF/include/footer.jsp"%>