<div id="deleteUserModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Delete User</h4>
            </div>
            <div class="modal-body" style="padding: 10px;">
                <form class="form-horizontal" action="deleteUser" method="post"  id="add_form">
                    <div class="row">
                        <label class="col-md-2 control-label">Account Id</label>
                        <div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="m_accountId" name="m_accountId" class="form-control"  type="text" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">User Name</label>
                        <div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="m_userName" name="m_userName" class="form-control"  type="text" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">First Name</label>
                        <div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="m_firstName" name="m_firstName" class="form-control"  type="text" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">Last Name</label>
                        <div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="m_lastName" name="m_lastName" class="form-control"  type="text" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">Email Address</label>
                        <div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="m_emailAddress" name="m_emailAddress" class="form-control"  type="text" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-lg-offset-3 col-md-3 col-md-offset-3 col-sm-3 col-sm-offset-3" style="padding-bottom: 10px;">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success" >Delete</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>