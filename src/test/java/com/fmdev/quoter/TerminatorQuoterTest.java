package com.fmdev.quoter;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TerminatorQuoterTest {
    @Test
    public void testSayQuote() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(TerminatorQuoter.class);
    }
}