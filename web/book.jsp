<%--
  Created by IntelliJ IDEA.
  User: sylvain
  Date: 15.01.2018
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="top.jsp" />

<div class="container">
    <h2>Liste des livres</h2>
    <% request.setAttribute("isAuthenticated", request.isUserInRole("tomee-admin")); %>
    <c:if test="${!requestScope.isAuthenticated}">
        <p>Vous devez vous authentifier pour consulter ou créer de nouveaux livres ! </p>
    </c:if>
    <table class="table">
        <thead>
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Editeur</th>
            <th>Année</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${requestScope.isAuthenticated}">
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.editor}" /></td>
                    <td><c:out value="${book.year}" /></td>
                    <td><a href="books?id=${book.id}"
                           class="btn btn-danger" type="button">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
<c:if test="${requestScope.isAuthenticated}">
    <div class="pull-right">
        <a href="/create" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Nouveau</a>
    </div>
</c:if>

<jsp:include page="bottom.jsp" />