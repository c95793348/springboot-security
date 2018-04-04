package org.google.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.google.security.browser.support.SimpleRespone;
import org.google.security.core.properties.LoginType;
import org.google.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wbcaoa on 2018/3/29.
 */
@Component("googleAuthenticationFailureHandler")
public class GoogleAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired private ObjectMapper objectMapper;

    @Autowired private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {

        logger.info("登录失败!");

        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(objectMapper.writeValueAsString(new SimpleRespone(e.getMessage())));
        }else {
            super.onAuthenticationFailure(req,resp,e);
        }


    }
}
