<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="My Budgets" />
<%@include file="head.jsp"%>



<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container">
    <h2>Create a New Budget</h2>
    <p>Select the Month and Year</p>
    <form class="form-inline" action="addBudgetMonth" method="GET">
        <div class="form-group">
            <label for="selectMonth">Select Month</label>
            <select class="form-control" id="selectMonth" name="monthSelected">
                <option>January</option>
                <option>February</option>
                <option>March</option>
                <option>April</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>August</option>
                <option>September</option>
                <option>October</option>
                <option>November</option>
                <option>December</option>
            </select>
            <label for="selectYear">Select Year</label>
            <select class="form-control" id="selectYear" name="yearSelected">
                <option>2017</option>
                <option>2018</option>
                <option>2019</option>
                <option>2020</option>
            </select>
            <input type="submit" value="Start New Budget">
        </div>
    </form>
</div>

<br>
<br>

<br>
<br>
<div class="container">
    <h2>Select an Existing Budget to Edit/View Details</h2>
    <div class="selectBudget">
        <form action="getBudgetDetails" method="GET">
            <c:forEach var="budget" items="${budgetMonths}">
                <div class="radio">
                    <label><input type="radio" name="budgetId" value="${budget.budgetMonthId}">${budget.budgetMonth}-${budget.budgetYear}</label>
                </div>
            </c:forEach>
            <input type="submit" value="Edit/View Budget">
        </form>
    </div>
</div>

<br>
<br>
<br>

</body>
</html>



