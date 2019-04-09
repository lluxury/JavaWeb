package com.yann.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: JavaWeb
 * @description: cookie test
 * @author: Yann
 * @create: 2019-04-09 18:39
 **/
@WebServlet(urlPatterns = "/cookie")
public class CookieServletT extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        // 获取Cookie
        Cookie[] cookies = request.getCookies();

        //   需要 cookies 不为 空
        for (Cookie cookie :cookies)
            System.out.println(cookie.getName() + " " + cookie.getValue());

        // 创建Cookie
        Cookie cookie = new Cookie("CookieName", "CookieValue");
        cookie.setMaxAge(10);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        // 响应
        PrintWriter pw = response.getWriter();
        pw.print("<html><body><h1>Hello,Cookie!</h1></body></html>");;
    }

}
