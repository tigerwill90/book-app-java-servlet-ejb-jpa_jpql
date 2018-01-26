<%--
  Created by IntelliJ IDEA.
  User: Sylvain
  Date: 16.01.2018
  Time: 01:29
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

    <form class="form col-md-12 center-block" action="${pageContext.request.contextPath}/create" method="POST">
        <legend>Créer un livre</legend>
        <div class="form-group">
            <input type="text" class="form-control input-lg" placeholder="Titre" name="title" required="true">
        </div>
        <div class="form-group">
            <input type="text" class="form-control input-lg" placeholder="Auteur" name="author" required="true">
        </div>
        <div class="form-group">
            <input type="text" class="form-control input-lg" placeholder="Editeur" name="editor" required="true">
        </div>
        <div class="form-group">
            <input type="text" class="form-control input-lg" placeholder="Année" name="year" minlength="4" maxlength="4" size="4">
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Créer</button>
        </div>
    </form>

<jsp:include page="bottom.jsp" />
