package com.javens.aop;

import com.javens.aop.service.AopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    protected static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
            ctx.load("spring-base.xml");
            ctx.refresh();
            logger.info("Application start  success----------");
        } catch (Exception e) {
            logger.error("== Application context start error:{}", e.getMessage());
        }

        synchronized (Application.class) {
            while (true) {
                try {
                    Application.class.wait();
                } catch (InterruptedException e) {
                    logger.error("== synchronized error:", e);
                }
            }
        }


    }
}
