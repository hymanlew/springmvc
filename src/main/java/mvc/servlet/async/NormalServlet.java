package mvc.servlet.async;

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
 *
 * 在 servlet3.0 之前，servlet采用 Thread-Per-Request 的方式处理请求，即每一次 http 请求都由某一个线程从头到尾负责处理。
 * 如果有一个请求需要进行 IO 操作，比如访问数据库，调用第三方接口等，那么其所对应的线程将同步地等待 IO 操作完成，而 IO 是非常
 * 慢的，所以此时的线程并不能及时地释放回线程池以供后续使用，在并发量在时，这将带来严重的性能问题。而 spring 框架是建立在 servlet
 * 之上的，所以 springMVC 框架也会因此而产生性能问题。
 * 因此 servlet3.0 引入了非阻塞 IO 来进一步增强异步处理的性能。
 */
@WebServlet(
        name="noasync",
        urlPatterns={"/noasync/**"},
        loadOnStartup=1
)
public class NormalServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread() + " ==== start");
        try {
            System.out.println("====== 进行 IO 操作，比如访问数据库，调用第三方接口等");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " ==== end");
        resp.getWriter().write("servlet 3.0 async ==== POST");
    }
}
