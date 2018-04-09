package org.google.security.core.validate.code.sms;

/**
 * Created by wbcaoa on 2018/4/9.
 * 发送短信验证码接口
 */
public interface SmsCodeSender {

    void send(String mobile, String code);

}
