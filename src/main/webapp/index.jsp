<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Welcome to sommerBudget" />
<%@include file="head.jsp"%>

<html>
<body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container">
    <br>

    <h1>How does budgeting make you feel?</h1>

    <br>

    <h3>Like you should be sleeping...</h3>
    <div class="fill-screen" style="text-align: center">
        <img class="make-it-fit" src="Images/FranklinSleeping.jpg" style="max-width: 99%; max-height: 99%">
    </div>

    <br>


    <h3>Or excited and want to continue on!</h3>
    <div class="fill-screen" style="text-align: center">
        <img class="make-it-fit" src="Images/FranklinReading.jpg" style="max-width: 99%; max-height: 99%">
    </div>

    <br>

    <ul>
        <li><a href="searchUsers.jsp">Take me to the Admin Page</a></li>
        <li><a href="searchBudgetMonths">Login to view Budgets</a></li>
    </ul>

</div>
</body>
</html>
