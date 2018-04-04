package org.google.security.browser;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.google.security.browser.support.SimpleRespone;
import org.google.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wbcaoa on 2018/3/29.
 */
@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 需要身份认证跳转到此控制器
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleRespone requireAuthentication(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(req, resp);

        if (savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是: " + redirectUrl);
            if (StringUtils.endsWithIgnoreCase(redirectUrl,".html")){
                redirectStrategy.sendRedirect(req,resp,securityProperties.getBrowser().getLoginPage());
            }
        }

        return new SimpleRespone("访问的服务需要身份认证，请引导用户到登录页!");
    }

}
