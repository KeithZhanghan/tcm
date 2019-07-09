package jz.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private String userAccount;
    private Integer userAge;
    private String password;
    private Integer userRank;
    private String userName;
    private Integer isValid;
    private String userGender;

    @Id
    @Column(name = "user_account", nullable = false, length = 11)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_age", nullable = true)
    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_rank", nullable = true)
    public Integer getUserRank() {
        return userRank;
    }

    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "is_valid", nullable = true)
    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Basic
    @Column(name = "user_gender", nullable = true, length = 255)
    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userAccount != null ? !userAccount.equals(user.userAccount) : user.userAccount != null) return false;
        if (userAge != null ? !userAge.equals(user.userAge) : user.userAge != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userRank != null ? !userRank.equals(user.userRank) : user.userRank != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (isValid != null ? !isValid.equals(user.isValid) : user.isValid != null) return false;
        if (userGender != null ? !userGender.equals(user.userGender) : user.userGender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userAccount != null ? userAccount.hashCode() : 0;
        result = 31 * result + (userAge != null ? userAge.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userRank != null ? userRank.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        return result;
    }
}
