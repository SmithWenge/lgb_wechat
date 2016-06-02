package com.lgb.wechat.function.login;

public class AdminUser {

    private String userName;
    private String userPass;
    private String uesrPassNew;
    private String userPassNewRe;

    public String getUserPassNewRe() {
        return userPassNewRe;
    }

    public void setUserPassNewRe(String userPassNewRe) {
        this.userPassNewRe = userPassNewRe;
    }

    public String getUesrPassNew() {
        return uesrPassNew;
    }

    public void setUesrPassNew(String uesrPassNew) {
        this.uesrPassNew = uesrPassNew;
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
