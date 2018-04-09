package org.google.security.core.validate.code.sms;

import org.google.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.google.security.core.validate.code.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by wbcaoa on 2018/4/9.
 */
@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired private SmsCodeSender smsCodeSender;

    /**
     * 短信验证码发送器
     * @param request
     * @param validateCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "moblie");
        smsCodeSender.send(mobile,validateCode.getCode());
    }
}
