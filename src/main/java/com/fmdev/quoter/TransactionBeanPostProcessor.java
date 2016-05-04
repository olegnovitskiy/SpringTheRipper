package com.fmdev.quoter;

import com.fmdev.quoter.annotation.Transactional;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TransactionBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<String, Class>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final Class<?> beanClass = bean.getClass();
        // Будем обворачивать такие классы в прокси
        if (beanClass.isAnnotationPresent(Transactional.class)) {
            map.put(beanName, beanClass);
        }

        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        final Class beanClass = map.get(beanName);
        if (beanClass!=null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // Новая логика, которая будет в том классе, который сейчас сгенериться на лету
                            System.out.println("******TRANS OPEN******");
                            final Object retVal = method.invoke(bean, args);
                            System.out.println("******TRANS CLOSED****");
                            return retVal;
                        }
                    });
        }
        return bean;
    }
}
