package web;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.String;
import java.nio.charset.StandardCharsets;

/**
 * 中文乱码
 */
@WebServlet("/req3")
public class RequestDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST解决中文乱码的问题
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println("解决乱码前：" + username);

        // (GET)tomcat(老版本)进行URL解码时，默认的字符集是 ISO-8859-1
//        byte[] b = username.getBytes(StandardCharsets.ISO_8859_1);
//        String s = new String(b, StandardCharsets.UTF_8);
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        System.out.println("解决乱码后：" + username);
    }
}
