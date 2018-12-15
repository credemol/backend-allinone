package com.iclinicemr.training.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


//@Configuration
//@EnableJpaRepositories
public class PersistenceConfig {
    private static Logger logger = LogManager.getLogger(PersistenceConfig.class);

    private DataSource dataSource;

    private Environment env;

    @Autowired
    public PersistenceConfig(Environment env, DataSource dataSource) {
        this.env = env;

        this.dataSource = dataSource;
//        this.hibernateProperties = hibernateProperties;

        logger.info("dataSource: {}", dataSource);
//        logger.info("hibernateProperties: {}", hibernateProperties.getProperties());
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emFactory.setDataSource(dataSource);
        emFactory.setPackagesToScan(new String[] {
                "com.iclinicemr.training.entity"
        });

        return emFactory;

    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }



//    @Bean(name="sessionFactory")
//    public SessionFactory sessionFactory() throws Exception {
//
//        Properties properties = new Properties();
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//        factoryBean.setPackagesToScan(new String[] { "" });
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setHibernateProperties(properties);
//        factoryBean.afterPropertiesSet();
//
//        return factoryBean.getObject();
//    }


}
