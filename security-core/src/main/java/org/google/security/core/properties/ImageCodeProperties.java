package org.google.security.core.properties;

/**
 * Created by wbcaoa on 2018/3/30.
 * 图形验证码 默认配置
 */
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);//默认4位图形验证码
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
