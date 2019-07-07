package mvc.servlet.config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WebServlet，该注解的含义是注册一个 servlet。
 * WebFilter，该注解的含义是注册一个 Filter。
 * WebListener，该注解的含义是注册一个 Listener。
 *
 * WebInitParam，该注解的含义是初始化 servlet 参数。
 */
@WebServlet(
        name="Hello",
        urlPatterns={"/hello"},
        loadOnStartup=1
)
public class HelloServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello servlet 3.0 ==== GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello servlet 3.0 ==== POST");
    }
}
