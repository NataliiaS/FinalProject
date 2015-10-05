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
<h1>Add speciality subjects</h1>
<form method="post" action="controller?command=saveSpecialitySubjects">
  <c:choose>
    <c:when test="${specialitySubject ne null}">
      <input type="hidden" name="sp_sb_id" value="${specialitySubject.getId()}"/>
      <p>Profession</p>
      <select name="profession_id">
        <c:forEach items="${professions}" var="profession">
          <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
        </c:forEach>
      </select>
      <p>Subject</p>
      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>
      <p></p>
    </c:when>
    <c:otherwise>
      <p>Profession</p>
      <select name="profession_id">
        <c:forEach items="${professions}" var="profession">
          <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
        </c:forEach>
      </select>
      <p>Subject</p>
      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>
      <p></p>
    </c:otherwise>
  </c:choose>
  <input type="image" src="img/save.jpg" alt="save" >
</form>
</body>
</html>
