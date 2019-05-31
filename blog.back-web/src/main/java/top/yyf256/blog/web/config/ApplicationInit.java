package top.yyf256.blog.web.config;

import freemarker.template.Configuration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import top.yyf256.security.core.JanusFreemarkCfg;

@Component
public class ApplicationInit implements ApplicationContextAware {


    @Autowired
    Configuration configuration;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        JanusFreemarkCfg.initFreemark(configuration);
    }
}
