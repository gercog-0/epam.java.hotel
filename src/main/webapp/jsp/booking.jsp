<%--
  Created by Ivan Yanushkevich.
  Date: 13.10.2020
  Time: 10:41
  Page to book rooms in hotel.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customTags" %>

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
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Lato:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css">
    <title><fmt:message key="booking.title"/></title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body" style="background-image: url(${pageContext.request.contextPath}/images/booking.jpg);">
        <div class="booking-section">
            <div class="booking-section__inner">
                <div class="booking-form">
                    <div class="form-header">
                        <h2><fmt:message key="booking.help_subtitle"/></h2>
                        <p><fmt:message key="booking.help_body"/></p>
                    </div>
                    <form action="DeluxeHotel" method="post" class="form">
                        <div class="form-grid">
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="booking.arrival_date"/></span>
                                    <input class="form-control form-control--date" type="date" name="arrivalDate"
                                           required>
                                </div>
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="booking.departure_date"/></span>
                                    <input class="form-control form-control--date" type="date" name="departureDate"
                                           required>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="booking.guests"/></span>
                                    <select class="form-control" name="placeAmount">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="booking.comfort_type"/></span>
                                    <select class="form-control" required name="comfort">
                                        <option value="ECONOMY" selected hidden><fmt:message
                                                key="booking.economy_type"/></option>
                                        <option value="STANDARD"><fmt:message key="booking.standard_type"/></option>
                                        <option value="LUXURY"><fmt:message key="booking.luxury_type"/></option>
                                        <option value="APARTMENTS"><fmt:message key="booking.apartments_type"/></option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                        </div>
                        <span class="error" style="color:#ff340a">${filterRoomsErrorMessage}</span>
                        <div class="form-btn">
                            <input type="hidden" name="command" value="filter_rooms">
                            <button type="submit" class="submit-btn"><fmt:message key="booking.find_button"/></button>
                        </div>
                    </form>
                </div>
                <div class="rooms">
                    <div class="rooms__header">
                        <h2><fmt:message key="booking.available_rooms"/></h2>
                        <c:if test="${not empty rooms}">
                            <div class="rooms__sort">
                                <span class="rooms__label"><fmt:message key="booking.sort_by"/></span>
                                <a href="DeluxeHotel?command=sort_rooms&type_sort=price"
                                   class="rooms__sort-link"><fmt:message key="booking.price"/></a>
                                <a href="DeluxeHotel?command=sort_rooms&type_sort=place_amount"
                                   class="rooms__sort-link"><fmt:message key="booking.places"/></a>
                            </div>
                        </c:if>
                    </div>
                    <table class="rooms-table">
                        <c:choose>
                            <c:when test="${empty rooms && rooms.size() == 0}">
                                <tr>
                                    <td><fmt:message key="booking.not_found_message"/></td>
                                </tr>
                            </c:when>
                            <c:when test="${empty rooms}">
                                <tr>
                                    <td><fmt:message key="booking.set_parameters_message"/></td>
                                </tr>
                            </c:when>
                            <c:when test="${not empty rooms}">
                                <tr>
                                    <th><fmt:message key="booking.number"/></th>
                                    <th><fmt:message key="booking.type"/></th>
                                    <th><fmt:message key="booking.places"/></th>
                                    <th><fmt:message key="booking.price"/></th>
                                    <th></th>
                                </tr>
                                <c:forEach var="room" items="${paginationRooms}">
                                    <tr>
                                        <td>${room.getNumber()}</td>
                                        <td>${room.getComfort()}</td>
                                        <td>${room.getPlaceAmount()}</td>
                                        <td>${room.getPrice()}$</td>
                                        <td class="rooms-table__action">
                                            <a href="DeluxeHotel?command=booking&roomNumber=${room.getNumber()}"
                                               class="rooms-table__button">
                                                <fmt:message key="booking.book_button"/>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </table>
                    <c:if test="${not empty quantityPages}">
                        <div class="rooms__footer">
                            <div class="pagination">
                                <ctg:roomsPagination quantityPages="${quantityPages}" pageNumber="${pageNumber}"/>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</html>