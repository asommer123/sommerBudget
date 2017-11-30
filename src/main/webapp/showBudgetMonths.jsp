<%@include file="head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>


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
    <form action="getBudgetDetails" method="GET">
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

    <div class="row">

        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Budget Month Id</th>
                    <th>Budget Date</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach var="budgetMonth" items="${budgetMonths}">
                    <tr>
                        <td>${budgetMonth.budgetMonthId}</td>
                        <td>${budgetMonth.budgetDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>



<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>



</body>
</html>



