package org.google.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Created by wbcaoa on 2018/5/4.
 */
public class QQPropeties extends SocialProperties{

    private String providerId = "qq";//服务提供商标识 默认qq

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
