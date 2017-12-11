<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="My Budgets" />
<%@include file="head.jsp"%>



<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>


<script type="text/javascript">
    $(document).on("submit", "#add_form", function(event) {
        var $form = $(this);
        var id = document.getElementById("b_budgetedId").value;
        $('#deleteBudgetMonthModal').modal('hide');
        $.post($form.attr("action"), $form.serialize(), function(response) {
            var btnadd = $('#' + id);
            btnadd.removeClass("btn-success").addClass("btn-default");
            btnadd.find('span').toggleClass('glyphicon-edit').toggleClass('glyphicon-check');
            btnadd.attr('disabled','disabled');
        });
        $('#deleteBudgetMonthModal').on('hidden.bs.modal', function () {
            location.reload();
        });
        event.preventDefault();
    });
</script>


<div class="container">
    <h2>Create a New Budget</h2>
    <p>Select the Month and Year</p>
    <form class="form-inline" action="addBudgetMonth" method="GET">
        <div class="form-group">
            <label for="selectMonth">Select Month</label>
            <select class="form-control" id="selectMonth" name="monthSelected">
                <option>January</option>
                <option>February</option>
                <option>March</option>
                <option>April</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>August</option>
                <option>September</option>
                <option>October</option>
                <option>November</option>
                <option>December</option>
            </select>
            <label for="selectYear">Select Year</label>
            <select class="form-control" id="selectYear" name="yearSelected">
                <option>2017</option>
                <option>2018</option>
                <option>2019</option>
                <option>2020</option>
            </select>
            <input type="submit" value="Start New Budget">
        </div>
    </form>
</div>

<br>
<br>

<br>
<br>
<div class="container">
    <h2>Select an Existing Budget to Edit/View Details</h2>
    <div class="selectBudget">
        <form action="getBudgetDetails" method="GET">
            <c:forEach var="budget" items="${budgetMonths}">
                <div class="radio">
                    <label><input type="radio" name="budgetId" value="${budget.budgetMonthId}">${budget.budgetMonth}-${budget.budgetYear}</label>
                </div>

                <script type="text/javascript" class="init">
                    $(document).ready(function() {

                        $('#deleteBudgetMonth').click(function () {
                            var budgetId = '${budget.budgetMonthId}';
                            var budgetMonth = '${budget.budgetMonth}';
                            var budgetYear = '${budget.budgetYear}';
                            var mymodal = $('#deleteBudgetMonthModal');

                            mymodal.find('.modal-title').text("Confirm Delete of " + budgetMonth + "-" + budgetYear + " Budget");
                            mymodal.find('#b_budgetId').val(budgetId);
                            mymodal.find('#b_budgetMonth').val(budgetMonth);
                            mymodal.find('#b_budgetYear').val(budgetYear);

                            $('#deleteBudgetMonthModal').modal('show');
                        });

                    } );
                </script>
            </c:forEach>
            <button type="submit" name="submit" value="getBudget">Edit/View Budget</button>
            <button type="submit" name="submit" value="deleteBudget" id="deleteBudgetMonth">Delete Budget</button>


            <c:import url="deleteBudgetMonthModal.jsp" />
        </form>
    </div>
</div>



</div>


<br>
<br>
<br>

</body>
</html>



