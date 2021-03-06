package com.walker.security.config;

import com.walker.security.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private static final String key = "walker";

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() // 都可以访问
                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admins/**").hasRole("ADMIN") // 相应角色可以访问
                .and()
                .formLogin() // 基于 form 表单登录验证
                .loginPage("/login").failureUrl("/login-error")
                .and().rememberMe().key(key).tokenRepository(tokenRepository()) // 启用 remember me
                .and()
                .exceptionHandling().accessDeniedPage("/403"); // 处理异常
        http.logout().logoutSuccessUrl("/"); // 成功登出后，重定向到首页
    }

    /**
     * 认证信息管理
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsService userService() {
        return new UserServiceImpl();
    }

    /**
     * Spring Security 5 需要配置 PasswordEncoder, 不然会出现
     * java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
