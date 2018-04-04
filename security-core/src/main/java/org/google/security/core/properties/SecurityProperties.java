package org.google.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wbcaoa on 2018/3/29.
 */
@ConfigurationProperties(prefix = "google.security")
public class SecurityProperties {

    private BrowserPropeties browser = new BrowserPropeties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserPropeties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserPropeties browser) {
        this.browser = browser;
    }
}
