package org.architrademe.bootstrap.configuration.controllers;

import org.example.consultant.service.ConsultantService;
import org.example.service.ConsultantServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public ConsultantService heroSpiInterface(){
        return new ConsultantServiceImpl();
    }

}
