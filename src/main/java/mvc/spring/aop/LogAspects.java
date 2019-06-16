package mvc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

// AOP日志切面类
@Aspect
public class LogAspects {

    /**
     * 类上添加 @Aspect 注解。
     *
     * 在 anyMethod（方法名可以是任意的）方法上使用 Pointcut 注解，要注意该方法必须是没有返回值和参数的。即该方法只是一个标识
     * 作用，不参与逻辑调用，即不会被调用的。
     * 而 Before，After 注解就是定义 Advice，表示指定作用到哪些 Pointcut（即作用于哪些 Joinpoint）。
     *
     * execution(* save*(..))：第一个星号代表匹配指定方法（save 方法）的返回值（无论是否有返回值），两个点代表匹配指定方法的所
     * 有参数（无论是否有参数都会全部匹配）。
     *
     * execution(* com.hyman.service.AopService.*(..))：代表只匹配指定类下面的方法（且是所有方法），进行切面拦截。
     *
     * execution(* com.hyman.service.*.*(..))：代表只匹配指定包下所有类中的所有方法，进行切面拦截。
     *
     * execution(* com.hyman.service..*.*(..))：代表只匹配指定包及其所有的子包下面所有类中的的所有方法，进行切面拦截。
     *
     * execution(* com.hyman.service..*.save*(..)) || execution(* com.hyman.service..*.del*(..))：多条件组合匹配使用。
     *

     * AOP 通知方法包括：前置通知，后置通知（无论是否异常都调用），返回通知（正常返回时），异常通知（方法异常时），环绕通知（动态代理，手动调用目标方法）。
     *
     */

    @Pointcut("execution(public int mvc.spring.aop.MathCalculator.*(..))")
    private void anyMethod(){}

    @Before("anyMethod()")
    @Order(2)
    private void beforeMd2(JoinPoint joinPoint){
        System.out.println("获取拦截的方法的参数数组：" + Arrays.asList(joinPoint.getArgs()));
        System.out.println("获取拦截的方法名：" + joinPoint.getSignature().getName());
    }

    @Before("anyMethod()")
    @Order(1)
    public void logStart(){
        System.out.println("除法运行=====");
    }

    // 如果是调用其他切面中的切入点方法时，使用以下方式，指定全类名及方法名
    @After("mvc.spring.aop.LogAspects.anyMethod()")
    public void logEnd(){
        System.out.println("除法结束=====");
    }

    // 接收方法返回值
    @AfterReturning(value = "anyMethod()", returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正常返回===== "+ result);
    }

    // 要注意，如果方法中有多个参数时，JoinPoint 必须放在第一个，否则会抛异常
    // 接收方法异常信息
    @AfterThrowing(value = "anyMethod()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e){
        System.out.println("除法异常===== ");
        e.printStackTrace();
    }

    // 在被通知的方法调用之前和调用之后执行自定义的行为，等于 before + after。
    // 并且要注意在调用 around 时，原方法的返回值(也就是你要织入的方法)与通知的返回值要保持一致，否则就会抛异常。
    @Around("anyMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕通知===== ");
        return joinPoint.proceed();
    }
}
