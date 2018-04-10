package org.google.security.core.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by wbcaoa on 2018/4/10.
 *
 * 封装登录信息
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken  {

    private static final long serialVersionUID = 420L;
    private final Object principal;//认证信息 证成功之前:存放用户手机号，认证成功之后:存放用户认证信息


    public SmsCodeAuthenticationToken(String moblie) {
        super((Collection)null);
        this.principal = moblie;//没登录之前 存放手机号
        this.setAuthenticated(false);
    }

    public SmsCodeAuthenticationToken(Object principal,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;//登录成功之后存放用户信息
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return null;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if(isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
