<%--
  Created by Yanushkevich Ivan.
  Date: 16.10.2020
  Time: 15:03
  Admin page with active booking to approve
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
    <title><fmt:message key="admin_page.title"/></title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body"
         style="background-image: url(${pageContext.request.contextPath}/images/texture.png); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="admin-section">
            <div class="container">
                <h2 class="admin-section__title"><fmt:message key="admin_page.active_bookings"/></h2>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <c:choose>
                            <c:when test="${empty bookings || bookings.size() == 0}">
                                <tr>
                                    <td><fmt:message key="admin_page.not_found_message"/></td>
                                </tr>
                            </c:when>
                            <c:when test="${not empty bookings}">
                                <tr>
                                    <th><fmt:message key="admin_page.username"/></th>
                                    <th><fmt:message key="admin_page.room_number"/></th>
                                    <th><fmt:message key="admin_page.arrival_date"/></th>
                                    <th><fmt:message key="admin_page.departure_date"/></th>
                                    <th><fmt:message key="admin_page.status"/></th>
                                    <c:choose>
                                        <c:when test="${showCommand}">
                                            <th class="default-table__sort">
                                        <span>
                                            <a href="controller?command=passing_waiting_bookings_admin">
                                                <fmt:message key="admin_page.show_active_bookings"/>
                                            </a>
                                        </span>
                                            </th>
                                        </c:when>
                                        <c:otherwise>
                                            <th class="default-table__sort">
                                        <span>
                                            <a href="controller?command=show_all_bookings">
                                                <fmt:message key="admin_page.show_all_bookings"/>
                                            </a>
                                        </span>
                                            </th>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                                <c:forEach var="booking" items="${bookings}">
                                    <tr>
                                        <td>${booking.getUser().getLogin()}</td>
                                        <td>${booking.getRoom().getNumber()}</td>
                                        <td>${booking.getArrivalDateString()}</td>
                                        <td>${booking.getDepartureDateString()}</td>
                                        <td>${booking.getStatus()}</td>
                                        <c:choose>
                                            <c:when test="${booking.getStatus() eq 'WAITING'}">
                                                <td class="default-table__action">
                                                    <a href="controller?command=approve_booking&bookingId=${booking.getBookingId()}"
                                                       class="default-table__button default-table__button--green">
                                                        <fmt:message key="admin_page.approve_button"/>
                                                    </a>
                                                    <a href="controller?command=rejected_booking&bookingId=${booking.getBookingId()}"
                                                       class="default-table__button default-table__button--red">
                                                        <fmt:message key="admin_page.reject_button"/>
                                                    </a>
                                                </td>
                                            </c:when>
                                            <c:when test="${booking.getStatus() eq 'REJECTED'}">
                                                <td class="default-table__action"></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class="default-table__action">
                                                    <a href="controller?command=rejected_booking&bookingId=${booking.getBookingId()}"
                                                       class="default-table__button default-table__button--red">
                                                        <fmt:message key="admin_page.reject_button"/>
                                                    </a>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </table>
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