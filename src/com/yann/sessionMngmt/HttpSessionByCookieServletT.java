package com.yann.sessionMngmt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: JavaWeb
 * @description: HttpSession的默认Cookie实现案例
 * @author: Yann
 * @create: 2019-04-10 11:26
 **/
@WebServlet(urlPatterns = "/sessionByCookie")
public class HttpSessionByCookieServletT extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 获取session
        // 如果是第一次请求的话，会创建一个HttpSession，等同于 req.getSession(true);
        // 如果已存在session，则会获取session
        HttpSession session = request.getSession();

        if (session.isNew()) {
            session.setAttribute("name", "Jeff");  // 设置session属性值
        }

        String sessionId = session.getId();

        PrintWriter out = response.getWriter();
        // 如果HttpSession是新建的话
        if (session.isNew()) {
            out.println("Hello,HttpSession! <br>The first response - SessionID=" + sessionId + "<br>");
        } else {
            out.println("Hello, HttpSession! <br> The second response - SessionId=" + sessionId + "<br>");
            // 从Session获取属性值
            out.println("The seconde-response -name:" + session.getAttribute("name"));
        }
    }
}
