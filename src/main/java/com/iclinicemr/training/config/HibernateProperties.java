package com.iclinicemr.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

//@Component
//@ConfigurationProperties(prefix = "spring.jpa.properties")
public class HibernateProperties {
    @Value("${hibernate.show_sql}")
    boolean showSql;

    @Value("${hibernate.dialect}")
    String dialect;

    private Properties properties = new Properties();

    public HibernateProperties() {
    }

    @PostConstruct
    public void initProperties() {
        properties.setProperty("hibernate.show_sql", String.valueOf(showSql));
        properties.setProperty("hibernate.dialect", dialect);
    }

    public HibernateProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

//    public void setProperties(Properties properties) {
//        this.properties = properties;
//    }
}
