package web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 请求转发
 */
@WebServlet("/req4")
public class RequestDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo4...");
        // 请求转发资源间共享数据：使用Request对象
//        request.setAttribute();
//        request.getAttribute();
//        request.removeAttribute();
        request.setAttribute("msg", "Hello");

        /**
         * 地址栏路径不发生变化
         * 只能转发到服务器内部资源
         * 使用request共享数据
         */


        // 请求转发
        request.getRequestDispatcher("/req5").forward(request,response);


    }
}
