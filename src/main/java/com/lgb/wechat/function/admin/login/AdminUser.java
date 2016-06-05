package com.lgb.wechat.function.admin.login;

public class AdminUser {

    private String userName;
    private String userPass;
    private String userPassNew;
    private String userPassNewRe;

    public String getUserPassNew() {
        return userPassNew;
    }

    public void setUserPassNew(String userPassNew) {
        this.userPassNew = userPassNew;
    }

    public String getUserPassNewRe() {
        return userPassNewRe;
    }

    public void setUserPassNewRe(String userPassNewRe) {
        this.userPassNewRe = userPassNewRe;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
