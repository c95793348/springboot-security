package org.google.security.core.properties;

/**
 * Created by wbcaoa on 2018/5/4.
 */
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQPropeties qq = new QQPropeties();

    public QQPropeties getQq() {
        return qq;
    }

    public void setQq(QQPropeties qq) {
        this.qq = qq;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }
}
