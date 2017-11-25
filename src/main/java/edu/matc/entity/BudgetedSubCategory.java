package edu.matc.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "budgetedSubCategory")
public class BudgetedSubCategory {
    @Id
    @Column(name = "budgeted_id", nullable = false)
    private int budgetedId;

    @Basic
    @Column(name = "budgeted_amount", nullable = true, precision = 2)
    private BigDecimal budgetedAmount;

    @Basic
    @Column(name = "due_date", nullable = true)
    private Date dueDate;

    @Basic
    @Column(name = "envelope_amount", nullable = true, precision = 2)
    private BigDecimal envelopeAmount;

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subCategory_id", referencedColumnName = "subCategory_id", nullable = false)
    private SubCategory subCategoryBySubCategoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_month_id", referencedColumnName = "budget_month_id", nullable = false)
    private BudgetMonth budgetMonthByBudgetMonthId;

    @OneToMany(mappedBy = "budgetedSubCategoryByBudgetedId")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<Transaction> transactionsByBudgetedId;

    public int getBudgetedId() {
        return budgetedId;
    }

    public void setBudgetedId(int budgetedId) {
        this.budgetedId = budgetedId;
    }

    public BigDecimal getBudgetedAmount() {
        return budgetedAmount;
    }

    public void setBudgetedAmount(BigDecimal budgetedAmount) {
        this.budgetedAmount = budgetedAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getEnvelopeAmount() {
        return envelopeAmount;
    }

    public void setEnvelopeAmount(BigDecimal envelopeAmount) {
        this.envelopeAmount = envelopeAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SubCategory getSubCategoryBySubCategoryId() {
        return subCategoryBySubCategoryId;
    }

    public void setSubCategoryBySubCategoryId(SubCategory subCategoryBySubCategoryId) {
        this.subCategoryBySubCategoryId = subCategoryBySubCategoryId;
    }

    public BudgetMonth getBudgetMonthByBudgetMonthId() {
        return budgetMonthByBudgetMonthId;
    }

    public void setBudgetMonthByBudgetMonthId(BudgetMonth budgetMonthByBudgetMonthId) {
        this.budgetMonthByBudgetMonthId = budgetMonthByBudgetMonthId;
    }

    public Collection<Transaction> getTransactionsByBudgetedId() {
        return transactionsByBudgetedId;
    }

    public void setTransactionsByBudgetedId(Collection<Transaction> transactionsByBudgetedId) {
        this.transactionsByBudgetedId = transactionsByBudgetedId;
    }

    @Override
    public String toString() {
        return "BudgetedSubCategory{" +
                "budgetedId=" + budgetedId +
                ", budgetedAmount=" + budgetedAmount +
                ", dueDate=" + dueDate +
                ", envelopeAmount=" + envelopeAmount +
                ", note='" + note + '\'' +
                ", subCategoryBySubCategoryId=" + subCategoryBySubCategoryId +
                ", budgetMonthByBudgetMonthId=" + budgetMonthByBudgetMonthId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetedSubCategory that = (BudgetedSubCategory) o;

        if (budgetedId != that.budgetedId) return false;
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
        return result;
    }
}
