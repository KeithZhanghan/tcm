package jz.interceptor;

import jz.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

              HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
             //判断session中是否有用户数据，如果有，则返回true，继续向下执行
            if (user != null) {
                        return true;
           }
       //不符合条件的给出提示信息，并转发到登录页面
        httpServletRequest.setAttribute("msg", "您还没有登录，请先登录！");
            String base=httpServletRequest.getContextPath();
        httpServletRequest.getRequestDispatcher(base+"/login/login.html").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
