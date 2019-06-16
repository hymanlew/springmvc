package mvc.spring.aop;

// AOP业务逻辑类
public class MathCalculator {

    public int div(int i, int j){
        System.out.println("开始运算========");
        return i/j;
    }
}
