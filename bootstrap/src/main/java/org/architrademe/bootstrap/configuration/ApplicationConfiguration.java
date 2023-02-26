package org.architrademe.bootstrap.configuration;

import org.architrademe.bootstrap.configuration.controllers.ControllerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ControllerConfiguration.class})
public class ApplicationConfiguration {
}
