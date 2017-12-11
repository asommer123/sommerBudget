package edu.matc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * The type Income. Contains all of the key information for an income for a budget month.
 */
@Entity
@Table(name = "income")
public class Income {
    @Id
    @Column(name = "income_id", nullable = false)
    private int incomeId;

    @Basic
    @Column(name = "pay_date", nullable = true)
    private Date payDate;

    @Basic
    @Column(name = "pay_amount", nullable = false, precision = 2)
    private BigDecimal payAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_month_id", referencedColumnName = "budget_month_id", nullable = false)
    private BudgetMonth budgetMonth;

    /**
     * Gets income id.
     *
     * @return the income id
     */
    public int getIncomeId() {
        return incomeId;
    }

    /**
     * Sets income id.
     *
     * @param incomeId the income id
     */
    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    /**
     * Gets pay date.
     *
     * @return the pay date
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * Sets pay date.
     *
     * @param payDate the pay date
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * Gets pay amount.
     *
     * @return the pay amount
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * Sets pay amount.
     *
     * @param payAmount the pay amount
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
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

    @Override
    public String toString() {
        return "Income{" +
                "incomeId=" + incomeId +
                ", payDate=" + payDate +
                ", payAmount=" + payAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Income income = (Income) o;

        if (incomeId != income.incomeId) return false;
        if (payDate != null ? !payDate.equals(income.payDate) : income.payDate != null) return false;
        if (payAmount != null ? !payAmount.equals(income.payAmount) : income.payAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = incomeId;
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        result = 31 * result + (payAmount != null ? payAmount.hashCode() : 0);
        return result;
    }
}
