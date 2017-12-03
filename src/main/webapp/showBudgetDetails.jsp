<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<c:set var="title" value="${budget.budgetMonth} ${budget.budgetYear}" />




<html>
<body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>


<div class="container">
    <h2>Budget Details for ${budget.budgetMonth} ${budget.budgetYear} ... maybe put totals here?</h2>
    <p>Click on each Category to open and close it.</p>


    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapse1">what went here again?</a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">Each budgetedSubCategories



                    <div class="container-fluid">
                        <h2>Budget Months: </h2>

                        <div class="row">

                            <table id="budgetedItemsTable" class="display" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>Category Name</th>
                                    <th>Sub Category Name</th>
                                    <th>Budgeted Id</th>
                                    <th>Budgeted Amount</th>
                                    <th>Due Date</th>
                                    <th>Envelope Amount</th>
                                    <th>Note</th>
                                    <th>Day Of Month Due</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="budgetItem" items="${budget.budgetedSubCategories}">
                                    <tr>
                                        <td>${budgetItem.subCategoryBySubCategoryId.category.categoryName}</td>
                                        <td>${budgetItem.subCategoryBySubCategoryId.subCategoryName}</td>
                                        <td>${budgetItem.budgetedId}</td>
                                        <td>${budgetItem.budgetedAmount}</td>
                                        <td>${budgetItem.dueDate}</td>
                                        <td>${budgetItem.envelopeAmount}</td>
                                        <td>${budgetItem.note}</td>
                                        <td>${budgetItem.subCategoryBySubCategoryId.dayOfMonthDue}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>



                </div>
            </div>
        </div>
    </div>





    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapse2">Attempt with forms</a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse">
                <div class="panel-body">Each budgetedSubCategories form attempt



                    <div class="container-fluid">

                        <form class="form-inline" action="updateBudgetedItem" method="POST">
                            <input type="hidden" id="budgetId" name="budgetId" value="${budget.budgetMonthId}">
                            <c:forEach var="budgetItem" items="${budget.budgetedSubCategories}">

                                <div class="form-group">
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="category" name="category" value="${budgetItem.subCategoryBySubCategoryId.category.categoryName}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="subCategory" name="subCategory" value="${budgetItem.subCategoryBySubCategoryId.subCategoryName}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="budgetedId" name="budgetedId" value="${budgetItem.budgetedId}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="budgetedAmount" name="budgetedAmount" value="${budgetItem.budgetedAmount}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="dueDate" name="dueDate" value="${budgetItem.dueDate}">
                                    </div>
                                    <div class="col-xs-2">
                                            <input type="text" class="form-control" id="envelopeAmount" name="envelopeAmount" value="${budgetItem.envelopeAmount}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="note" name="note" value="${budgetItem.note}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" id="dayOfMonthDue" name="dayOfMonthDue" value="${budgetItem.subCategoryBySubCategoryId.dayOfMonthDue}">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="submit" value="Update">
                                    </div>
                                </div>
                            </c:forEach>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>





    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapse3">Attempt with forms second one</a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse">
                <div class="panel-body">Each budgetedSubCategories form attempt



                    <div class="container-fluid">


                        <c:forEach var="budgetItem" items="${budget.budgetedSubCategories}">

                            <form class="form-inline" action="updateBudgetedItem" method="POST">
                                <input type="hidden" id="budgetId2" name="budgetId" value="${budget.budgetMonthId}">

                                <div class="form-group">
                                        <input type="text" class="form-control" id="subCategory2" name="subCategory" value="${budgetItem.subCategoryBySubCategoryId.subCategoryName}">
                                        <input type="text" class="form-control" id="budgetedAmount2" name="budgetedAmount" value="${budgetItem.budgetedAmount}">
                                        <input type="text" class="form-control" id="dueDate2" name="dueDate" value="${budgetItem.dueDate}">
                                        <input type="text" class="form-control" id="envelopeAmount2" name="envelopeAmount" value="${budgetItem.envelopeAmount}">
                                        <input type="submit" value="Update">
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>












</div>

<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#budgetedItemsTable2').DataTable();
    } );
</script>


<script type="text/javascript" class="init">
    var editor; // use a global for the submit and return data rendering in the examples

    $(document).ready(function() {
        editor = new $.fn.dataTable.Editor( {
            table: "#budgetedItemsTable"
        } );

        // Activate an inline edit on click of a table cell
        $('#budgetedItemsTable').on( 'click', 'tbody td:not(:first-child)', function (e) {
            editor.inline( this );
        } );

        $('#budgetedItemsTable').DataTable( {
            dom: "Bfrtip",

            order: [[ 1, 'asc' ]],

            select: {
                style:    'os',
                selector: 'td:first-child'
            },
            buttons: [
                { extend: "create", editor: editor },
                { extend: "edit",   editor: editor },
                { extend: "remove", editor: editor }
            ]
        } );
    } );



</script>



</body>
</html>



