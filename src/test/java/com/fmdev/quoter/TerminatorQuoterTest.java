package com.fmdev.quoter;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TerminatorQuoterTest {
    @Test
    public void testSayQuote() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        // Tecт упадет, т.к. бина TerminatorQuoter.class уже нет. Есть бин из другого класса Proxy$что-то-там
        context.getBean(TerminatorQuoter.class);
    }
}