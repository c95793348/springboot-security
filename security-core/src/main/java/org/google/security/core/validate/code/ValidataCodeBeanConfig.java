package org.google.security.core.validate.code;

import org.google.security.core.properties.SecurityProperties;
import org.google.security.core.validate.code.sms.DefaultSmsCodeSender;
import org.google.security.core.validate.code.image.ImageCodeGenerator;
import org.google.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wbcaoa on 2018/4/3.
 * 配置类
 */
@Configuration
public class ValidataCodeBeanConfig {

    @Autowired private SecurityProperties securityProperties;

    /**
     * 声明一个springbean
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender(){

        return new DefaultSmsCodeSender();
    }

}
