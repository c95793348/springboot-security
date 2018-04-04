package org.google.security.browser.support;

/**
 * Created by wbcaoa on 2018/3/29.
 */
public class SimpleRespone {

    public SimpleRespone(String content) {
        this.content = content;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
