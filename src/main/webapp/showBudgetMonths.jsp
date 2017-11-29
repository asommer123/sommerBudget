<%@include file="head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    table, th, td {
        border: 3px solid #696969;
        border-collapse: collapse;
    }
    th {
        color: #0000FF;
    }
    th, td {
        padding: 6px;
        text-align: left;
    }
    tr:hover {background-color:#FFEFD5}
</style>


<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container-fluid">
    <h2>Budget Months: </h2>



    <table style="width:100%">
        <tr>
            <th>Budget Month Id</th>
            <th>Budget Date</th>
        </tr>

        <c:forEach var="budgetMonth" items="${budgetMonths}">
            <tr>
                <td>${budgetMonth.budgetMonthId}</td>
                <td>${budgetMonth.budgetDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<br>
<br>

<div class="container">
    <form action="addBudgetMonth" method="GET">
        Budget Month:
        <input type="date" name="budgetDate">
        <input type="submit" value="Start New Budget">
    </form>
</div>

<br>
<br>

<div class="selectBudget">
    <form action="getBudgetDetails" method="get">
        <c:forEach var="budgetMonth" items="${budgetMonths}">
            <div class="radio">
                <label><input type="radio" name="budgetId" value="${budgetMonth.budgetMonthId}">${budgetMonth.budgetDate}</label>
            </div>
        </c:forEach>
        <input type="submit" value="Edit/View Budget">
    </form>
</div>


<br>
<br>
<br>

<div class="container-fluid">
    <h2>Budget Months: </h2>

    <table id="example" class="display" cellspacing="0" width="100%">
        <tr>
            <th>Budget Month Id</th>
            <th>Budget Date</th>
        </tr>

        <c:forEach var="budgetMonth" items="${budgetMonths}">
            <tr>
                <td>${budgetMonth.budgetMonthId}</td>
                <td>${budgetMonth.budgetDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>



<script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>



</body>
</html>



