package org.google.security.core.social.qq.config;

import org.google.security.core.properties.QQPropeties;
import org.google.security.core.properties.SecurityProperties;
import org.google.security.core.social.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * Created by wbcaoa on 2018/5/4.
 */
@Configuration
@ConditionalOnProperty(prefix = "google.security.social.qq",name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {

        QQPropeties qqConfig = securityProperties.getSocial().getQq();

        return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }
}
