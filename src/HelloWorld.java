import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;


/**
 * @program: JavaWeb
 * @description: HelloWorld.java
 * @author: Yann
 * @create: 2019-04-09 15:02
 **/
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
//    选了正确的向导,idea想起来给提示了
    private String message;

    @Override
    public void init() throws ServletException{
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应内容类型
        resp.setContentType("text/html");

        //设置逻辑实现
//        PipedWriter out = resp.getWriter();
        PrintWriter out = resp.getWriter();
        System.out.println("<h1>" + message + "</h1>");

    }

    @Override
    public void destroy(){
        super.destroy();
    }
}
