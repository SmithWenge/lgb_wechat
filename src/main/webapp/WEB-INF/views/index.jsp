<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navs.jsp"%>

<div class="ui center segment">
    <div class="ui form">
        <div class="inline fields">
            <div class="five wide field">
                <label>文章类型</label>
                <select class="ui search dropdown" id="articleTypeChange" name="articleType">
                    <option value="jwgg">教务公告</option>
                    <option value="zxjy">在线教育</option>
                    <option value="jqhd">近期活动</option>
                    <option value="lszk">历史周刊</option>
                    <option value="wyj">外语角</option>
                </select>
            </div>
        </div>
    </div>
</div>
<div class="ui center segment">
    <table class="ui very basic collapsing celled table" id="articleTable">
        <thead>
            <tr>
                <th>标题</th>
                <th>类型</th>
                <th>描述</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/include/javascript.jsp"%>

<script type="text/javascript">
    $(function () {
        /**
         */
        $("#index").attr('class', 'active item');

        /**
         * 文章类型更改的ajax联动
         */
       $("#articleTypeChange").on("change", function () {
           var postData = { "articleType" : $("#articleTypeChange").val() };

           $.ajax({
               type: 'post',
               contentType: 'application/x-www-form-urlencoded',
               data: postData,
               dataType: 'json',
               url: '${contextPath}/admin/article/ajax/list.action',
               success: function (result) {
                   $("#articleTable tbody").empty();

                   $.each(result.articles, function (index, item) {
                        var content = '<tr><td><h4 class="ui image header"><img src="' + item.pictureUrl + '" class="ui mini rounded image"><div class="content">' + item.articleTitle + '<div class="sub header">' + item.articleAuthor + '</div></div></h4></td><td>' + item.articleType + '</td><td><a target="_blank" href="' + item.articleUrl +'">' + item.articleDescription +'</a></td></tr>';

                       $("#articleTable tbody").append(content);
                   });
               }
           });
       });

        $("#articleTypeChange").trigger("change");
    });
</script>

<%@ include file="/WEB-INF/include/footer.jsp"%>