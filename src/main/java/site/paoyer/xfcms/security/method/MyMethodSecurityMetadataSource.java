package site.paoyer.xfcms.security.method;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.AbstractFallbackMethodSecurityMetadataSource;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Collection;

public class MyMethodSecurityMetadataSource extends
        AbstractFallbackMethodSecurityMetadataSource implements BeanClassLoaderAware {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        Assert.notNull(beanClassLoader, "Bean class loader required");
        this.beanClassLoader = classLoader;
    }

    @Override
    protected Collection<ConfigAttribute> findAttributes(Method method, Class<?> targetClass) {
        return null;
    }

    /**
     * Implementation does not support class-level attributes.
     */
    @Override
    protected Collection<ConfigAttribute> findAttributes(Class<?> clazz) {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}
