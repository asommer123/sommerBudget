<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/sommerBudget">sommerBudget</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/sommerBudget">Home</a></li>
            <li><a href="/sommerBudget/retirementCalculator.jsp">Retirement Calculator</a></li>
        </ul>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${adminLoggedIn == true}">
                        <li><a href="searchUser"><span class="glyphicon glyphicon-scissors"></span> Admin</a></li>
                        <li><a href="searchBudgetMonths"><span class="glyphicon glyphicon-user"></span> Budgets</a></li>
                        <li><a href="userSignOut"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
                    </c:when>
                    <c:when test="${regularLoggedIn == true}">
                        <li><a href="searchBudgetMonths"><span class="glyphicon glyphicon-user"></span> Budgets</a></li>
                        <li><a href="userSignOut"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/sommerBudget/createUser.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="searchBudgetMonths"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<br>
<br>
<br>