<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Welcome to sommerBudget" />
<%@include file="head.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 9/18/15
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<c:import url="navbar.jsp" />
<ul>
    <li><a href="searchUsers.jsp">Take me to the Admin Page</a></li>
    <li><a href="searchBudgetMonths">Login to view Budgets</a></li>
</ul>



</body>
</html>
