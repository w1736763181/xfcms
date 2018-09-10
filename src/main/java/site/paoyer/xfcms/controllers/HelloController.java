package site.paoyer.xfcms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class HelloController {
//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    RequestMappingHandlerMapping requestMappingHandlerMapping;
//    @Autowired
//    RedisCacheManager cacheManager;
    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(value="testCache")
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public Map<String, String> hello() {
//        DefaultWebSecurityExpressionHandler
//        RequestMappingHandlerAdapter
//        WebMvcAutoConfiguration
        var s = new HashMap<String, String>();
        s.put("12", "12321");
        s.put("123", "21321");
        redisTemplate.opsForValue().set("test", "wuzhao");
        return s;
    }

    @Cacheable(value="testCache2")
    @RequestMapping(value="/hello1", method = RequestMethod.GET)
    public Map<String, String> hello1() {
//        DefaultWebSecurityExpressionHandler

        var s = new HashMap<String, String>();
        s.put("12", "1fdafaf adf a1");
        s.put("123", (String)redisTemplate.opsForValue().get("test"));
        return s;
    }


    @RequestMapping(value="/hello2", method = RequestMethod.GET)
    public Map<String, String> hello2() {
        redisTemplate.opsForValue().set("test", "wuzhao12");
//        DefaultWebSecurityExpressionHandler
        var s = new HashMap<String, String>();
//        Map<RequestMappingInfo, HandlerMethod> temp = requestMappingHandlerMapping.getHandlerMethods();
//        for(RequestMappingInfo requestMappingInfo : temp.keySet()) {
//            for(String pattern : requestMappingInfo.getPatternsCondition().getPatterns()) {
//                s.put(pattern, temp.get(requestMappingInfo).getBean().toString());
//            }
//        }Map<RequestMappingInfo, HandlerMethod> temp = requestMappingHandlerMapping.getHandlerMethods();
//        for(RequestMappingInfo requestMappingInfo : temp.keySet()) {
//            for(String pattern : requestMappingInfo.getPatternsCondition().getPatterns()) {
//                s.put(pattern, temp.get(requestMappingInfo).getBean().toString());
//            }
//        }
        return s;
    }

//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }
}