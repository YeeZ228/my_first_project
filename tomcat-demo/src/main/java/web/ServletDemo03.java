package web;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  1.一个Servlet可以配置多个urlPattern
 *  2.urlPattern配置规则
 *      精确匹配 : "/demo03"
 *      目录匹配 : /user/*(写什么都可以访问到)
 *      扩展名匹配 : *.do (不得以 / 开头)
 *      任意匹配 : /（当项目中的servlet配置了 "/"，会覆盖掉tomcat中的defaultServlet，进而导致静态资源无法被访问） 和 /*
 */
@WebServlet(urlPatterns = {"/demo03", "/demo3"})
public class ServletDemo03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
    }
}
