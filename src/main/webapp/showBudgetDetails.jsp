<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="${budget.budgetMonth} ${budget.budgetYear} Budget" />
<%@include file="head.jsp"%>



<html>
<body>
<div id="wrap">
    <c:import url="navbar.jsp" />
</div>

<script type="text/javascript">
    $(document).on("submit", "#add_form", function(event) {
        var $form = $(this);
        var id = document.getElementById("b_budgetedId").value;
        $('#updateBudgetedItemModal').modal('hide');
        $('#deleteBudgetedItemModal').modal('hide');
        $('#addBudgetedItemModal').modal('hide');
        $.post($form.attr("action"), $form.serialize(), function(response) {
            var btnadd = $('#' + id);
            btnadd.removeClass("btn-success").addClass("btn-default");
            btnadd.find('span').toggleClass('glyphicon-edit').toggleClass('glyphicon-check');
            btnadd.attr('disabled','disabled');
        });
        $('#updateBudgetedItemModal').on('hidden.bs.modal', function () {
            location.reload();
        });
        $('#deleteBudgetedItemModal').on('hidden.bs.modal', function () {
            location.reload();
        });
        $('#addBudgetedItemModal').on('hidden.bs.modal', function () {
            location.reload();
        });
        event.preventDefault();
    });
</script>












<div class="container">
    <h2>Budget Details for ${budget.budgetMonth} ${budget.budgetYear} ... maybe put totals here?</h2>
    <p>Click on each Category to open and close it.</p>
    <br>
    <br>


    <c:forEach var="category" items="${budget.categories}">

        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#collapse${category.categoryId}"><p style="text-align:left;">${category.categoryId} - ${category.categoryName} <span style="float:right;color:red;"><b>Total:</b> ${currencyFormat.formatToCurrency(category.calculateTotal())}</span></p></a>
                    </h4>
                </div>
                <div id="collapse${category.categoryId}" class="panel-collapse collapse in">
                    <div class="panel-body">





                        <div class="container-fluid">
                            <h4>
                                <button type="button" id="addBudgetedItem" class="btnadd btn btn-xs btn-success"><span class="glyphicon glyphicon-plus"></span></button>   Add new item to budget to category
                            </h4>
                            <br>

                            <div class="row">

                                <table id="table${category.categoryId}" class="display" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>Sub Category Name</th>
                                        <th style="display: none">Budgeted Id</th>
                                        <th>Budgeted Amount</th>
                                        <th>Due Date</th>
                                        <th>Envelope Amount</th>
                                        <th>Note</th>
                                        <th style="display: none">Note2</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="budgetedItem" items="${category.budgetedItems}">
                                        <tr>
                                            <td>${budgetedItem.subCategoryName}</td>
                                            <td style="display: none">${budgetedItem.budgetedId}</td>
                                            <td>${currencyFormat.formatToCurrency(budgetedItem.budgetedAmount)}</td>
                                            <td>${budgetedItem.dueDate}</td>
                                            <c:choose>
                                                <c:when test="${budgetedItem.envelopeAmount != null}">
                                                    <td>${currencyFormat.formatToCurrency(budgetedItem.envelopeAmount)}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${budgetedItem.envelopeAmount}</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${not empty budgetedItem.note}">
                                                    <td><a href="#" title="Note" data-toggle="popover" data-trigger="hover" data-content="${budgetedItem.note}">Note</a></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td></td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td style="display: none">${budgetedItem.note}</td>
                                            <td>
                                                <button type="button" id="${budgetedItem.budgetedId}" class="btnupd btn btn-xs btn-success"><span class="glyphicon glyphicon-edit"></span></button>
                                                <button type="button" id="delete${budgetedItem.budgetedId}" class="btndel btn btn-xs btn-success"><span class="glyphicon glyphicon-minus"></span></button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <script type="text/javascript" class="init">
                            $(document).ready(function() {

                                $('#table${category.categoryId}').dataTable( {
                                    "aoColumnDefs": [
                                        { "bSortable": false, "aTargets": [ 1, 5, 6, 7 ] }
                                    ],

                                    "columns": [
                                        { "width": "20%" },
                                        { "width": "0%" },
                                        { "width": "15%" },
                                        { "width": "15%" },
                                        { "width": "15%" },
                                        { "width": "15%" },
                                        { "width": "0%" },
                                        { "width": "10%" },
                                    ],
                                    "aaSorting": [],
                                    "bPaginate": true,
                                    "searching": true
                                } );

                                $('#table${category.categoryId} tbody').on('click', '.btnupd', function () {
                                    var subCategoryName = $(this).closest("tr").find("td:eq(0)").text();
                                    var budgetedId = $(this).closest("tr").find("td:eq(1)").text();
                                    var budgetedAmount = $(this).closest("tr").find("td:eq(2)").text();
                                    var dueDate = $(this).closest("tr").find("td:eq(3)").text();
                                    var envelopeAmount = $(this).closest("tr").find("td:eq(4)").text();
                                    var note = $(this).closest("tr").find("td:eq(6)").text();
                                    var mymodal = $('#updateBudgetedItemModal');

                                    mymodal.find('.modal-title').text("Update Budgeted Item");
                                    mymodal.find('#b_subCategoryName').val(subCategoryName);
                                    mymodal.find('#b_budgetedId').val(budgetedId);
                                    mymodal.find('#b_budgetedAmount').val(budgetedAmount);
                                    mymodal.find('#b_dueDate').val(dueDate);
                                    mymodal.find('#b_envelopeAmount').val(envelopeAmount);
                                    mymodal.find('#b_note').val(note);

                                    $('#updateBudgetedItemModal').modal('show');
                                });

                                $('#table${category.categoryId} tbody').on('click', '.btndel', function () {
                                    var subCategoryName = $(this).closest("tr").find("td:eq(0)").text();
                                    var budgetedId = $(this).closest("tr").find("td:eq(1)").text();
                                    var budgetedAmount = $(this).closest("tr").find("td:eq(2)").text();
                                    var dueDate = $(this).closest("tr").find("td:eq(3)").text();
                                    var envelopeAmount = $(this).closest("tr").find("td:eq(4)").text();
                                    var note = $(this).closest("tr").find("td:eq(6)").text();
                                    var mymodal = $('#deleteBudgetedItemModal');

                                    mymodal.find('.modal-title').text("Confirm Delete of Budgeted Item");
                                    mymodal.find('#b_subCategoryName').val(subCategoryName);
                                    mymodal.find('#b_budgetedId').val(budgetedId);
                                    mymodal.find('#b_budgetedAmount').val(budgetedAmount);
                                    mymodal.find('#b_dueDate').val(dueDate);
                                    mymodal.find('#b_envelopeAmount').val(envelopeAmount);
                                    mymodal.find('#b_note').val(note);

                                    $('#deleteBudgetedItemModal').modal('show');
                                });

                                $('#table${category.categoryId} tbody').on('click', '.btnadd', function () {
                                    var categoryId = ${category.categoryId};
                                    var mymodal = $('#addBudgetedItemModal');

                                    mymodal.find('.modal-title').text("Add new Budgeted Item");
                                    mymodal.find('#b_categoryId').val(budgetedId);

                                    $('#addBudgetedItemModal').modal('show');
                                });

                            } );
                        </script>




                    </div>
                </div>
            </div>
            <c:import url="updateBudgetedItemModal.jsp" />
            <c:import url="deleteBudgetedItemModal.jsp" />
            <c:import url="addBudgetedItemModal.jsp" />
        </div>

    </c:forEach>


</div>

<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#table${category.categoryId}').DataTable();
    } );
</script>

<script type="text/javascript" class="init">
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });
</script>

</body>
</html>



