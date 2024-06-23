package com.example.sms.model;

public class Login {
    private int login_no;
    private String reg_no;
    private String password;

    public Login(){}
    public Login(int login_no, String reg_no, String password) {
        this.login_no = login_no;
        this.reg_no = reg_no;
        this.password = password;
    }

    public int getLogin_no() {
        return login_no;
    }

    public void setLogin_no(int login_no) {
        this.login_no = login_no;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
