<%--
  Created by IntelliJ IDEA.
  User: KuzAS
  Date: 12.08.2022
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
          integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
          integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
          integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

  <style>
    h1 {
      margin-bottom: 15px;
    }
  </style>

  <title>Форум</title>
</head>
<body class="text-center">
<div class="row pt-3">
  <div class="col-sm"></div>
  <div class="col-sm">
    <div class="card" style="width: 100%">
      <div class="card-body">
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                    ${errorMessage}
            </div>
        </c:if>
        <c:if test="${not empty successReg}">
            <div class="alert alert-success" role="alert">
                    ${successReg}
            </div>
        </c:if>
        <form form name='login' action="<c:url value='/login'/>" method='POST'>
          <img class="mb-4" src="${pageContext.request.contextPath}/resources/img/signin_logo.png">
          <h1>Добро пожаловать на форум!</h1>
          <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
          <button type="submit" class="btn btn-success"> Авторизация </button>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <a class="btn btn-primary" href="<c:url value='/reg'/>" role="button"> Регистрация </a>
        </form>
        <p class="mt-5 mb-3 text-muted"> © alxkzncoff 2022 </p>
      </div>
    </div>
  </div>
  <div class="col-sm"></div>
</div>
</body>
</html>
