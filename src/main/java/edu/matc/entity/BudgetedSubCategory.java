package edu.matc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "budgetedSubCategory")
public class BudgetedSubCategory {
    private int budgetedId;
    private BigDecimal budgetedAmount;
    private Date dueDate;
    private BigDecimal envelopeAmount;
    private String note;
    private int subCategoryId;
    private int budgetMonthId;
    private SubCategory subCategoryBySubCategoryId;
    private BudgetMonth budgetMonthByBudgetMonthId;
    private Collection<Transaction> transactionsByBudgetedId;

    @Id
    @Column(name = "budgeted_id", nullable = false)
    public int getBudgetedId() {
        return budgetedId;
    }

    public void setBudgetedId(int budgetedId) {
        this.budgetedId = budgetedId;
    }

    @Basic
    @Column(name = "budgeted_amount", nullable = true, precision = 2)
    public BigDecimal getBudgetedAmount() {
        return budgetedAmount;
    }

    public void setBudgetedAmount(BigDecimal budgetedAmount) {
        this.budgetedAmount = budgetedAmount;
    }

    @Basic
    @Column(name = "due_date", nullable = true)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "envelope_amount", nullable = true, precision = 2)
    public BigDecimal getEnvelopeAmount() {
        return envelopeAmount;
    }

    public void setEnvelopeAmount(BigDecimal envelopeAmount) {
        this.envelopeAmount = envelopeAmount;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /*@Basic
    @Column(name = "subCategory_id", nullable = false)
    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }*/

    /*@Basic
    @Column(name = "budget_month_id", nullable = false)
    public int getBudgetMonthId() {
        return budgetMonthId;
    }

    public void setBudgetMonthId(int budgetMonthId) {
        this.budgetMonthId = budgetMonthId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetedSubCategory that = (BudgetedSubCategory) o;

        if (budgetedId != that.budgetedId) return false;
        if (subCategoryId != that.subCategoryId) return false;
        if (budgetMonthId != that.budgetMonthId) return false;
        if (budgetedAmount != null ? !budgetedAmount.equals(that.budgetedAmount) : that.budgetedAmount != null)
            return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (envelopeAmount != null ? !envelopeAmount.equals(that.envelopeAmount) : that.envelopeAmount != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = budgetedId;
        result = 31 * result + (budgetedAmount != null ? budgetedAmount.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (envelopeAmount != null ? envelopeAmount.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + subCategoryId;
        result = 31 * result + budgetMonthId;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id", referencedColumnName = "subCategory_id", nullable = false)
    public SubCategory getSubCategoryBySubCategoryId() {
        return subCategoryBySubCategoryId;
    }

    public void setSubCategoryBySubCategoryId(SubCategory subCategoryBySubCategoryId) {
        this.subCategoryBySubCategoryId = subCategoryBySubCategoryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_month_id", referencedColumnName = "budget_month_id", nullable = false)
    public BudgetMonth getBudgetMonthByBudgetMonthId() {
        return budgetMonthByBudgetMonthId;
    }

    public void setBudgetMonthByBudgetMonthId(BudgetMonth budgetMonthByBudgetMonthId) {
        this.budgetMonthByBudgetMonthId = budgetMonthByBudgetMonthId;
    }

    @OneToMany(mappedBy = "budgetedSubCategoryByBudgetedId")
    public Collection<Transaction> getTransactionsByBudgetedId() {
        return transactionsByBudgetedId;
    }

    public void setTransactionsByBudgetedId(Collection<Transaction> transactionsByBudgetedId) {
        this.transactionsByBudgetedId = transactionsByBudgetedId;
    }
}
