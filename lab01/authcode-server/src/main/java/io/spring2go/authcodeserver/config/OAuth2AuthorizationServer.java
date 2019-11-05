package io.spring2go.authcodeserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 最简授权服务器配置
 */
@Configuration
// 告诉 spring 启用授权服务器
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends
        AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        // 配置授权服务器
        clients.inMemory()
                // 客户凭证
                .withClient("clientapp")
                .secret("112233")
                // 重定向地址
                .redirectUris("http://localhost:9001/callback")
                // 授权码模式
                .authorizedGrantTypes("authorization_code")
                // 指定授权
                .scopes("read_userinfo", "read_contacts");
    }

}
