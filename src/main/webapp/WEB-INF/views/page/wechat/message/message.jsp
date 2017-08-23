<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>企信联连服务</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="<c:url value='/css/wechat.css'/>">
</head>
<body class="scss-message">
<div>
    <div>
        <div class="mod-msg message">
            <div class="message-list">
                <input type="hidden" value="${phone}" id="js-phone">
                <input type="hidden" value="${hasNextPage}" id="js-hasNextPage">
                <c:if test="${!empty messagesList}">
                    <c:forEach items="${messagesList}" var="message">
                        <div class="cont">
                            <a href="${empty message.sourceUrl?'javascript:void(0)':message.sourceUrl}&mms_msg_id=${message.id}&mms_scene_flag=w2">
                                <div class="text">
                                    <h3 class="title ${message.subType}">

                                        <span class="word-type-icon"></span>
                                            ${message.title}
                                    </h3>
                                    <h4 class="comp-hd">
                                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${message.pushTime}"/>
                                    </h4>
                                    <c:if test="${!empty message.receiveName}">
                                        <h4 class="comp-hd "><i></i>${message.receiveName}</h4>
                                    </c:if>
                                    <c:if test="${!empty message.summary}">
                                        <p>${message.summary}</p>
                                    </c:if>
                                    <c:if test="${!empty message.content}">
                                        <p>${message.content}</p>
                                    </c:if>
                                    <c:if test="${!empty message.sourceUrl}">
                                        <div class="detail clear">
                                            <span class="fr">查看更多>></span>
                                        </div>
                                    </c:if>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <%-- 如果当前页等于总页数，则不显示加载更多 --%>
        <div class="infinite-box">
            <div class="weui-loadmore" style="display: none">
                <i class="weui-loading"></i><span class="weui-loadmore__tips">正在加载</span>
            </div>

            <div class="nodata js-load-fail <c:if test="${!empty messagesList}">dip-none</c:if>">
                <p>暂无历史消息</p>
            </div>
        </div>

    </div>
</div>
<!-- 消息列表模板 -->
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each this}}
    <div class="cont">
        <a href="{{hasurl sourceUrl}}&mms_msg_id={{id}}&mms_scene_flag=w2">
            <div class="text">
                <h3 class="title {{subType}}">
                    <span class="word-type-icon"></span>
                    {{title}}
                </h3>
                <h4 class="comp-hd">
                    {{showYmdhm pushTime}}
                </h4>
                {{#ifCond receiveName '!=' null}}
                <h4 class="comp-hd "><i></i>{{receiveName}}</h4>
                {{/ifCond}}
                {{#ifCond summary '!=' null}}
                <p>{{summary}}</p>
                {{/ifCond}}
                {{#ifCond content '!=' null}}
                <p>
                    {{content}}
                </p>
                {{/ifCond}}

                {{#ifCond sourceUrl '!=' null}}
                <div class="detail clear">
                    <span class="fr">查看更多>></span>
                </div>
                {{/ifCond}}
            </div>
        </a>
    </div>
    {{/each}}
</script>

<script>
    document._CONFIG = {
//消息获取接口
        messageGetUrl: "<c:url value='/client/message/page' />"
    };
</script>

<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/wechat/message/controller/messageController.js'/>"></script>
</body>
</html>