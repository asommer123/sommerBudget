package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserRolePK implements Serializable {
    private String userName;
    private String rollName;

    @Column(name = "user_name", nullable = false, length = 15)
    @Id
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "roll_name", nullable = false, length = 15)
    @Id
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

        UserRolePK that = (UserRolePK) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (rollName != null ? !rollName.equals(that.rollName) : that.rollName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (rollName != null ? rollName.hashCode() : 0);
        return result;
    }
}
