package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "budgetMonth")
public class BudgetMonth {
    @Id
    @Column(name = "budget_month_id", nullable = false)
    @Convert(converter = LocalDateAttributeConverter.class)
    private int budgetMonthId;

    @Basic
    @Column(name = "budget_date", nullable = false)
    private Date budgetDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    private Users usersByAccountId;

    @OneToMany(mappedBy = "budgetMonthByBudgetMonthId")
    private Collection<BudgetedSubCategory> budgetedSubCategoriesByBudgetMonthId;

    @OneToMany(mappedBy = "budgetMonthByBudgetMonthId")
    private Collection<Income> incomesByBudgetMonthId;

    public BudgetMonth() {
    }

    public BudgetMonth(Date budgetDate, Users usersByAccountId) {
        this.budgetDate = budgetDate;
        this.usersByAccountId = usersByAccountId;
    }

    public int getBudgetMonthId() {
        return budgetMonthId;
    }

    public void setBudgetMonthId(int budgetMonthId) {
        this.budgetMonthId = budgetMonthId;
    }

    public Date getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(Date budgetDate) {
        this.budgetDate = budgetDate;
    }

    public Users getUsersByAccountId() {
        return usersByAccountId;
    }

    public void setUsersByAccountId(Users usersByAccountId) {
        this.usersByAccountId = usersByAccountId;
    }

    public Collection<BudgetedSubCategory> getBudgetedSubCategoriesByBudgetMonthId() {
        return budgetedSubCategoriesByBudgetMonthId;
    }

    public void setBudgetedSubCategoriesByBudgetMonthId(Collection<BudgetedSubCategory> budgetedSubCategoriesByBudgetMonthId) {
        this.budgetedSubCategoriesByBudgetMonthId = budgetedSubCategoriesByBudgetMonthId;
    }

    public Collection<Income> getIncomesByBudgetMonthId() {
        return incomesByBudgetMonthId;
    }

    public void setIncomesByBudgetMonthId(Collection<Income> incomesByBudgetMonthId) {
        this.incomesByBudgetMonthId = incomesByBudgetMonthId;
    }

    @Override
    public String toString() {
        return "BudgetMonth{"
                + "budget_month_id='" + budgetMonthId + '\''
                + "budget_date='" + budgetDate + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetMonth that = (BudgetMonth) o;

        if (budgetMonthId != that.budgetMonthId) return false;
        if (budgetDate != null ? !budgetDate.equals(that.budgetDate) : that.budgetDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = budgetMonthId;
        result = 31 * result + (budgetDate != null ? budgetDate.hashCode() : 0);
        return result;
    }
}
