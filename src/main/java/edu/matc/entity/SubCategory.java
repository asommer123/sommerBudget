package edu.matc.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subCategory")
public class SubCategory {
    @Id
    @Column(name = "subCategory_id", nullable = false)
    private int subCategoryId;

    @Basic
    @Column(name = "subCategory_name", nullable = false, length = 60)
    private String subCategoryName;

    @Basic
    @Column(name = "default_fl", nullable = true)
    private Byte defaultFl;

    @Basic
    @Column(name = "day_of_month_due", nullable = true)
    private Integer dayOfMonthDue;

    @OneToMany(mappedBy = "subCategoryBySubCategoryId")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<BudgetedSubCategory> budgetedSubCategoriesBySubCategoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category categoryByCategoryId;

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public Byte getDefaultFl() {
        return defaultFl;
    }

    public void setDefaultFl(Byte defaultFl) {
        this.defaultFl = defaultFl;
    }

    public Integer getDayOfMonthDue() {
        return dayOfMonthDue;
    }

    public void setDayOfMonthDue(Integer dayOfMonthDue) {
        this.dayOfMonthDue = dayOfMonthDue;
    }

    public Collection<BudgetedSubCategory> getBudgetedSubCategoriesBySubCategoryId() {
        return budgetedSubCategoriesBySubCategoryId;
    }

    public void setBudgetedSubCategoriesBySubCategoryId(Collection<BudgetedSubCategory> budgetedSubCategoriesBySubCategoryId) {
        this.budgetedSubCategoriesBySubCategoryId = budgetedSubCategoriesBySubCategoryId;
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "subCategoryId=" + subCategoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", defaultFl=" + defaultFl +
                ", dayOfMonthDue=" + dayOfMonthDue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubCategory that = (SubCategory) o;

        if (subCategoryId != that.subCategoryId) return false;
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
        return result;
    }
}
