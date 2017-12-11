package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type User role. Contains the key information to tie a user to a role.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_role_id", nullable = false)
    private int userRoleId;

    @Basic
    @Column(name = "role_name", nullable = false, length = 15)
    private String roleName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", nullable = false)
    private Users users;

    /**
     * Instantiates a new User role.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new User role.
     *
     * @param roleName the role name
     * @param users    the users
     */
    public UserRole(String roleName, Users users) {
        this.roleName = roleName;
        this.users = users;
    }

    /**
     * Gets user role id.
     *
     * @return the user role id
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets user role id.
     *
     * @param userRoleId the user role id
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
     * @param users the users
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", rollName='" + roleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userRoleId != userRole.userRoleId) return false;
        if (roleName != null ? !roleName.equals(userRole.roleName) : userRole.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
