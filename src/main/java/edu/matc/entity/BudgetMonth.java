package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private Users users;

    @OneToMany(mappedBy = "budgetMonth")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<Category> categories;

    @OneToMany(mappedBy = "budgetMonth")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Collection<Income> incomes;

    public BudgetMonth() {
    }

    public BudgetMonth(String budgetMonth, String budgetYear, Users users) {
        this.budgetMonth = budgetMonth;
        this.budgetYear = budgetYear;
        this.users = users;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users usersByAccountId) {
        this.users = usersByAccountId;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(Collection<Income> incomes) {
        this.incomes = incomes;
    }

    public BigDecimal calculateBudgetedTotal() {
        BigDecimal total = new BigDecimal(0);

        for (Category category : categories) {
            total = total.add(category.calculateTotal());
        }

        return total;
    }

    public BigDecimal calculateIncomeTotal() {
        BigDecimal total = new BigDecimal(0);

        for (Income income : incomes) {
            total = total.add(income.getPayAmount());
        }

        return total;
    }

    public BigDecimal calculateRemaining() {
        return calculateIncomeTotal().subtract(calculateBudgetedTotal());
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
