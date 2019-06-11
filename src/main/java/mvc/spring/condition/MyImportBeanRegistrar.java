package mvc.spring.condition;

import mvc.spring.bean.Color;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param annotationMetadata  获取当前标注 @Import 注解的类的所有注解信息（包括所有注解各自的名称，值等等的信息）。
     * @param beanDefinitionRegistry 把所有需要添加到容器中的 bean 调用此方法来注册到容器中。
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        // 判断容器中是否包含某一个类实例，需要指定一个 id 名称（要注意是否需要全类名）
        boolean havebean = beanDefinitionRegistry.containsBeanDefinition("user");
        if(havebean){

            // 注册 bean 对象到容器中，并指定一个 bean 名称（指定 bean的定义信息，bean的类型，作用域等等）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Color.class);
            beanDefinitionRegistry.registerBeanDefinition("color", rootBeanDefinition);
        }
    }
}
