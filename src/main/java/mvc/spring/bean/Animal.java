package mvc.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Animal {

    //@Autowired
    private Color color;

    public Animal(){

    }

    // 标注在构造器上或是参数上，则构造中参数（或参数）的值也会自动从 IOC 容器中获取到。
    // 并且如果本实例对象只有一个有参构造器，则构造器上 Autowired 可以省略，它同样也会自动获取到 bean 值。
    //@Autowired
    public Animal(@Autowired Color color){
        this.color = color;
    }

    public void init(){

    }

    public void destroy(){

    }

    public Color getColor() {
        return color;
    }

    // 当它标注在方法上时，spring 容器创建当前对象时，就会调用该方法完成赋值。即方法中参数的值会自动从 IOC 容器中获取到。
    //@Autowired
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color=" + color +
                '}';
    }
}
