package edu.matc.entity;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * The type Category. Contains all the key information for a group of like budgeted items for a budget month.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Basic
    @Column(name = "category_name", nullable = false, length = 60)
    private String categoryName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_month_id", referencedColumnName = "budget_month_id", nullable = false)
    private BudgetMonth budgetMonth;

    @OneToMany(mappedBy = "category")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<BudgetedItem> budgetedItems;

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Category.
     *
     * @param categoryName the category name
     * @param budgetMonth  the budget month
     */
    public Category(String categoryName, BudgetMonth budgetMonth) {
        this.categoryName = categoryName;
        this.budgetMonth = budgetMonth;
    }

    /**
     * Gets category id.
     *
     * @return the category id
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets category id.
     *
     * @param categoryId the category id
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets category name.
     *
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets category name.
     *
     * @param categoryName the category name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets budget month.
     *
     * @return the budget month
     */
    public BudgetMonth getBudgetMonth() {
        return budgetMonth;
    }

    /**
     * Sets budget month.
     *
     * @param budgetMonth the budget month
     */
    public void setBudgetMonth(BudgetMonth budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    /**
     * Gets budgeted items.
     *
     * @return the budgeted items
     */
    public Collection<BudgetedItem> getBudgetedItems() {
        return budgetedItems;
    }

    /**
     * Sets budgeted items.
     *
     * @param budgetedItems the budgeted items
     */
    public void setBudgetedItems(Collection<BudgetedItem> budgetedItems) {
        this.budgetedItems = budgetedItems;
    }

    /**
     * Calculates the total budgeted items in category as big decimal.
     *
     * @return the total as big decimal
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal(0);

        for (BudgetedItem budgetedItem : budgetedItems) {
            total = total.add(budgetedItem.getBudgetedAmount());
        }

        return total;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}
