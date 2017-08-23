<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>联连内容管理平台</title>
    <!-- 默认视图 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器兼容视图适配 -->
    <meta name="renderer" content="webkit">
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/bootstrap.min.css?v=06b615635b'/>">
    <link rel="stylesheet" href="<c:url value='/css/wechat.css?v=d9d869938c'/>">
    <script>
        //失效自动跳转到顶层登录页面
        if (top.location != self.location) {
            top.location = "<c:url value='/'/>";
        }
    </script>
</head>

<body>
<input type="hidden" id="js-noauth" value="${param.noauth}" />
<div class="header clearfix index-top">
    <span class="logo fl">
        <img src="<c:url value='/img/logo.png'/>" alt="" class="fl"/>
    </span>
    <div class="fr">
        <div class="entry">
            <a href="<c:url value='/cas/login'/>" class="login-btn">登录</a>
        </div>
    </div>
</div>
<div class="loginContent">
    <div class="cr-bot">
        <span>©<i></i>2017浙江汇信科技有限公司<i></i>版权所有</span>
        <span>浙ICP备：浙B2-20070198-13<i></i>浙公网安备：33010502002208号</span>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="common/common.jsp"/>
</body>

<script src="<c:url value='/js/login/login_main.js?v=cbaf9da2c3'/>"></script>
</html>