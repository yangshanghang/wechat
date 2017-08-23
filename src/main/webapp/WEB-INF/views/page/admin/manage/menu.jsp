<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../common/meta.jsp"/>
    <title>菜单页面</title>
</head>
<body>
<div class="menu-wrap">
    <div class="menu-json">
        <div class="menu-box">
            <textarea class="menu-area js-area"></textarea>
        </div>
    </div>
    <div class="menu-btn">
        <div class="m-btn btn-pull js-pull mr20">刷新</div>
        <div class="m-btn btn-push js-submit  js-push">提交</div>
    </div>
</div>
</body>

<%--暂时写在这，后期写入require--%>
<jsp:include page="../../common/common.jsp"/>
<script src="<c:url value='/js/admin/manage/controller/menuController.js'/>"></script>
</html>
