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
<style>
  <%@include file='style.css' %>
</style>
<h1>Add applicant result</h1>
<form method="post" action="controller?command=saveApplicantResult">
  <c:choose>
    <c:when test="${applicantResult ne null}">
      <input type="hidden" name="applicant_result_id" value="${applicantResult.getId()}"/>
      <p>Mark</p>
      <input type="text" name="mark" value="${applicantResult.getMark()}"/>
      <p>Subject</p>
      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>
      <p>Applicant</p>
      <select name="applicant_id">
        <c:forEach items="${applicants}" var="applicant">
          <option value="${applicant.getId()}"><c:out value="${applicant.getFirstName()} ${applicant.getLastName()}"/></option>
        </c:forEach>
      </select>
      <p></p>
    </c:when>
    <c:otherwise>
      <p>Mark</p>
      <input type="text" name="mark" value=""/>
      <p>Subject</p>
      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>
      <p>Applicant</p>
      <select name="applicant_id">
        <c:forEach items="${applicants}" var="applicant">
          <option value="${applicant.getId()}"><c:out value="${applicant.getFirstName()} ${applicant.getLastName()}"/></option>
        </c:forEach>
      </select>
      <p></p>
    </c:otherwise>
  </c:choose>
  <input type="image" src="img/save.jpg" alt="save" >
</form>
</body>
</html>
