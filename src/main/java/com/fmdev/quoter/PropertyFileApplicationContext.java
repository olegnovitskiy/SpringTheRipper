package com.fmdev.quoter;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by NIO on 04.05.2016. All rights reserved.
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        final PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        final int beanCount = reader.loadBeanDefinitions(fileName);
        System.out.println("Found " + beanCount + " beans");
        refresh();
    }

    public static void main(String[] args) {
        final PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");
        // Будет падать потому, что нет сеттера на repeat
        context.getBean(Quoter.class).sayQuote();
    }
}
