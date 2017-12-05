<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Retirement Results" />
<%@include file="head.jsp"%>



<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>


<div class="container">
    <form class="form-horizontal">
        <div class="form-group">
            <label>The total amount of your future lump sum investment at the end of your retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.futureLsInvestment)}</p>
        </div>
        <div class="form-group">
            <label>	The total amount of cash and deposits that you grow after investing:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.afterInvesting)}</p>
        </div>
        <div class="form-group">
            <label>The total amount you would need for your retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.finalCost)}</p>
        </div>
        <div class="form-group">
            <label>The total amount you set aside upon retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.totalSetAside)}</p>
        </div>
        <div class="form-group">
            <label>The total amount of lump sum investments you set aside upon retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.lumpSumSetAside)}</p>
        </div>
        <div class="form-group">
            <label>The total amount of cash and deposits that you have before investing:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.beforeInvesting)}</p>
        </div>
        <div class="form-group">
            <label>The total amount of SRS you set aside upon retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.srsSetAside)}</p>
        </div>
        <div class="form-group">
            <label>The total amount of regular investments you set aside upon retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.regularSetAside)}</p>
        </div>
        <div class="form-group">
            <label>The total amount of surplus or shortfall you have upon retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.finalSurplus)}</p>
        </div>
        <div class="form-group">
            <label>The total amount of cash and deposits you set aside upon retirement:</label>
            <p class="form-control-static">${currencyFormat.formatToCurrency(retirement.results.cashDepositSetAside)}</p>
        </div>
    </form>
</div>

<br>
<br>
<br>
<br>
<br>

<div class="container">
    <h6>Disclaimer: ${retirement.disclaimer}</h6>
</div>

</body>
</html>
