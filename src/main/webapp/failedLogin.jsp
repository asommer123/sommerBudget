<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Uh-Oh" />
<%@include file="head.jsp"%>

<html>
<body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container">
    Invalid userid/password combination. <br />
    <a href="login.jsp">Try again</a>
</div>
</body>
</html>


