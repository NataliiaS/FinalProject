<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <style>
        <%@include file='style.css' %>
    </style>
</head>
<body>
<div class="header">
    <h2><a class="header-link" href="/app">Main Dashboard</a></h2>
</div>
<h1>Add profession</h1>
<form method="post" action="controller?command=saveProfession">
    <p>Name</p>
    <c:choose>
        <c:when test="${profession ne null}">
            <input type="text" name="profession_name" value="${profession.getProfessionName()}"/>
            <input type="hidden" name="profession_id" value="${profession.getId()}"/>
        </c:when>
        <c:otherwise>
            <input type="text" name="profession_name" value=""/>
        </c:otherwise>
    </c:choose>
</form>
</body>
</html>
