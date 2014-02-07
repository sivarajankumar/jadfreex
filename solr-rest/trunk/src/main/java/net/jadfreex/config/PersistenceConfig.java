package net.jadfreex.config;

import net.jadfreex.commons.connection.Connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public Connection connection() {
	return new Connection("http://localhost:8983/solr");
    }

}