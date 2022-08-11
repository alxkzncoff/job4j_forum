<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
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

    <title>Форум</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="<c:url value='/index'/>">
        <img src="${pageContext.request.contextPath}/resources/img/bubble_logo.png"
             alt="Форум" width="32" height="32" class="d-inline-block align-text-top"/>
        Форум
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <a class="nav-item nav-link">
                <span>
                    <a href="<c:url value='/add'/>" style="color: white; font-size: 20px" > Новая тема </a>
                </span>
        </a>
    </div>
</nav>
<div class="container-xl">
    <div class="row pt-3">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">Дата публикации</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>
                        <img src="${pageContext.request.contextPath}/resources/img/topic_bubble.png"
                             alt="" width="32" height="32" class="d-inline-block align-text-top"/>
                        <a href="<c:url value='/description/${post.id}'/>" style="color: black" ><c:out value="${post.name}"/></a>
                    </td>
                    <td>
                        <c:out value="${post.created.toGMTString()}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="container">
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top fixed-bottom">
        <div class="col-md-4 d-flex align-items-center">
            <a href="" class="mb-3 me-5 mb-md-0 text-muted text-decoration-none lh-1">
                <img src="${pageContext.request.contextPath}/resources/img/bubble_logo_black.png" alt="" width="24" height="24" class="d-inline-block align-text-top"/>
            </a>
        </div>
        <span class="mb-3 mb-md-0 text-muted">alxkzncoff 2022</span>
        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3">
                <a class="text-muted" href="https://github.com/alxkzncoff">
                    <img src="${pageContext.request.contextPath}/resources/img/github_logo.png" alt="alxkzncoff" width="24" height="24"/>
                </a>
            </li>
        </ul>
    </footer>
</div>
</body>
</html>