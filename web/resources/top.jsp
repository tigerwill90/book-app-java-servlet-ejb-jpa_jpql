<%--
  Created by IntelliJ IDEA.
  User: Sylvain
  Date: 04.01.2018
  Time: 16:56
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
            integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
            crossorigin="anonymous"
    >
    <!-- Inject jquery dependencies -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>

    <title>Bibliothèque</title>

</head>
<body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <h1 class="navbar-brand mb-0">Bibliothèques</h1>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/">Accueil </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/books">Livres</a>
                    </li>
                </ul>
                <% request.setAttribute("isAuthenticated", request.isUserInRole("tomee-admin")); %>
                <c:choose>
                    <c:when test="${!requestScope.isAuthenticated}">
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Connexion</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Deconnexion</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
        <div class="container" style="padding-top: 10%;">
