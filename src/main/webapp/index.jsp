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


    <h3>Or excited and love it!</h3>
    <div class="fill-screen" style="text-align: center">
        <img class="make-it-fit" src="Images/FranklinReading.jpg" style="max-width: 99%; max-height: 99%">
    </div>

    <br>
    <br>

    <h3>Either way, budgeting is something everyone should do. So <a href="searchBudgetMonths">Login</a> to manage your budgets or <a href="/sommerBudget/createUser.jsp">Sign-up</a> to start the fun!</h3>

    <br>
    <br>
    <br>
    <br>
    <br>

    <h6>To go directly to admin functions <a href="searchUser">Login Here</a></h6>

    <br>
    <br>
    <br>
    <br>

</div>
</body>
</html>
