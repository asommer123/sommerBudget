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
    <h2>Search Results: </h2>



    <table style="width:100%">
    <tr>
        <th>Account ID</th>
        <th>User Name</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.accountId}</td>
            <td>${user.userName}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.emailAddress}</td>
        </tr>
    </c:forEach>
    </table>
</div>








</body>
</html>
