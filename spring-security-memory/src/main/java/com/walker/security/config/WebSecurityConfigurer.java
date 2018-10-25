package com.walker.security.config;

import com.walker.security.auth.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() // 都可以访问
                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/users/**").hasRole("USER")  // 相应角色可以访问
                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admins/**").hasRole("ADMIN") // 相应角色可以访问
                .and()
                .formLogin() // 基于 form 表单登录验证
                .loginPage("/login").failureUrl("/login-error")
                .successHandler(successHandler)
                .and()
                .exceptionHandling().accessDeniedPage("/403"); // 处理异常
        http.logout().logoutSuccessUrl("/"); // 成功登出后，重定向到首页
    }

    /**
     * 用户信息服务：内存中
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("walker").password(passwordEncoder().encode("12345")).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("12345")).roles("ADMIN").build());
        return manager;
    }

    /**
     * 认证信息管理
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
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
