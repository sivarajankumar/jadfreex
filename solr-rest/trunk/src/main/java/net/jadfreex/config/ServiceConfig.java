package net.jadfreex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ServiceConfig {

    @Bean
    public LocalValidatorFactoryBean valitador() {
	return new LocalValidatorFactoryBean();
    }

}
