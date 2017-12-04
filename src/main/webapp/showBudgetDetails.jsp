<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="${budget.budgetMonth} ${budget.budgetYear} Budget" />
<%@include file="head.jsp"%>



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



                    <c:forEach var="category" items="${budget.categories}">

                    <div class="container-fluid">
                        <h2>Budget Months: ${category}</h2>

                        <div class="row">

                            <table id="budgetedItemsTable" class="display" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>Sub Category Name</th>
                                    <th>Budgeted Id</th>
                                    <th>Budgeted Amount</th>
                                    <th>Due Date</th>
                                    <th>Envelope Amount</th>
                                    <th>Note</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="budgetedItem" items="${category.budgetedItems}">
                                    <tr>
                                        <td>${budgetedItem.subCategoryName}</td>
                                        <td>${budgetedItem.budgetedId}</td>
                                        <td>${budgetedItem.budgetedAmount}</td>
                                        <td>${budgetedItem.dueDate}</td>
                                        <td>${budgetedItem.envelopeAmount}</td>
                                        <td>${budgetedItem.note}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    </c:forEach>


                </div>
            </div>
        </div>
    </div>




    <c:forEach var="category" items="${budget.categories}">

    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" href="#${category.categoryId}">${category.categoryId} - ${category.categoryName}</a>
                </h4>
            </div>
            <div id="${category.categoryId}" class="panel-collapse collapse in">
                <div class="panel-body">Each budgetedSubCategories form attempt

                    <div class="container-fluid">
                        <c:forEach var="budgetItem" items="${category.budgetedItems}">

                            <form class="form-inline" action="updateBudgetedItem" method="POST">
                                <input type="hidden" id="budgetId" name="budgetId" value="${budget.budgetMonthId}">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="budgetedId" name="budgetedId" value="${budgetItem.budgetedId}">
                                    <input type="text" class="form-control" id="subCategory" name="subCategory" value="${budgetItem.subCategoryName}">
                                    <input type="text" class="form-control" id="budgetedAmount" name="budgetedAmount" value="${budgetItem.budgetedAmount}">
                                    <input type="date" class="form-control" id="dueDate" name="dueDate" value="${budgetItem.dueDate}">
                                    <input type="text" class="form-control" id="envelopeAmount" name="envelopeAmount" value="${budgetItem.envelopeAmount}">
                                    <a href="#" title="Note" data-toggle="popover" data-trigger="hover" data-content="${budgetItem.note}">Note</a>
                                    <input type="submit" value="Update">
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </c:forEach>















</div>

<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#budgetedItemsTable').DataTable();
    } );
</script>

<script type="text/javascript" class="init">
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });
</script>

</body>
</html>



