package edu.matc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

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

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BudgetMonth getBudgetMonth() {
        return budgetMonth;
    }

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
