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
<h1>Add applicant</h1>
<form method="post" action="controller?command=saveApplicant">
  <c:choose>
    <c:when test="${applicant ne null}">
      <input type="hidden" name="applicant_id" value="${applicant.getId()}"/>
      <p>Profession Name</p>
      <select name="profession_id">
        <c:forEach items="${professions}" var="profession">
          <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
        </c:forEach>
      </select>
      <p>Entrance year</p>
      <input type="text" name="entrance_year" value="${applicant.getEntranceYear()}"/>
      <p>First name</p>
      <input type="text" name="first_name" value="${applicant.getFirstName()}"/>
      <p>Last name</p>
      <input type="text" name="last_name" value="${applicant.getLastName()}"/>
      <p></p>
    </c:when>
    <c:otherwise>
      <p>Profession Name</p>
      <select name="profession_id">
        <c:forEach items="${professions}" var="profession">
          <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
        </c:forEach>
      </select>
      <p>Entrance year</p>
      <input type="text" name="entrance_year" value=""/>
      <p>First name</p>
      <input type="text" name="first_name" value=""/>
      <p>Last name</p>
      <input type="text" name="last_name" value=""/>
      <p></p>
    </c:otherwise>
  </c:choose>
  <input type="image" src="img/save.jpg" alt="save" >
</form>
</body>
</html>
