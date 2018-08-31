package site.paoyer.xfcms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public Map<String, String> hello() {
        var s = new HashMap<String, String>();
        s.put("12", "12321");
        s.put("123", "21321");
        return s;
    }
}