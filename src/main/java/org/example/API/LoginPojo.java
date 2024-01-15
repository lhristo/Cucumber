package org.example.API;

public class LoginPojo {
    String usernameOrEmail;
    String password;
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEMail) {
        this.usernameOrEmail = usernameOrEMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
