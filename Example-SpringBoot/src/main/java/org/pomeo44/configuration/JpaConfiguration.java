package org.pomeo44.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "org.pomeo44.service")
public class JpaConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.dataSource")
    DataSource createDataSource() {
        return DataSourceBuilder.create().build();
    }

}
