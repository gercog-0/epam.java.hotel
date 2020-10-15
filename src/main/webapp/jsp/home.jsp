<%--
  Created by Yanushkevich Ivan
  Date: 10.09.2020
  Time: 23:03
  Home JSP
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="en"/></c:when>
</c:choose>

<fmt:setBundle basename="pagecontent.language"/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Lato:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css">
    <title><fmt:message key="main_page.title"/></title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body">
        <div class="section-welcome"
             style="background-image: url(${pageContext.request.contextPath}/images/hotelMain.jpg);">
            <div class="section-welcome__content">
                <div class="container">
                    <div class="hotel-info">
                        <div class="hotel-info__subtitle"><fmt:message key="main_page.business_card"/></div>
                        <h3 class="hotel-info__title"><fmt:message key="main_page.business_card_title"/></h3>
                        <div class="hotel-info__desc">
                            <fmt:message key="main_page.business_card_text"/>
                        </div>
                        <c:choose>
                            <c:when test="${empty user}">
                                <a href="controller?command=passing_sign_in" class="hotel-info__button"><fmt:message
                                        key="main_page.business_card_button"/></a>
                            </c:when>
                            <c:when test="${not empty user}">
                                <c:if test="${userRole != 'ADMINISTRATOR'}">
                                    <a href="controller?command=passing_filter_rooms"
                                       class="hotel-info__button"><fmt:message
                                            key="main_page.business_card_button"/></a>
                                </c:if>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <div class="promise-section">
            <div class="container">
                <div class="promise-section__subtitle"><fmt:message key="main_page.promise"/></div>
                <div class="promise-section__title"><fmt:message key="main_page.promise_to"/></div>
                <div class="promise-section__desc">
                    <fmt:message key="main_page.promise_text"/>
                </div>
            </div>
        </div>
        <div class="advantages-grid">
            <div class="container">
                <div class="advantages-grid__inner">
                    <div class="advantages-grid__item">
                        <div class="advantages-grid__icon">
                            <img src="${pageContext.request.contextPath}/images/room-service.png" alt="Room service">
                        </div>
                        <div class="advantages-grid__title"><fmt:message key="main_page.promise_room_service"/></div>
                        <div class="advantages-grid__details"><fmt:message
                                key="main_page.promise_room_service_text"/></div>
                    </div>
                    <div class="advantages-grid__item">
                        <div class="advantages-grid__icon">
                            <img src="${pageContext.request.contextPath}/images/wi-fi.png" alt="Wi-fi">
                        </div>
                        <div class="advantages-grid__title"><fmt:message key="main_page.promise_wifi"/></div>
                        <div class="advantages-grid__details"><fmt:message key="main_page.promise_wifi_text"/></div>
                    </div>
                    <div class="advantages-grid__item">
                        <div class="advantages-grid__icon">
                            <img src="${pageContext.request.contextPath}/images/mask.png" alt="Covid">
                        </div>
                        <div class="advantages-grid__title"><fmt:message key="main_page.promise_covid"/></div>
                        <div class="advantages-grid__details"><fmt:message key="main_page.promise_covid_text"/></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="${pageContext.request.contextPath}/jsp/footer.jsp"/>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>

</html>
