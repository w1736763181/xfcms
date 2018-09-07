package site.paoyer.xfcms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value="/api")
public class HelloController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public Map<String, String> hello() {
//        DefaultWebSecurityExpressionHandler
//        RequestMappingHandlerAdapter
        var s = new HashMap<String, String>();
        s.put("12", "12321");
        s.put("123", "21321");
        return s;
    }

    @RequestMapping(value="/hello1", method = RequestMethod.GET)
    public Map<String, String> hello1() {
//        DefaultWebSecurityExpressionHandler

        var s = new HashMap<String, String>();
        s.put("12", "1fdafaf adf a1");
        s.put("123", "21fadfa fda 321");
        return s;
    }


    @RequestMapping(value="/hello2", method = RequestMethod.GET)
    public Map<String, String> hello2() {
//        DefaultWebSecurityExpressionHandler
        var s = new HashMap<String, String>();
        Map<RequestMappingInfo, HandlerMethod> temp = requestMappingHandlerMapping.getHandlerMethods();
        for(RequestMappingInfo requestMappingInfo : temp.keySet()) {
            for(String pattern : requestMappingInfo.getPatternsCondition().getPatterns()) {
                s.put(pattern, temp.get(requestMappingInfo).getBean().toString());
            }
        }
        return s;
    }

//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }
}