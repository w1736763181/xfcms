package site.paoyer.xfcms;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@SpringBootApplication
@EnableCaching
public class XfcmsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(XfcmsApplication.class, args);
        try {
            File file = new File("E:\\project\\xfcms\\test.txt");
            FileOutputStream output = new FileOutputStream(file);
            Map<String, Object> beans =  context.getBeansOfType(Object.class);
            for(String s : beans.keySet()) {
                IOUtils.write(s + "\n", output, "UTF-8");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
