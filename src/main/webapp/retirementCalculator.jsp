<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Retirement Calculator" />
<%@include file="head.jsp"%>



<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container">
    <h2>Calculate How Much You Need to Secure Your Retirement</h2>
    <br>
    <form class="form-horizontal" action="getRetirementNumbers" method="post">
        <div class="form-group">
            <label for="good">Current Age:</label>

                <input type="text" class="form-control" style="width:50%" id="good" placeholder="Enter current age" name="currentAge">

        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="retirementAge">Retirement Age:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="retirementAge" placeholder="Enter ideal retirement age" name="retirementAge">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="yearsAfterRetirement">Expected number of years in retirement:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="yearsAfterRetirement" placeholder="Enter years after retirement" name="yearsAfterRetirement">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="supplementaryAllowance">Supplementary monthly allowance after retirement:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="supplementaryAllowance" placeholder="Enter supplementary monthly allowance" name="supplementaryAllowance">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="monthlySpending">Desired monthly spending after retirement:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="monthlySpending" placeholder="Enter desired monthly spending" name="monthlySpending">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="srsValue">Amount of CPF SRS you have:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="srsValue" placeholder="Enter current CPF SRS amount" name="srsValue">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="propertySaleValue">Property Sale Value:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="propertySaleValue" placeholder="Enter property sale value" name="propertySaleValue">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="regularInvestments">Regular monthly investments:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="regularInvestments" placeholder="Enter regular monthly investments" name="regularInvestments">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lumpSumInvestments">Lump sum investment:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lumpSumInvestments" placeholder="Enter value of your lump sum investments" name="lumpSumInvestments">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="cashAndDeposits">Fixed deposits and existing saving in bank:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="cashAndDeposits" placeholder="Enter value of your fixed deposits and existing saving in bank" name="cashAndDeposits">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="growthOpt">Fixed deposits and existing saving in bank:</label>
            <div class="col-sm-10">
                <select class="form-control" id="growthOpt" name="growthOpt">
                    <option value="0">Default 0.63% growth</option>
                    <option value="2">Very Conserative</option>
                    <option value="3">Conservative</option>
                    <option value="5">Balanced</option>
                    <option value="7">Aggressive</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Calculate</button>
            </div>
        </div>
    </form>
</div>


<script type="text/javascript">
    $('.good').inputmask("numeric", {
        radixPoint: ".",
        groupSeparator: ",",
        digits: 2,
        autoGroup: true,
        prefix: '$ ', //Space after $, this will not truncate the first character.
        rightAlign: false,
        oncleared: function () { self.Value(''); }
    });

</script>
</body>
</html>