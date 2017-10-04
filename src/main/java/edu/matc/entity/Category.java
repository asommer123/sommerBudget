package edu.matc.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
public class Category {
    private int categoryId;
    private String categoryName;
    private Byte defaultFl;
    private int accountId;
    private Users usersByAccountId;
    private Collection<SubCategory> subCategoriesByCategoryId;

    @Id
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category_name", nullable = false, length = 60)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "default_fl", nullable = true)
    public Byte getDefaultFl() {
        return defaultFl;
    }

    public void setDefaultFl(Byte defaultFl) {
        this.defaultFl = defaultFl;
    }

    /*@Basic
    @Column(name = "account_id", nullable = false)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;
        if (accountId != category.accountId) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        if (defaultFl != null ? !defaultFl.equals(category.defaultFl) : category.defaultFl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (defaultFl != null ? defaultFl.hashCode() : 0);
        result = 31 * result + accountId;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    public Users getUsersByAccountId() {
        return usersByAccountId;
    }

    public void setUsersByAccountId(Users usersByAccountId) {
        this.usersByAccountId = usersByAccountId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<SubCategory> getSubCategoriesByCategoryId() {
        return subCategoriesByCategoryId;
    }

    public void setSubCategoriesByCategoryId(Collection<SubCategory> subCategoriesByCategoryId) {
        this.subCategoriesByCategoryId = subCategoriesByCategoryId;
    }
}
