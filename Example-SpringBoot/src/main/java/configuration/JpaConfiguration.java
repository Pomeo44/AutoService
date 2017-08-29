package configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "repository.api")
public class JpaConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.dataSource")
    public DataSource configureDataSource() {
        return DataSourceBuilder.create().build();
    }

}
