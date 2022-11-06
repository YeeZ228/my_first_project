package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebServlet(urlPatterns = "/demo02", loadOnStartup = 1)
public class ServletDemo02 implements Servlet {
    private ServletConfig config;

    /**
     * 每次servlet被访问时，该方法都会被调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello World");

    }

    /**
     * 初始化方法：
     *  1.调用时机：默认情况下，Servlet被第一次访问时调用
     *      loadOnStartUp:默认为-1，即只有当访问到当前servlet时，init()方法才会被调用
     *  2.调用次数：1次
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
        System.out.println("init...");
    }

    // 获取
    public ServletConfig getServletConfig() {
        return config;
    }

    // 获取信息
    public String getServletInfo() {
        return "";
    }

    /**
     * 内存释放或服务器关闭时，当前方法就会被调用
     */
    public void destroy() {
//        System.out.println("destroy...");
    }

}
