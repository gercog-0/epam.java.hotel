<%--
  Created by Ivan Yanushkevich.
  Date: 15.10.2020
  Time: 14:06
  User profile page
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

    <title>Profile</title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body" style="background-image: url(${pageContext.request.contextPath}/images/cover6.jpg); background-size: cover;">
        <div class="account-section">
            <div class="container">
                <h2 class="account-section__title">My booking</h2>
                <div class="account-error">
                    You have no enough money.
                    <a href="#">Deposite</a>
                </div>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <tr>
                            <th>Booking №</th>
                            <th>Room №</th>
                            <th>Arrival Date</th>
                            <th>Departure Date</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th class="default-table__sort">
                                <span>Sort by:</span>
                                <a href="#">Arrival Date</a>
                            </th>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>100$</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green default-table__button--lg">Pay</a>
                            </td>
                        </tr>
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
