<%--
  Created by Yanushkevich Ivan.
  Date: 19.10.2020
  Time: 16:56
  Notification page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="en"/></c:when>
</c:choose>

<fmt:setBundle basename="pagecontent.language"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Lato:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css">
    <title><fmt:message key="notification_page.title"/></title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/headerWithoutLang.jsp"/>
    <div class="layout-body"
         style="background-image: url(${pageContext.request.contextPath}/images/notification.jpg); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="notification">
            <h3 class="notification__title"><fmt:message key="notification_page.subtitle"/></h3>
            <c:choose>
                <c:when test="${not empty activateRoomNumber}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.room_with_number"/> ${activateRoomNumber} <fmt:message
                            key="notification_page.successfully_activated"/>
                    </p>
                </c:when>

                <c:when test="${ not empty addRoomNumber}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.room_with_number"/> ${addRoomNumber} <fmt:message
                            key="notification_page.successfully_added"/>
                    </p>
                </c:when>

                <c:when test="${not empty approveBookingId}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.booking_with_id"/> ${approveBookingId} <fmt:message
                            key="notification_page.successfully_approved"/>
                    </p>
                </c:when>

                <c:when test="${not empty banLoginUser}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.user_with_login"/> ${banLoginUser} <fmt:message
                            key="notification_page.successfully_banned"/>
                    </p>
                </c:when>
                <c:when test="${not empty bookingRoom}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.successfully_booked"/> ${bookingRoom.getNumber()}
                    </p>
                </c:when>
                <c:when test="${not empty activationMessage}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.activation_message"/>
                    </p>
                </c:when>
                <c:when test="${not empty disableRoomNumber}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.room_with_number"/> ${disableRoomNumber} <fmt:message
                            key="notification_page.successfully_disabled"/>
                    </p>
                </c:when>
                <c:when test="${not empty depositMessage}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.successfully_credited"/> ${depositMessage}$
                    </p>
                </c:when>
                <c:when test="${not empty paymentMessage}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.your_order"/> # ${paymentMessage} <fmt:message
                            key="notification_page.successfully_paid"/>
                    </p>
                </c:when>
                <c:when test="${not empty rejectBookingId}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.booking_with_id"/> ${rejectBookingId} <fmt:message
                            key="notification_page.successfully_rejected"/>
                    </p>
                </c:when>
                <c:when test="${not empty bannedAccount || not empty notActivatedAccount}">
                    <c:if test="${not empty bannedAccount}">
                        <p class="notification__text">
                            <fmt:message key="notification_page.banned_account"/>
                        </p>
                    </c:if>
                    <c:if test="${not empty notActivatedAccount}">
                        <p class="notification__text">
                            <fmt:message key="notification_page.not_activated_account"/>
                        </p>
                    </c:if>
                </c:when>
                <c:when test="${not empty signUpMessage}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.sign_up_message"/>
                    </p>
                </c:when>
                <c:when test="${not empty unbanLoginUser}">
                    <p class="notification__text">
                        <fmt:message key="notification_page.user_with_login"/>
                            ${unbanLoginUser} <fmt:message key="notification_page.successfully_unbanned"/>
                    </p>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</html>