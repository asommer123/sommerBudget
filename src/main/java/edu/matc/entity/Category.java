package edu.matc.entity;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

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

    public Category() {
    }

    public Category(String categoryName, BudgetMonth budgetMonth) {
        this.categoryName = categoryName;
        this.budgetMonth = budgetMonth;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BudgetMonth getBudgetMonth() {
        return budgetMonth;
    }

    public void setBudgetMonth(BudgetMonth budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    public Collection<BudgetedItem> getBudgetedItems() {
        return budgetedItems;
    }

    public void setBudgetedItems(Collection<BudgetedItem> budgetedItems) {
        this.budgetedItems = budgetedItems;
    }

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
