package cn.SkyShadow.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.SkyShadow.basic_component.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 验证码处理器
 * Created by RichardW on 9/14/2016.
 */
@Transactional
@Controller
@RequestMapping("/")
public class KaptchaController {
    private final Producer captchaProducer;
    private final ExceptionHandler exceptionHandle;

    public KaptchaController(Producer captchaProducer, ExceptionHandler exceptionHandle) {
        this.captchaProducer = captchaProducer;
        this.exceptionHandle = exceptionHandle;
        exceptionHandle.setClass(this.getClass());
    }


    /**
     * 验证码处理器
     *
     * @param session  Session
     * @param response 响应
     * @return 处理结果
     */
    @RequestMapping("/captcha-image")
    public ModelAndView handleRequest(HttpSession session, HttpServletResponse response) {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        try {
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
            out.close();
        } catch (IOException e) {
            exceptionHandle.ExceptionHandle(e);
        }
        return null;
    }
}
