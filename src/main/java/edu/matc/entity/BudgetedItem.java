package edu.matc.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "budgetedItem")
public class BudgetedItem {
    @Id
    @Column(name = "budgeted_id", nullable = false)
    private int budgetedId;

    @Basic
    @Column(name = "subCategory_name", nullable = false, length = 60)
    private String subCategory_name;

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
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "budgetedItem")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<Transaction> transactions;

    public int getBudgetedId() {
        return budgetedId;
    }

    public void setBudgetedId(int budgetedId) {
        this.budgetedId = budgetedId;
    }

    public String getSubCategory_name() {
        return subCategory_name;
    }

    public void setSubCategory_name(String subCategory_name) {
        this.subCategory_name = subCategory_name;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "BudgetedItem{" +
                "budgetedId=" + budgetedId +
                ", subCategory_name='" + subCategory_name + '\'' +
                ", budgetedAmount=" + budgetedAmount +
                ", dueDate=" + dueDate +
                ", envelopeAmount=" + envelopeAmount +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetedItem that = (BudgetedItem) o;

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
