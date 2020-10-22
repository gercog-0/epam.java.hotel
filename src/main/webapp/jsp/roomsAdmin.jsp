<%--
  Created by Yanushkevich Ivan.
  Date: 15.10.2020
  Time: 13:58
  Page to show all rooms, add new or change status of them
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
    <title><fmt:message key="rooms_page.title"/></title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body"
         style="background-image: url(${pageContext.request.contextPath}/images/texture.png); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="admin-section">
            <div class="container">
                <div class="add-rooms-form">
                    <h3 class="add-rooms-form__title"><fmt:message key="rooms_page.add_room"/></h3>
                    <form action="DeluxeHotel" method="post" class="form">
                        <div class="form-grid">
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label">Number</span>
                                    <input type="text" class="form-control" name="roomNumber"
                                           placeholder="<fmt:message key="rooms_page.select_number"/>" required
                                           pattern="^\d{3}$"
                                           oninvalid="this.setCustomValidity('<fmt:message
                                                   key="rooms_page.incorrect_number"/>')"
                                           onchange="this.setCustomValidity('')" value="${roomData['roomNumber']}"/>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="rooms_page.comfort_type"/></span>
                                    <select class="form-control" required name="comfort">
                                        <option value="" selected hidden><fmt:message
                                                key="rooms_page.select_type"/></option>
                                        <option value="economy"><fmt:message key="rooms_page.economy"/></option>
                                        <option value="standard"><fmt:message key="rooms_page.standard"/></option>
                                        <option value="luxury"><fmt:message key="rooms_page.luxury"/></option>
                                        <option value="apartments"><fmt:message key="rooms_page.apartments"/></option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="rooms_page.places"/></span>
                                    <select class="form-control" required name="place_amount">
                                        <option value="" selected hidden><fmt:message
                                                key="rooms_page.select_places"/></option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label"><fmt:message key="rooms_page.price"/></span>
                                    <input type="text" class="form-control" name="price"
                                           placeholder="Input price of room" required pattern="^\d+\.?\d+$"
                                           oninvalid="this.setCustomValidity('<fmt:message
                                                   key="rooms_page.incorrect_price"/>')"
                                           onchange="this.setCustomValidity('')" value="${roomData['price']}"/>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-btn">
                                    <input type="hidden" name="command" value="add_room">
                                    <button type="submit" class="submit-btn"><fmt:message
                                            key="rooms_page.add_room_button"/></button>
                                </div>
                            </div>
                        </div>
                        <c:if test="${roomData['numberUnique'] eq 'notUnique'}">
                            <div class="form-error">
                                <p><fmt:message key="rooms_page.room_number_error"/></p>
                            </div>
                        </c:if>
                    </form>
                </div>
                <h2 class="admin-section__title"><fmt:message key="rooms_page.rooms"/></h2>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <tr>
                            <th><fmt:message key="rooms_page.number"/></th>
                            <th><fmt:message key="rooms_page.type"/></th>
                            <th><fmt:message key="rooms_page.places"/></th>
                            <th><fmt:message key="rooms_page.price"/></th>
                            <th>ACTIVE</th>
                            <th class="default-table__sort">
                                <span><fmt:message key="rooms_page.sort_by"/>:</span>
                                <a href="DeluxeHotel?command=sort_rooms&type_sort=price"><fmt:message
                                        key="rooms_page.price_type_sort"/></a>
                                <a href="DeluxeHotel?command=sort_rooms&type_sort=place_amount"><fmt:message
                                        key="rooms_page.places_type_sort"/></a>
                            </th>
                        </tr>
                        <c:forEach var="room" items="${rooms}">
                            <tr>
                                <td>${room.getNumber()}</td>
                                <td>${room.getComfort()}</td>
                                <td>${room.getPlaceAmount()}</td>
                                <td>${room.getPrice()}</td>
                                <td>${room.isActive()}</td>
                                <c:choose>
                                    <c:when test="${room.isActive() == true}">
                                        <td class="default-table__action">
                                            <a href="DeluxeHotel?command=disable_room&roomNumber=${room.getNumber()}"
                                               class="default-table__button default-table__button--red"><fmt:message
                                                    key="rooms_page.disable_button"/></a>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="default-table__action">
                                            <a href="DeluxeHotel?command=activate_room&roomNumber=${room.getNumber()}"
                                               class="default-table__button default-table__button--green"><fmt:message
                                                    key="rooms_page.activate_button"/></a>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
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