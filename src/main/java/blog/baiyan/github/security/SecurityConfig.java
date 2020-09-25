package blog.baiyan.github.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author bai
 * @Description 权限配置文件
 * @Date 2020/7/16 1:05 PM
 * @github https://github.com/baiyan0707
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单方式
                .and()
                .authorizeRequests() // 授权配置
                .anyRequest()  // 所有请求
                .authenticated(); // 都需要认证
    }
}
