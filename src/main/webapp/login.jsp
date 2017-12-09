<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Log In" />
<%@include file="head.jsp"%>


<html>
<body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container-fluid"><br>

    <FORM ACTION="j_security_check" METHOD="POST">
        <TABLE>
            <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
            <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
            <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
        </TABLE>
    </FORM>
</div>
</body>
</html>


