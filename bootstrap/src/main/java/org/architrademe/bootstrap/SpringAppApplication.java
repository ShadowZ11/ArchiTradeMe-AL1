package org.architrademe.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.Entity;
import javax.sql.DataSource;

@ConditionalOnWebApplication
@SpringBootApplication
@EntityScan({"org.example"})
public class SpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }

}
