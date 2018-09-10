package site.paoyer.xfcms.mapping;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class MyRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    @Nullable
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
//        RequestMapping prefixMapping = new RequestMapping();
        PatternsRequestCondition prc = new PatternsRequestCondition("/test");
        RequestMappingInfo prefix = new RequestMappingInfo(null, prc, null, null, null, null, null, null);
        RequestMappingInfo info = this.createRequestMappingInfo(method);
        if (info != null) {
            RequestMappingInfo typeInfo = this.createRequestMappingInfo(handlerType);
            if (typeInfo != null) {
                info = typeInfo.combine(info);
            }
        }
        String s = handlerType.getCanonicalName();
        System.out.println(s);
        if(handlerType.getCanonicalName().contains("spring")) {
            return info;
        }
        return info != null ? prefix.combine(info) : prefix;
    }

    @Nullable
    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
        RequestMapping requestMapping = (RequestMapping) AnnotatedElementUtils.findMergedAnnotation(element, RequestMapping.class);
        RequestCondition<?> condition = element instanceof Class ? this.getCustomTypeCondition((Class)element) : this.getCustomMethodCondition((Method)element);
        return requestMapping != null ? this.createRequestMappingInfo(requestMapping, condition) : null;
    }
}
