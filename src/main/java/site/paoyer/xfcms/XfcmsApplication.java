package site.paoyer.xfcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
public class XfcmsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(XfcmsApplication.class, args);
        Map<String, Object> beans =  context.getBeansOfType(Object.class);
        for(String s : beans.keySet()) {
            System.out.println(s);
            if(s.equals("methodSecurityMetadataSource")) {
                System.out.println(beans.get(s).toString());
                break;
            }
        }
//        MethodSecur
    }
}
