<div id="addBudgetedItemModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Budgeted Item</h4>
            </div>
            <div class="modal-body" style="padding: 10px;">
                <form class="form-horizontal" action="addBudgetedItem" method="post"  id="add_form">
                    <input type="HIDDEN" name="b_categoryId" id="b_categoryId">
                    <div class="row">
                        <label class="col-md-2 control-label">Sub Category Name</label>
                        <div class="col-lg-9 col-md-9 col-sm-9" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_subCategoryName" name="b_subCategoryName" class="form-control"  type="text" required>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">Note</label>
                        <div class="col-lg-9 col-md-9 col-sm-9" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <textarea style="resize:vertical;" class="form-control" rows="8" name="b_note" id="b_note"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">Budgeted Amount</label>
                        <div class="col-lg-3 col-md-3 col-sm-3" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_budgetedAmount" name="b_budgetedAmount" class="form-control"  type="number" required>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">Due Date</label>
                        <div class="col-lg-3 col-md-3 col-sm-3" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_dueDate" name="b_dueDate" class="form-control"  type="date">
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">Envelope Amount</label>
                        <div class="col-lg-3 col-md-3 col-sm-3" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_envelopeAmount" name="b_envelopeAmount" class="form-control"  type="number">
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