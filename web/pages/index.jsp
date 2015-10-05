<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="menu">
    <ul>
        <li><a href="controller?command=applicants">Applicants</a></li>
        <li><a href="controller?command=professions">Professions</a></li>
        <li><a href="controller?command=specialitySubjects">Speciality subjects</a></li>
        <li><a href="controller?command=subjects">Subjects</a></li>
        <li><a href="controller?command=applicantResults">Applicant results</a></li>
    </ul>
</div>
</body>
</html>
