package com.kozak.study;

import com.kozak.study.logging.impl.ConsoleLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    private ConfigurableApplicationContext ctx;

    public ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    public Main(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    public static void main(String[] args) {
        final Main main = new Main(new ClassPathXmlApplicationContext("default_beans.xml"));
        ConsoleLogger logger = (ConsoleLogger) main.getCtx().getBean("logger");
        logger.log(main.getCtx().getBean("client"));
        main.getCtx().close();

    }
}
