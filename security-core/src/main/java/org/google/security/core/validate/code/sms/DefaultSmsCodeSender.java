package org.google.security.core.validate.code.sms;

import org.google.security.core.validate.code.sms.SmsCodeSender;

/**
 * Created by wbcaoa on 2018/4/9.
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机 : "+ mobile +" 发送短信验证码: " + code);
    }

}
