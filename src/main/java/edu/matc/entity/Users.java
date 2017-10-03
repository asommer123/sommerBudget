package edu.matc.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    private int accountId;
    private String userName;
    private String userPass;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Collection<BudgetMonth> budgetMonthsByAccountId;
    private Collection<Category> categoriesByAccountId;
    private UserRole userRoleByUserName;

    @Id
    @Column(name = "account_id", nullable = false)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 15)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pass", nullable = false, length = 15)
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 25)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email_address", nullable = true, length = 60)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (accountId != users.accountId) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (userPass != null ? !userPass.equals(users.userPass) : users.userPass != null) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (emailAddress != null ? !emailAddress.equals(users.emailAddress) : users.emailAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByAccountId")
    public Collection<BudgetMonth> getBudgetMonthsByAccountId() {
        return budgetMonthsByAccountId;
    }

    public void setBudgetMonthsByAccountId(Collection<BudgetMonth> budgetMonthsByAccountId) {
        this.budgetMonthsByAccountId = budgetMonthsByAccountId;
    }

    @OneToMany(mappedBy = "usersByAccountId")
    public Collection<Category> getCategoriesByAccountId() {
        return categoriesByAccountId;
    }

    public void setCategoriesByAccountId(Collection<Category> categoriesByAccountId) {
        this.categoriesByAccountId = categoriesByAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", nullable = false)
    public UserRole getUserRoleByUserName() {
        return userRoleByUserName;
    }

    public void setUserRoleByUserName(UserRole userRoleByUserName) {
        this.userRoleByUserName = userRoleByUserName;
    }
}
