<%--
  Created by IntelliJ IDEA.
  User: Sylvain
  Date: 04.01.2018
  Time: 18:49
--%>
<jsp:include page="top.jsp" />

        <form class="form col-md-12 center-block" action="j_security_check" method="POST">
            <div class="form-group">
                <input type="text" class="form-control input-lg" placeholder="Identifiant" name="j_username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control input-lg" placeholder="Mot de passe" name="j_password">
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Sign In</button>
            </div>
        </form>

<jsp:include page="bottom.jsp" />
