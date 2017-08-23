<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>系统繁忙</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="<c:url value='/css/wechat.css'/>">
</head>
<body class="scss-error">
    <div class="mt10 bg-white wrap">
        <div class="center pt50 fail-box">
            <img width="70px" height="100px" src="<c:url value='/img/wechat/fail-img.jpg'/>">
            <p class="mt13">${errorMsg}</p>
        </div>
    </div>
</body>
</html>
