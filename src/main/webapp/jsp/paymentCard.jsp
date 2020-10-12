<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 09.10.2020
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="en"/></c:when>
</c:choose>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log.css">

</head>
<body>
<div class="login-page">
    <div class="form">
        <form action="controller" method="post" class="login-form">
            <input type="text" name="numberCard" placeholder="CARD NUMBER"/>
            <input type="text" name="dateCard" placeholder="DATE CARD"/>
            <input type="password" name="codeCard" placeholder="CODE CARD"/>
            <input type="text" name="transferAmount" placeholder="SUM"/>
            <input type="hidden" name="command" value="make_deposit"/>
            <span class="error" style="color:#ff340a">${signInErrorMessage}</span>
            <button><span>PAY</span></button>
        </form>
    </div>
</div>
</body>
</html>
