package org.google.security.core.validate.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * Created by wbcaoa on 2018/4/9.
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 操作session工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现.
     */
    @Autowired private Map<String,ValidateCodeGenerator> validateCodeGenerators;

    /**
     * ServletWebRequest 【spring封装的工具类，封装请求与响应】
     * @param request
     * @throws Exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request,validateCode);
        send(request,validateCode);
    }

    /**
     * 生成验证码
     *
     * @param request
     * @return
     */
    private C generate(ServletWebRequest request){
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 保存验证码
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, C validateCode){
        sessionStrategy.setAttribute(request,SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(),validateCode);
    }

    /**
     * 根据请求的url获取验证码的类型
     * @param request
     * @return
     */
    private String getProcessorType(ServletWebRequest request){
        return StringUtils.substringAfter(request.getRequest().getRequestURI(),"/code/");
    }
    /**
     * 发送验证码，由子类实现
     * @param request
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request,C validateCode)throws Exception;


}
