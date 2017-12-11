package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * The type Budget month. Contains key information to identify a single monthly budget.
 */
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

    /**
     * Instantiates a new Budget month.
     */
    public BudgetMonth() {
    }

    /**
     * Instantiates a new Budget month.
     *
     * @param budgetMonth the budget month
     * @param budgetYear  the budget year
     * @param users       the users
     */
    public BudgetMonth(String budgetMonth, String budgetYear, Users users) {
        this.budgetMonth = budgetMonth;
        this.budgetYear = budgetYear;
        this.users = users;
    }

    /**
     * Gets budget month id.
     *
     * @return the budget month id
     */
    public int getBudgetMonthId() {
        return budgetMonthId;
    }

    /**
     * Sets budget month id.
     *
     * @param budgetMonthId the budget month id
     */
    public void setBudgetMonthId(int budgetMonthId) {
        this.budgetMonthId = budgetMonthId;
    }

    /**
     * Gets budget month.
     *
     * @return the budget month
     */
    public String getBudgetMonth() {
        return budgetMonth;
    }

    /**
     * Sets budget month.
     *
     * @param budgetMonth the budget month
     */
    public void setBudgetMonth(String budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    /**
     * Gets budget year.
     *
     * @return the budget year
     */
    public String getBudgetYear() {
        return budgetYear;
    }

    /**
     * Sets budget year.
     *
     * @param budgetYear the budget year
     */
    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param usersByAccountId the users by account id
     */
    public void setUsers(Users usersByAccountId) {
        this.users = usersByAccountId;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Collection<Category> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    /**
     * Gets incomes.
     *
     * @return the incomes
     */
    public Collection<Income> getIncomes() {
        return incomes;
    }

    /**
     * Sets incomes.
     *
     * @param incomes the incomes
     */
    public void setIncomes(Collection<Income> incomes) {
        this.incomes = incomes;
    }

    /**
     * Calculates the total for all items being budgeted.
     *
     * @return the total as big decimal
     */
    public BigDecimal calculateBudgetedTotal() {
        BigDecimal total = new BigDecimal(0);

        for (Category category : categories) {
            total = total.add(category.calculateTotal());
        }

        return total;
    }

    /**
     * Calculates the total for all income for budget month.
     *
     * @return the total as big decimal
     */
    public BigDecimal calculateIncomeTotal() {
        BigDecimal total = new BigDecimal(0);

        for (Income income : incomes) {
            total = total.add(income.getPayAmount());
        }

        return total;
    }

    /**
     * Calculate remaining amount to be budgeted (income - budgeted).
     *
     * @return the big decimal
     */
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
