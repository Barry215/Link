package cn.SkyShadow.basic_component.interceptor;

import cn.SkyShadow.basic_component.GsonUtil;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.factory.JsonResultFactory;
import cn.SkyShadow.service.CheckService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 要求登录
 * Created by Richard on 16/10/5.
 */
public class LoginStateInterceptor implements HandlerInterceptor{
    private final CheckService checkService;

    public LoginStateInterceptor(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (checkService.LoginState(request.getSession())){
            return false;
        }
        PrintWriter out = response.getWriter();
        out.print(GsonUtil.toJson(JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin)));
        out.flush();
        out.close();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
