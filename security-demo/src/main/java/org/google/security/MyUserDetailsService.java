package org.google.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created by wbcaoa on 2018/3/29.
 */
@Component
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名: " + username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录用户Id: " + userId);
        return buildUser(userId);

    }

    private SocialUserDetails buildUser(String userId) {
        //根据用户名查找用户信息
        //根据用户信息判断用户是否被锁定(4种状态)
        System.out.println(passwordEncoder.encode("123456"));
        return new SocialUser(userId,passwordEncoder.encode("123456"), AuthorityUtils
                .commaSeparatedStringToAuthorityList("admin"));
    }
}
