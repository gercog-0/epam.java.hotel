<%--
  Created by Ivan Yanushkevich.
  Date: 15.10.2020
  Time: 13:59
  Admin`s page with all users
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
    <title><fmt:message key="users_page.title"/></title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body"
         style="background-image: url(${pageContext.request.contextPath}/images/texture.png); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="admin-section">
            <div class="container">
                <h2 class="admin-section__title"><fmt:message key="users_page.subtitle"/></h2>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <tr>
                            <th><fmt:message key="users_page.login"/></th>
                            <th><fmt:message key="users_page.email"/></th>
                            <th><fmt:message key="users_page.phone"/></th>
                            <th><fmt:message key="users_page.name"/></th>
                            <th><fmt:message key="users_page.surname"/></th>
                            <th><fmt:message key="users_page.banned"/></th>
                            <th><fmt:message key="users_page.activated"/></th>
                            <th class="default-table__sort">
                                <span>Sort by:</span>
                                <a href="DeluxeHotel?command=sort_users&sortType=name">
                                    <fmt:message key="users_page.name"/></a>
                                <a href="DeluxeHotel?command=sort_users&sortType=login"><fmt:message
                                        key="users_page.login"/></a>
                            </th>
                        </tr>
                        <c:forEach var="user" items="${allUsers}">
                            <tr>
                                <td>${user.getLogin()}</td>
                                <td>${user.getEmail()}</td>
                                <td>${user.getPhone()}</td>
                                <td>${user.getName()}</td>
                                <td>${user.getSurname()}</td>
                                <td>${user.isBanned()}</td>
                                <td>${user.isActivated()}</td>
                                <c:choose>
                                    <c:when test="${user.isBanned() == true}">
                                        <td class="default-table__action">
                                            <a href="DeluxeHotel?command=un_ban_user&login=${user.getLogin()}"
                                               class="default-table__button default-table__button--red"><fmt:message
                                                    key="users_page.unban_button"/></a>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="default-table__action">
                                            <a href="DeluxeHotel?command=ban_user&login=${user.getLogin()}"
                                               class="default-table__button default-table__button--green"><fmt:message
                                                    key="users_page.ban_button"/></a>
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