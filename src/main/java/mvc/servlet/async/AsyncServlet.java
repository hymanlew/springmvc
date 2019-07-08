package mvc.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 因此 servlet3.0 引入了非阻塞 IO 来进一步增强异步处理的性能。
 *
 * 在 dopost 方法中开启的父子线程都是属于同一线程池，所以在实际项目中，可以单独指定处理业务的线程池。
 * 但是在 springMVC 框架中，它会提供一个单独的线程池去处理业务，而不需要自定义了。
 */
@WebServlet(
        name="async",
        urlPatterns={"/servletAsync/**"},
        asyncSupported = true,
        loadOnStartup=1
)
public class AsyncServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1，asyncSupported = true，开启异步处理支持
        // 2，开启异步模式
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(3000);
        System.out.println(Thread.currentThread() + " ==== 主线程 start === "+System.currentTimeMillis());

        // 3，业务逻辑进行异步处理，开始异步处理
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " ==== 子线程 start === "+System.currentTimeMillis());
                try {
                    System.out.println("====== 进行 IO 操作，比如访问数据库，调用第三方接口等");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread() + " ==== 子线程 end === "+System.currentTimeMillis());

                    // 4，异步处理完成
                    asyncContext.complete();

                    // 5，获取异步处理上下文的另一种方式，并得到异步处理的响应
                    AsyncContext asyncContext = req.getAsyncContext();
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("servlet 3.0 async ==== POST");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        System.out.println(Thread.currentThread() + " ==== 主线程 end === "+System.currentTimeMillis());
    }
}
