<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Create New User" />
<%@include file="head.jsp"%>



<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container">
    <h2>Calculate How Much You Need to Secure Your Retirement</h2>
    <br>
    <form class="form-horizontal" action="createNewUser" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="userName">Current Age:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width:50%" id="userName" name="userName" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="userPassword">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" style="width:50%" id="userPassword" name="userPassword" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">Frist Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width:50%" id="firstName" name="firstName">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width:50%" id="lastName" name="lastName">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="emailAddress">Email Address:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width:50%" id="emailAddress" name="emailAddress">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign Up</button>
            </div>
        </div>
    </form>
</div>


</body>
</html>