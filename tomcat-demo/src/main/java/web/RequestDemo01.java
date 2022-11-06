package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Request : 获取请求数据
 *      继承体系 ServletRequest -> HttpServletRequest -> RequestFacade(Tomcat定义)
 *      获取请求数据
 *      请求转发
 * Response : 封装响应数据
 */
@WebServlet("/req1")
public class RequestDemo01 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 请求行：
         * GET
         *
         * http://localhost/req1
         * /req1
         * username=zhangsan
         */
        // String getMethod() : 获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        // String getContextPath() : 获取虚拟目录（项目访问路径）
        String contextPath = req.getContextPath();
        System.out.println(contextPath);


        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        // String getQueryString() : 获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // 请求头：user-agent(浏览器版本信息)
        // Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.26
        String header = req.getHeader("user-agent");
        System.out.println(header);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求体：
        // 1.获取字符输入流
        BufferedReader reader = req.getReader();
        // 2. 读取数据
        String line = reader.readLine();
        System.out.println(line);
    }
}
