package org.google.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.google.security.core.properties.LoginType;
import org.google.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wbcaoa on 2018/3/29.
 * 登录成功 处理类
 */
@Component("googleAuthenticationSuccessHandler")
public class GoogleAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired private ObjectMapper objectMapper;

    @Autowired private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功!");

        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
            super.onAuthenticationSuccess(req,resp,authentication);
        }

    }

}
