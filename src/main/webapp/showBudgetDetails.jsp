<%@include file="head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

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



