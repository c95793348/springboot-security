package org.google.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wbcaoa on 2018/4/10.
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public static final String GOOGLE_SECURITY_FORM_MOBLIE_KEY = "moblie";
    private String moblieParameter = "moblie";
    private boolean postOnly = true;

    public SmsCodeAuthenticationFilter() {
        super(new AntPathRequestMatcher("/authentication/moblie", "POST"));
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String moblie = this.obtainMoblie(request);

            if(moblie == null) {
                moblie = "";
            }

            moblie = moblie.trim();
            //实例化Token
            SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(moblie);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    /**
     * 获取手机号
     * @param request
     * @return
     */
    protected String obtainMoblie(HttpServletRequest request) {
        return request.getParameter(this.moblieParameter);
    }

    protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setMoblieParameter(String moblieParameter) {
        Assert.hasText(moblieParameter, "Moblie parameter must not be empty or null");
        this.moblieParameter = moblieParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getMoblieParameter() {
        return this.moblieParameter;
    }

}