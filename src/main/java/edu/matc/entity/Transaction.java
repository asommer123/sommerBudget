package edu.matc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Transaction {
    private int transactionId;
    private BigDecimal transactionAmount;
    private Date transactionDate;
    private String note;
    private int budgetedId;
    private BudgetedSubCategory budgetedSubCategoryByBudgetedId;

    @Id
    @Column(name = "transaction_id", nullable = false)
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "transaction_amount", nullable = true, precision = 2)
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Basic
    @Column(name = "transaction_date", nullable = true)
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "budgeted_id", nullable = false)
    public int getBudgetedId() {
        return budgetedId;
    }

    public void setBudgetedId(int budgetedId) {
        this.budgetedId = budgetedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (transactionId != that.transactionId) return false;
        if (budgetedId != that.budgetedId) return false;
        if (transactionAmount != null ? !transactionAmount.equals(that.transactionAmount) : that.transactionAmount != null)
            return false;
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionId;
        result = 31 * result + (transactionAmount != null ? transactionAmount.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + budgetedId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "budgeted_id", referencedColumnName = "budgeted_id", nullable = false)
    public BudgetedSubCategory getBudgetedSubCategoryByBudgetedId() {
        return budgetedSubCategoryByBudgetedId;
    }

    public void setBudgetedSubCategoryByBudgetedId(BudgetedSubCategory budgetedSubCategoryByBudgetedId) {
        this.budgetedSubCategoryByBudgetedId = budgetedSubCategoryByBudgetedId;
    }
}
