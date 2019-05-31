package top.yyf256.blog.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import top.yyf256.blog.constant.SystemConstant;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartListener implements ServletContextListener {

    @Value("${server.servlet.context-path}")
    private String projectName;

    @Value("${system.name}")
    private String systemName;

    private Logger logger = LogManager.getLogger(StartListener.class);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(SystemConstant.PROJECT_NAME,projectName);
        sce.getServletContext().setAttribute(SystemConstant.SYSTEM_SHOW_NAME,systemName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
