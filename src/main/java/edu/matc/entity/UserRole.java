package edu.matc.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_role", schema = "sommerBudget", catalog = "")
@IdClass(UserRolePK.class)
public class UserRole {
    private String userName;
    private String rollName;
    private Collection<Users> userRoleByUserName;

    @Id
    @Column(name = "user_name", nullable = false, length = 15)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "roll_name", nullable = false, length = 15)
    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userName != null ? !userName.equals(userRole.userName) : userRole.userName != null) return false;
        if (rollName != null ? !rollName.equals(userRole.rollName) : userRole.rollName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (rollName != null ? rollName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userRoleByUserName")
    public Collection<Users> getUserRoleByUserName() {
        return userRoleByUserName;
    }

    public void setUserRoleByUserName(Collection<Users> userRoleByUserName) {
        this.userRoleByUserName = userRoleByUserName;
    }
}
