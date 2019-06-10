package mvc.spring.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义扫描包的策略
 */
public class MyTypeFilter implements TypeFilter{

    /**
     * @param metadataReader：读取到当前正在扫描的类的信息。
     * @param metadataReaderFactory：可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的信息（类型是什么，实现了什么接口等等）
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类的资源（类的路径）
        Resource resource = metadataReader.getResource();

        // 使 IOC 容器只加载包含含有 user 名字的类实例
        String name = classMetadata.getClassName();
        System.out.println("----->: "+name);
        if(name.contains("user")){
            return true;
        }
        return false;
    }
}
