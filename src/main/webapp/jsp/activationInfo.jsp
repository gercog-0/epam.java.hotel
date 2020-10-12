<%--
  Created by Yanushkevich Ivan.
  Date: 08.10.2020
  Time: 14:04
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty language}">
    <fmt:setLocale value="${language}"/>
</c:if>

<fmt:setBundle basename="pagecontent.language"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="activation_page.title"/></title>
</head>
<body>
    <fmt:message key="activation_page.confirm_registration"/>
</body>
</html>
