package org.google.security.core.properties;

/**
 * Created by wbcaoa on 2018/3/30.
 * 验证码配置
 */
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
