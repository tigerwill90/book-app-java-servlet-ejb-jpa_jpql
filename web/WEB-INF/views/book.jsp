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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="top.jsp" />

<div class="container">
    <c:if test="${notif}">
        <div class="alert alert-success">
            <strong>Livre ajouté :</strong> Le nouveau livre <c:out value="${bookTitle}"></c:out> est maintenant disponnible dans la bibliothèques.
        </div>
    </c:if>
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
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${requestScope.isAuthenticated}">
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.editor}" /></td>
                    <td><fmt:formatDate value="${book.year}" pattern="yyyy" /></td>
                    <td><a href="${pageContext.request.contextPath}/books?id=${book.id}"
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
        <a href="${pageContext.request.contextPath}/create" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Nouveau</a>
    </div>
</c:if>

<jsp:include page="bottom.jsp" />