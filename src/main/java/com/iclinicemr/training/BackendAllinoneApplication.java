package com.iclinicemr.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableAutoConfiguration(
        exclude={
//                DataSourceAutoConfiguration.class,
                SecurityAutoConfiguration.class
        })
public class BackendAllinoneApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendAllinoneApplication.class, args);
    }

}
