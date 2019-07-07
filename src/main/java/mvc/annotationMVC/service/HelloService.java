package mvc.annotationMVC.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayhello(String string){
        return "hello ==" + string;
    }
}
