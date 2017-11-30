<%@include file="head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container-fluid">
    <h2>Budget Month: </h2>
    <h1>${budgetMonth}</h1>
</div>


<div class="container">
    <h2>Collapsible Panel</h2>
    <p>Click on the collapsible panel to open and close it.</p>
    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapse1">Collapsible panel</a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">Panel Body</div>
                <div class="panel-footer">Panel Footer</div>
            </div>
        </div>
    </div>
</div>




</body>
</html>



