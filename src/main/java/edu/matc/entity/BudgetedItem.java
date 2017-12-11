package edu.matc.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

/**
 * The type Budgeted item. Contains all of the key information of an item being budgeted.
 */
@Entity
@Table(name = "budgetedItem")
public class BudgetedItem {
    @Id
    @Column(name = "budgeted_id", nullable = false)
    private int budgetedId;

    @Basic
    @Column(name = "subCategory_name", nullable = false, length = 60)
    private String subCategoryName;

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

    /**
     * Instantiates a new Budgeted item.
     */
    public BudgetedItem() {
    }

    /**
     * Instantiates a new Budgeted item.
     *
     * @param subCategoryName the sub category name
     * @param budgetedAmount  the budgeted amount
     * @param dueDate         the due date
     * @param envelopeAmount  the envelope amount
     * @param note            the note
     * @param category        the category
     */
    public BudgetedItem(String subCategoryName, BigDecimal budgetedAmount, Date dueDate, BigDecimal envelopeAmount, String note, Category category) {
        this.subCategoryName = subCategoryName;
        this.budgetedAmount = budgetedAmount;
        this.dueDate = dueDate;
        this.envelopeAmount = envelopeAmount;
        this.note = note;
        this.category = category;
    }

    /**
     * Gets budgeted id.
     *
     * @return the budgeted id
     */
    public int getBudgetedId() {
        return budgetedId;
    }

    /**
     * Sets budgeted id.
     *
     * @param budgetedId the budgeted id
     */
    public void setBudgetedId(int budgetedId) {
        this.budgetedId = budgetedId;
    }

    /**
     * Gets sub category name.
     *
     * @return the sub category name
     */
    public String getSubCategoryName() {
        return subCategoryName;
    }

    /**
     * Sets sub category name.
     *
     * @param subCategory_name the sub category name
     */
    public void setSubCategoryName(String subCategory_name) {
        this.subCategoryName = subCategory_name;
    }

    /**
     * Gets budgeted amount.
     *
     * @return the budgeted amount
     */
    public BigDecimal getBudgetedAmount() {
        return budgetedAmount;
    }

    /**
     * Sets budgeted amount.
     *
     * @param budgetedAmount the budgeted amount
     */
    public void setBudgetedAmount(BigDecimal budgetedAmount) {
        this.budgetedAmount = budgetedAmount;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets envelope amount.
     *
     * @return the envelope amount
     */
    public BigDecimal getEnvelopeAmount() {
        return envelopeAmount;
    }

    /**
     * Sets envelope amount.
     *
     * @param envelopeAmount the envelope amount
     */
    public void setEnvelopeAmount(BigDecimal envelopeAmount) {
        this.envelopeAmount = envelopeAmount;
    }

    /**
     * Gets note.
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets note.
     *
     * @param note the note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets transactions.
     *
     * @return the transactions
     */
    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sets transactions.
     *
     * @param transactions the transactions
     */
    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "BudgetedItem{" +
                "budgetedId=" + budgetedId +
                ", subCategory_name='" + subCategoryName + '\'' +
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
