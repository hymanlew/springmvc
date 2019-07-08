package mvc.annotationMVC.controller;

import mvc.annotationMVC.service.DeferredResultQueue;
import org.apache.poi.ss.formula.functions.Odd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

// 在 springMVC 框架中，它会提供一个单独的线程池去处理业务，而不需要自定义了。
@Controller
@RequestMapping("/async")
public class AsyncController {

    /**
     * 如果控制器返回 Callable，则 spring 异步处理会将它提交到 TaskExecutor(任务执行器)，使用一个隔离的线程进行执行。
     * 此时 DispatcherServlet 和所有的 Filter，listener 都会退出 web 容器的线程，但是 response 保持打开状态。
     * Callable 返回结果后，springMVC 将请求重新派发给容器，恢复之前的处理。
     * 根据 Callable 返回的结果，springMVC 继续进行视图渲染流程（即从接收请求到视图渲染，再走一遍流程）。
     *
     * 由此可以看出，在异步处理下 springMVC 的拦截器并不能拦截异步处理过程。拦截过程使用的是异步拦截器：
     * 1，如果是使用 servlet 时是原生的 AsyncListener 的 API。
     * 2，如果是 springMVC 时，则异步请求的拦截器是实现了 AsyncHandlerInterceptor 接口的实现类。
     * @return
     */
    @RequestMapping("/method1")
    @ResponseBody
    public Callable<String> method1(){

        Callable<String> callable = new Callable<String>(){
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "MVC 异步处理请求=======";
            }
        };
        return callable;
    }

    /**
     * 如果异步处理业务比较复杂，得到结果需要很长时间，或者需要触发某些条件才能得到结果时（例如结合中间件监听传递数据的业务）。
     * 就需要使用下面的方式进行异步处理。
     * 使控制器先返回一个 DeferredResult<Object> 对象（延迟的结果对象），此时控制器就会等待该对象的处理结果。把 DeferredResult
     * 对象事先存在某一地方，然后当其他某一线程得到并调用该对象，再放入业务处理结果后，则控制器得到结果就会正常返回。
     * @return
     */
    @RequestMapping("/method2")
    @ResponseBody
    public DeferredResult<Object> method2(){
        // 第一步
        DeferredResult<Object> result = new DeferredResult<Object>((long)3000,"处理时间超时");
        DeferredResultQueue.save(result);
        // 第二步
        return result;
        // 第五步，正常返回并渲染页面。
    }

    @RequestMapping("/dosomething")
    @ResponseBody
    public String dosomething(){
        String order = UUID.randomUUID().toString();
        // 第三步
        DeferredResult<Object> result = DeferredResultQueue.get();
        // 第四步
        result.setResult(order);
        return "业务处理完成 ==== " + order;
    }
}
