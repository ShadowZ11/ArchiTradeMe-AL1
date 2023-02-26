package org.architrademe.bootstrap;

import org.architrademe.bootstrap.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import javax.persistence.Entity;
import javax.sql.DataSource;

@ConditionalOnWebApplication
@Import({ApplicationConfiguration.class})
@SpringBootApplication
@EntityScan({"org.example"})
public class SpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }

}
