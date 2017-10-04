package edu.matc.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "budgetMonth")
public class BudgetMonth {
    private int budgetMonthId;
    private Date budgetDate;
    private int accountId;
    private Users usersByAccountId;
    private Collection<BudgetedSubCategory> budgetedSubCategoriesByBudgetMonthId;
    private Collection<Income> incomesByBudgetMonthId;

    @Id
    @Column(name = "budget_month_id", nullable = false)
    public int getBudgetMonthId() {
        return budgetMonthId;
    }

    public void setBudgetMonthId(int budgetMonthId) {
        this.budgetMonthId = budgetMonthId;
    }

    @Basic
    @Column(name = "budget_date", nullable = false)
    public Date getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(Date budgetDate) {
        this.budgetDate = budgetDate;
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

        BudgetMonth that = (BudgetMonth) o;

        if (budgetMonthId != that.budgetMonthId) return false;
        if (accountId != that.accountId) return false;
        if (budgetDate != null ? !budgetDate.equals(that.budgetDate) : that.budgetDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = budgetMonthId;
        result = 31 * result + (budgetDate != null ? budgetDate.hashCode() : 0);
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

    @OneToMany(mappedBy = "budgetMonthByBudgetMonthId")
    public Collection<BudgetedSubCategory> getBudgetedSubCategoriesByBudgetMonthId() {
        return budgetedSubCategoriesByBudgetMonthId;
    }

    public void setBudgetedSubCategoriesByBudgetMonthId(Collection<BudgetedSubCategory> budgetedSubCategoriesByBudgetMonthId) {
        this.budgetedSubCategoriesByBudgetMonthId = budgetedSubCategoriesByBudgetMonthId;
    }

    @OneToMany(mappedBy = "budgetMonthByBudgetMonthId")
    public Collection<Income> getIncomesByBudgetMonthId() {
        return incomesByBudgetMonthId;
    }

    public void setIncomesByBudgetMonthId(Collection<Income> incomesByBudgetMonthId) {
        this.incomesByBudgetMonthId = incomesByBudgetMonthId;
    }
}
