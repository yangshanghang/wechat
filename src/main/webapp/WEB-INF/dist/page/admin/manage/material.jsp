<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../common/meta.jsp"/>
    <title>菜单页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/pagination/pagination.css'/>">
</head>
<body>
    <div class="material">
            <div class="conters clearfix">
                <ul class="clearfix side nav-tabs">
                    <li id="ImgText" class="fl js-tab" data-type="news">
                        <a  class="active" href="javascript:;" >图 文<i></i></a>
                    </li>
                    <li id="Img" class="fl js-tab" data-type="image">
                        <a href="javascript:;">图 片<i></i></a>
                    </li>
                </ul>
                <div>
                    <table class="table-row" cellpadding="0" cellspacing="0">
                        <thead>
                            <tr>
                                <th width="40%">ID</th>
                                <th>Title</th>
                            </tr>
                        </thead>
                        <tbody id="tableList" class="info-box">

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="pagination mt10 right">

            </div>
    </div>
    <script id="listTemplate" type="text/x-handlebars-template">
        {{#each this}}
            <tr>
                <td>{{media_id}}</td>
                <td>{{title}}</td>
            </tr>
        {{/each}}
    </script>

<jsp:include page="../../common/common.jsp"/>
<script src="<c:url value='/js/admin/manage/controller/materialController.js?v=07ed366815'/>"></script>
</body>
</html>
