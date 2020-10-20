<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="//code.jquery.com/jquery-1.11.1.js"></script>

<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="en"/></c:when>
</c:choose>

<fmt:setBundle basename="pagecontent.language"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="sign_in_page.title"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css">
</head>

<body style="background-image: url(${pageContext.request.contextPath}/images/hotelMain.jpg)">
${activationMessage}
<div class="login-page">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="form">
        <form action="controller" method="post" class="login-form">
            <input type="text" name="login" placeholder=<fmt:message key="sign_up_page.login"/> />
            <input type="password" name="password" placeholder=<fmt:message key="sign_up_page.password"/> />

            <input type="hidden" name="command" value="sign_in"/>
            <span class="error" style="color:#ff340a">${signInErrorMessage}</span>
            <button><span><fmt:message key="sign_in_page.sign_in"/></span></button>
            <p class="message"><fmt:message key="sign_in_page.not_registered"/>
                <a href="controller?command=passing_sign_up"><fmt:message key="sign_in_page.create_account"/></a></p>
        </form>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</html>