package com.iclinicemr.training.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaConfigTest {
    private static Logger logger = LogManager.getLogger(JpaConfigTest.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;
//    @Autowired
//    public JpaConfigTest(DataSourceProperties dataSourceProperties) {
//        this.dataSourceProperties = dataSourceProperties;
//
//    }

    public JpaConfigTest() {
    }

    @Test
    public void testDataSoruceProperties() {
        logger.info("testDataSoruceProperties");
        logger.info("username: {}, password: {}", dataSourceProperties.getUsername(), dataSourceProperties.getPassword());
    }
}
