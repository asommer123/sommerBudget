package edu.matc.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subCategory")
public class SubCategory {
    private int subCategoryId;
    private String subCategoryName;
    private Byte defaultFl;
    private Integer dayOfMonthDue;
    private int categoryId;
    private Collection<BudgetedSubCategory> budgetedSubCategoriesBySubCategoryId;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "subCategory_id", nullable = false)
    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Basic
    @Column(name = "subCategory_name", nullable = false, length = 60)
    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @Basic
    @Column(name = "default_fl", nullable = true)
    public Byte getDefaultFl() {
        return defaultFl;
    }

    public void setDefaultFl(Byte defaultFl) {
        this.defaultFl = defaultFl;
    }

    @Basic
    @Column(name = "day_of_month_due", nullable = true)
    public Integer getDayOfMonthDue() {
        return dayOfMonthDue;
    }

    public void setDayOfMonthDue(Integer dayOfMonthDue) {
        this.dayOfMonthDue = dayOfMonthDue;
    }

    /*@Basic
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubCategory that = (SubCategory) o;

        if (subCategoryId != that.subCategoryId) return false;
        if (categoryId != that.categoryId) return false;
        if (subCategoryName != null ? !subCategoryName.equals(that.subCategoryName) : that.subCategoryName != null)
            return false;
        if (defaultFl != null ? !defaultFl.equals(that.defaultFl) : that.defaultFl != null) return false;
        if (dayOfMonthDue != null ? !dayOfMonthDue.equals(that.dayOfMonthDue) : that.dayOfMonthDue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subCategoryId;
        result = 31 * result + (subCategoryName != null ? subCategoryName.hashCode() : 0);
        result = 31 * result + (defaultFl != null ? defaultFl.hashCode() : 0);
        result = 31 * result + (dayOfMonthDue != null ? dayOfMonthDue.hashCode() : 0);
        result = 31 * result + categoryId;
        return result;
    }

    @OneToMany(mappedBy = "subCategoryBySubCategoryId")
    public Collection<BudgetedSubCategory> getBudgetedSubCategoriesBySubCategoryId() {
        return budgetedSubCategoriesBySubCategoryId;
    }

    public void setBudgetedSubCategoriesBySubCategoryId(Collection<BudgetedSubCategory> budgetedSubCategoriesBySubCategoryId) {
        this.budgetedSubCategoriesBySubCategoryId = budgetedSubCategoriesBySubCategoryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
