<div id="addBudgetedItemModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Budgeted Item</h4>
            </div>
            <div class="modal-body" style="padding: 10px;">
                <form class="form-horizontal" action="updateBudgetedItem" method="post"  id="add_form">
                    <input type="HIDDEN" name="poster_path" id="poster_path">
                    <div class="row">
                        <label class="col-md-2 control-label">b_subCategoryName</label>
                        <div class="col-lg-2 col-md-2 col-sm-2" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_subCategoryName" name="b_subCategoryName" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">b_budgetedId</label>
                        <div class="col-lg-9 col-md-9 col-sm-9" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_budgetedId" name="b_budgetedId" class="form-control"  type="text" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">b_note</label>
                        <div class="col-lg-9 col-md-9 col-sm-9" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <textarea style="resize:vertical;" class="form-control" rows="8" name="b_note" id="b_note"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">b_budgetedAmount</label>
                        <div class="col-lg-2 col-md-2 col-sm-2" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_budgetedAmount" name="b_budgetedAmount" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">b_dueDate</label>
                        <div class="col-lg-2 col-md-2 col-sm-2" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_dueDate" name="b_dueDate" class="form-control"  type="date">
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-2 control-label">b_envelopeAmount</label>
                        <div class="col-lg-2 col-md-2 col-sm-2" style="padding-bottom: 10px;" style="padding-top: 10px;">
                            <input id="b_envelopeAmount" name="b_envelopeAmount" class="form-control"  type="number">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2" style="padding-bottom: 10px;">
                            <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            <button type="submit" class="btn btn-success" >Yes </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>