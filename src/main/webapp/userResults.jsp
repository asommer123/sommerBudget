<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Admin View/Delete Users" />
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
        $('#deleteUserModal').modal('hide');
        $.post($form.attr("action"), $form.serialize(), function(response) {
            var btnadd = $('#' + id);
            btnadd.removeClass("btn-success").addClass("btn-default");
            btnadd.find('span').toggleClass('glyphicon-edit').toggleClass('glyphicon-check');
            btnadd.attr('disabled','disabled');
        });
        $('#deleteUserModal').on('hidden.bs.modal', function () {
            location.reload();
        });
        event.preventDefault();
    });
</script>

<div class="container-fluid">
    <h2>${message}</h2>



    <div class="row">

        <h4>Click on the trash can to delete a user.</h4>

        <table id="usersTable" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Account ID</th>
                <th>User Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.accountId}</td>
                    <td>${user.userName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.emailAddress}</td>
                    <td>
                        <button type="button" id="delete${user.accountId}" class="btndel btn btn-xs btn-success"><span class="glyphicon glyphicon-trash"></span></button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <script type="text/javascript" class="init">
        $(document).ready(function() {

            $('#usersTable').dataTable( {
                "aoColumnDefs": [
                    { "bSortable": false, "aTargets": [ 5 ] }
                ],

                "columns": [
                    { "width": "15%" },
                    { "width": "20%" },
                    { "width": "20%" },
                    { "width": "20%" },
                    { "width": "20%" },
                    { "width": "5%" },
                ],
                "aaSorting": [],
                "bPaginate": true,
                "searching": true
            } );

            $('#usersTable tbody').on('click', '.btndel', function () {
                var accountId = $(this).closest("tr").find("td:eq(0)").text();
                var userName = $(this).closest("tr").find("td:eq(1)").text();
                var firstName = $(this).closest("tr").find("td:eq(2)").text();
                var lastName = $(this).closest("tr").find("td:eq(3)").text();
                var emailAddress = $(this).closest("tr").find("td:eq(4)").text();
                var mymodal = $('#deleteUserModal');

                mymodal.find('.modal-title').text("Confirm Delete of Budgeted Item");
                mymodal.find('#m_accountId').val(accountId);
                mymodal.find('#m_userName').val(userName);
                mymodal.find('#m_firstName').val(firstName);
                mymodal.find('#m_lastName').val(lastName);
                mymodal.find('#m_emailAddress').val(emailAddress);

                $('#deleteUserModal').modal('show');
            });

        } );
    </script>


    <c:import url="deleteUserModal.jsp" />



</div>

<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#usersTable').DataTable();
    } );
</script>

</body>
</html>
