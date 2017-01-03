<%-- 
    Document   : index
    Created on : Aug 8, 2016, 12:22:41 PM
    Author     : Nikil
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${SITE_URL}/static/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
        <link href="${SITE_URL}/static/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet"/>
        <script src="${SITE_URL}/static/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/static/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/static/js/bootstrap.min.js"></script>
        <link href="${SITE_URL}/static/css/style.css" rel="stylesheet" type="text/css"/>
 
    </head>
    <body style="background-image: url(${SITE_URL}/static/image/back.jpg);background-size:cover">
   <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hotel Swing</a>
    </div>
    <ul class="nav navbar-nav">
      <li> <a href="${SITE_URL}">Home</a></li>
      <li><a href="${SITE_URL}/admin/users">Users</a></li>
      <li><a href="${SITE_URL}/admin/room">Room</a></li>
      <li><a href="${SITE_URL}/admin/booking">Booking</a></li>
      <li><a href="${SITE_URL}/admin/comments">Comments</a></li>
       <li><a href="${SITE_URL}/admin/checkin/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
<!--    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${SITE_URL}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>-->
  </div>
</nav>