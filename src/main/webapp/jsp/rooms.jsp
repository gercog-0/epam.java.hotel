<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12.10.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="room" items="${freeRooms}">
    ${room}
</c:forEach>
</body>
</html>
