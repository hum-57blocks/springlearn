package com.hum.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        // 读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        servletContext.setAttribute("app", app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
