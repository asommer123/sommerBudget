package edu.matc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "transaction_id", nullable = false)
    private int transactionId;

    @Basic
    @Column(name = "transaction_amount", nullable = true, precision = 2)
    private BigDecimal transactionAmount;

    @Basic
    @Column(name = "transaction_date", nullable = true)
    private Date transactionDate;

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budgeted_id", referencedColumnName = "budgeted_id", nullable = false)
    private BudgetedItem budgetedItem;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BudgetedItem getBudgetedItem() {
        return budgetedItem;
    }

    public void setBudgetedItem(BudgetedItem budgetedItem) {
        this.budgetedItem = budgetedItem;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (transactionId != that.transactionId) return false;
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
        return result;
    }
}
