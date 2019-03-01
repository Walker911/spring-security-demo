package com.walker.security.handler;

import com.walker.security.common.ResultBean;
import com.walker.security.util.ResponseUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author walker
 * @date 2019/3/1
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {
        ResultBean result;
        if (exception instanceof BadCredentialsException ||
                exception instanceof UsernameNotFoundException) {
            result = ResultBean.error("账户名或者密码输入错误!");
        } else if (exception instanceof LockedException) {
            result = ResultBean.error("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            result = ResultBean.error("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            result = ResultBean.error("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            result = ResultBean.error("账户被禁用，请联系管理员!");
        } else {
            result = ResultBean.error("登录失败!");
        }
        ResponseUtil.writeResponse(httpServletResponse, result);
    }
}
