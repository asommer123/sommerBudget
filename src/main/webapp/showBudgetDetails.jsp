<%@include file="head.jsp"%>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/select/1.2.3/js/dataTables.select.min.js"></script>
<script src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<div class="container-fluid">
    <h2>Budget Month: </h2>
    <h1>${budget}</h1>
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



