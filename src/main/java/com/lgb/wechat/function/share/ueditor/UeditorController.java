package com.lgb.wechat.function.share.ueditor;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {
    @RequestMapping("/server")
    public void server(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type" , "text/html");

            String rootPath = request.getSession().getServletContext().getRealPath("/");
            String exec = new ActionEnter(request, rootPath).exec();

            PrintWriter out = response.getWriter();
            out.write(exec);
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
