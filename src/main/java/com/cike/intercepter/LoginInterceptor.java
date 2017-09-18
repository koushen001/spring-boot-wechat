package com.cike.intercepter;

import com.cike.common.MyConst;
import com.cike.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 8:53
 **/
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User user = (User) request.getSession().getAttribute(MyConst.CURRENT_USER);
        if (user == null) {
            LOGGER.info("拦截到请求：{}", request.getRequestURI());
            //User user1 = new User();
            //user1.setOpenid("001");
            //request.getSession().setAttribute(MyConst.CURRENT_USER, user1);
            response.sendRedirect("/login/wechat");
            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
