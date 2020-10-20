<%--
  Created by Ivan Yanushkevich.
  Date: 19.10.2020
  Time: 22:30
  Page of error #500.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Lato:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css">
    <title>ERROR PAGE</title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/headerWithoutLang.jsp"/>
    <div class="layout-body"
         style="background-image: url(${pageContext.request.contextPath}/images/notification.jpg); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="notification">
            <h3 class="notification__title">ERROR 500</h3>
            <p class="notification__text">
                Request from ${pageContext.errorData.requestURI} is failed! <br/>
                Status code : ${pageContext.errorData.statusCode} <br/>
                Exception : ${pageContext.exception}
            </p>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</html>