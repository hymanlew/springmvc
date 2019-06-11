package mvc.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义返回需要导入容器的组件
public class MyImportSelector implements ImportSelector {

    /**
     * @param annotationMetadata 获取当前标注 @Import 注解的类的所有注解信息（包括所有注解各自的名称，值等等的信息）。
     * @return 返回值就是要导入到容器中的组件的全类名。
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //return new String[0];
        return new String[]{"mvc.spring.bean.Animal", "mvc.spring.bean.Color"};
    }
}
