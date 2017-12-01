package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.Cascade;

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
    @Column(name = "budget_month", nullable = false)
    private String budgetMonth;

    @Basic
    @Column(name = "budget_year", nullable = false)
    private String budgetYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    private Users usersByAccountId;

    @OneToMany(mappedBy = "budgetMonthByBudgetMonthId")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<BudgetedSubCategory> budgetedSubCategoriesByBudgetMonthId;

    @OneToMany(mappedBy = "budgetMonthByBudgetMonthId")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<Income> incomesByBudgetMonthId;

    public BudgetMonth() {
    }

    public BudgetMonth(String budgetMonth, String budgetYear, Users usersByAccountId) {
        this.budgetMonth = budgetMonth;
        this.budgetYear = budgetYear;
        this.usersByAccountId = usersByAccountId;
    }

    public int getBudgetMonthId() {
        return budgetMonthId;
    }

    public void setBudgetMonthId(int budgetMonthId) {
        this.budgetMonthId = budgetMonthId;
    }

    public String getBudgetMonth() {
        return budgetMonth;
    }

    public void setBudgetMonth(String budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
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
                + "budget_month='" + budgetMonth + '\''
                + "budget_year='" + budgetYear + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetMonth that = (BudgetMonth) o;

        if (budgetMonthId != that.budgetMonthId) return false;
        if (budgetMonth.equals(that.budgetMonth)) return false;
        if (budgetYear.equals(that.budgetYear)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = budgetMonthId;
        result = 31 * result + (budgetMonth != null ? budgetMonth.hashCode() : 0);
        result = 31 * result + (budgetYear != null ? budgetYear.hashCode() : 0);
        return result;
    }
}
