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
<h1>Applicant results</h1>
<c:choose>
  <c:when test="${applicantResults.size() == 0}">
    <p><c:out value="No applicant results yet"></c:out></p>
  </c:when>
  <c:otherwise>
    <table>
      <tr>
        <th>Applicant result ID</th>
        <th>Subject</th>
        <th>Applicant First Name</th>
        <th>Applicant Last Name</th>
        <th>Mark</th>
        <th>Actions</th>
      </tr>
      <c:forEach items="${applicantResults}" var="applicantResult">
        <tr>
          <td>
            <c:out value="${applicantResult.getId()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getSubject()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getApplicantFirstName()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getApplicantLastName()}"/>
          </td>
          <td>
            <c:out value="${applicantResult.getMark()}"/>
          </td>
          <td>
            <a href="controller?command=deleteApplicantResult&id=${applicantResult.getId()}"><img src="img/delete.jpg" alt="delete"></a>
            <a href="controller?command=editApplicantResult&id=${applicantResult.getId()}"><img src="img/edit.jpg" alt="edit" ></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:otherwise>
</c:choose>
<a href="controller?command=addApplicantResult"><img src="img/add.jpg" alt="add" ></a>
</body>
</html>