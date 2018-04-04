package org.google.security.core.properties;


/**
 * Created by wbcaoa on 2018/3/29.
 */
public class BrowserPropeties {

    private String loginPage = "/google_sigin_in.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
