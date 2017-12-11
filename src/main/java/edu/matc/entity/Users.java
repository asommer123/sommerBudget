package edu.matc.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Users. Contains all of the key information about a specific user.
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "account_id", nullable = false)
    private int accountId;

    @Basic
    @Column(name = "user_name", nullable = false, length = 15)
    private String userName;

    @Basic
    @Column(name = "user_pass", nullable = false, length = 15)
    private String userPass;

    @Basic
    @Column(name = "first_name", nullable = true, length = 25)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = true, length = 30)
    private String lastName;

    @Basic
    @Column(name = "email_address", nullable = true, length = 60)
    private String emailAddress;

    @OneToMany(mappedBy = "users")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<BudgetMonth> budgetMonths = new HashSet<BudgetMonth>(0);

    @OneToMany(mappedBy = "users")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    /**
     * Instantiates a new Users.
     */
    public Users() {
    }

    /**
     * Instantiates a new Users.
     *
     * @param userName     the user name
     * @param userPass     the user pass
     * @param firstName    the first name
     * @param lastName     the last name
     * @param emailAddress the email address
     */
    public Users(String userName, String userPass, String firstName, String lastName, String emailAddress) {
        this.userName = userName;
        this.userPass = userPass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    /**
     * Gets account id.
     *
     * @return the account id
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets account id.
     *
     * @param accountId the account id
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user pass.
     *
     * @return the user pass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * Sets user pass.
     *
     * @param userPass the user pass
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets budget months.
     *
     * @return the budget months
     */
    public Set<BudgetMonth> getBudgetMonths() {
        return budgetMonths;
    }

    /**
     * Sets budget months.
     *
     * @param budgetMonths the budget months
     */
    public void setBudgetMonths(Set<BudgetMonth> budgetMonths) {
        this.budgetMonths = budgetMonths;
    }

    /**
     * Gets user role.
     *
     * @return the user role
     */
    public Set<UserRole> getUserRole() {
        return userRoles;
    }

    /**
     * Sets user role.
     *
     * @param userRoles the user roles
     */
    public void setUserRole(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
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
}
