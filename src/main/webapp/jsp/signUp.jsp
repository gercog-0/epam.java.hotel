<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title><fmt:message key="sign_up_page.title"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css">
</head>

<body background="${pageContext.request.contextPath}/images/hotelMain.jpg" style="background-repeat: no-repeat">
<div class="login-page">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="form">
        <form action="DeluxeHotel" method="post" class="login-form">
            <input type="text" name="name" placeholder=
            <fmt:message key="sign_up_page.name"/> required pattern="^[a-zA-Z]{2,25}$"
                   oninvalid="this.setCustomValidity('<fmt:message key="sign_up_page.invalid_name"/>')"
                   onchange="this.setCustomValidity('')" value="${signUpData['name']}"/>

            <input type="text" name="surname" placeholder=
            <fmt:message key="sign_up_page.surname"/> required pattern="^[a-zA-Z]{2,25}$"
                   oninvalid="this.setCustomValidity('<fmt:message key="sign_up_page.invalid_surname"/>')"
                   onchange="this.setCustomValidity('')" value="${signUpData['surname']}"/>

            <input type="text" name="login" placeholder=
            <fmt:message key="sign_up_page.login"/> required pattern="^[a-zA-Z0-9_]{3,25}$"
                   oninvalid="this.setCustomValidity('<fmt:message key="sign_up_page.invalid_login"/>')"
                   onchange="this.setCustomValidity('')" value="${signUpData['login']}"/>

            <input type="text" name="phone" placeholder=
            <fmt:message key="sign_up_page.phone"/> required
                   pattern="^(\+375\([\d]{2}\)[\d]{3}\-[\d]{2}\-[\d]{2})$"
                   oninvalid="this.setCustomValidity('<fmt:message key="sign_up_page.invalid_phone"/>')"
                   onchange="this.setCustomValidity('')" value="${signUpData['phone']}"/>

            <input type="text" name="email" placeholder=
            <fmt:message key="sign_up_page.email"/> required
                   pattern="^[a-zA-z0-9_.-]{1,35}@[a-zA-z0-9_-]{2,15}\.[a-z]{2,5}$"
                   oninvalid="this.setCustomValidity('<fmt:message key="sign_up_page.invalid_email"/>')"
                   onchange="this.setCustomValidity('')" value="${signUpData['email']}"/>

            <input type="password" name="password" placeholder=
            <fmt:message key="sign_up_page.password"/> required pattern="^.{3,25}$"
                   oninvalid="this.setCustomValidity('<fmt:message key="sign_up_page.invalid_password"/>')"
                   onchange="this.setCustomValidity('')" value="${signUpData['password']}"/>

            <c:if test="${signUpData['loginUnique'] eq 'notUnique' || signUpData['emailUnique'] eq 'notUnique' ||
            signUpData['phoneUnique'] eq 'notUnique'}">
            <span class="error" style="color:#ff340a"> <fmt:message key="sign_up_page.this"/>
                <c:choose>
                    <c:when test="${signUpData['loginUnique'] eq 'notUnique'}"> <fmt:message key="sign_up_page.login"/></c:when>
                    <c:when test="${signUpData['phoneUnique'] eq 'notUnique'}"> <fmt:message key="sign_up_page.phone"/></c:when>
                    <c:when test="${signUpData['emailUnique'] eq 'notUnique'}"> <fmt:message key="sign_up_page.email"/></c:when>
                </c:choose>
                <fmt:message key="sign_up_page.is_already_in_use"/>
            </span>
            </c:if>
            <input type="hidden" name="command" value="sign_up"/>
            <button><span><fmt:message key="sign_up_page.sign_up"/></span></button>
            <p class="message"><fmt:message key="sign_up_page.have_account"/>
                <a href="DeluxeHotel?command=passing_sign_in"> <fmt:message key="sign_in_page.sign_in"/></a></p>
        </form>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</html>
