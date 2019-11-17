package mvc.instruc;

public class Instruction {
    /**
     Listener 是web三大组件之一，是servlet监听器，用来监听请求，监听服务端的操作。都是接口类，必须实现相应方法，可分为：

     生命周期监听器（3个）：
     1，ServletContextListener：
     requestInitialized 在容器启动时被调用（在servlet被实例化前执行）
     requestDestroyed 在容器销毁时调用（在servlet被销毁后执行）

     2，HttpSessionListener：
     sessionCreated 在HttpSession创建后调用
     sessionDestroyed 在HttpSession销毁前调用（执行session.invalidate();方法）

     3，ServletRequestListener：
     requestDestroyed 在request对象创建后调用（发起请求）
     requestInitialized 在request对象销毁前调用（请求结束）


     属性变化监听器（3个），这些监听器接口除了传参不同，方法名都是一样的。分别监听application，session，request对象的属性变化：
     1，ServletContextAttributeListener：
     attributeAdded(ServletContextAttributeEvent event)　　向appliction中添加属性时调用
     attributeRemoved(ServletContextAttributeEvent event)　　从appliction中删除属性时调用
     attributeReplaced(ServletContextAttributeEvent event)　　替换application中的属性时调用

     2，HttpSessionAttributeListener：
     attributeAdded(HttpSessionBindingEvent event)
     attributeRemoved(HttpSessionBindingEvent event)
     attributeReplaced(HttpSessionBindingEvent event)

     3，ServletRequestAttributeListener：
     attributeAdded(ServletRequestAttributeEvent event)
     attributeRemoved(ServletRequestAttributeEvent event)
     attributeReplaced(ServletRequestAttributeEvent event)


     session中指定类属性变化监听器（2）：
     1，HttpSessionBindingListener：
     valueBound(HttpSessionBindingEvent event) 当该类实例设置进session域中时调用
     valueUnbound(HttpSessionBindingEvent event) 当该类的实例从session域中移除时调用

     2，HttpSessionActivationListener：
     sessionWillPassivate(HttpSessionEvent se) 当对象session被序列化（钝化）后调用
     sessionDidActivate(HttpSessionEvent se)  当对象session被反序列化（活化）后调用


     */
}
