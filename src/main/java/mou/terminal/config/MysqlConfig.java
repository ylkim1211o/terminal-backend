package mou.terminal.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "mou.terminal.web.repository.mysql")
public class MysqlConfig {

    @Bean(name = "MysqlProperties")
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mysqlProperties(){return new DataSourceProperties();}

    @Bean(name ="MysqlDataSource")
    public DataSource mysqlDataSource(@Qualifier(value = "MysqlProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "MysqlTemplate")
    public JdbcTemplate mysqlTemplate(@Qualifier(value = "MysqlDataSource") DataSource dataSource){return new JdbcTemplate(dataSource);}

}
