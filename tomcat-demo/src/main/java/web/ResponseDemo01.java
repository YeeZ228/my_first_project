package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        // 重定向
        // 1. 设置响应状态码
        response.setStatus(302);
        // 2. 设置响应头
        // 动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.setHeader("location", contextPath + "/resp2");

        /**
         * 浏览器地址栏发生变化
         * 可重定向到任意位置的资源
         * 两次请求，不能通过传递request来共享信息
         */

        // 路径问题应注意：何时应该加虚拟目录？
        //  - 浏览器使用需要加虚拟目录（项目访问路径）
        //  - 服务器端使用则无需加虚拟目录

        // 简化方式完成重定向
        response.sendRedirect(contextPath + "/resp2");

    }
}
