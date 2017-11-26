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

</body>
</html>
