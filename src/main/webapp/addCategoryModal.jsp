<div id="addCategoryModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Category</h4>
            </div>
            <div class="modal-body" style="padding: 10px;">
                <form class="form-horizontal" action="addCategory" method="post"  id="add_form">
                    <input type="HIDDEN" name="b_budgetId" id="b_budgetId">
                    <div class="row">
                        <label class="col-md-2 control-label">Category Name</label>
                        <div class="col-lg-9 col-md-9 col-sm-9" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_categoryName" name="b_categoryName" class="form-control"  type="text" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-lg-offset-3 col-md-3 col-md-offset-3 col-sm-3 col-sm-offset-3" style="padding-bottom: 10px;">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success" >Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>