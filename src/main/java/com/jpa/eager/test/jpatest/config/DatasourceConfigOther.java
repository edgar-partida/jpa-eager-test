package com.jpa.eager.test.jpatest.config;


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.jpa.eager.test.jpatest.data.repo",
        entityManagerFactoryRef = "otsEntityManagerFactory",
        transactionManagerRef = "otsTransactionManager"
)
public class DatasourceConfigOther {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties otsDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource otsHikariDataSource() {
        return otsDatasourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Primary
    @Bean
    public JdbcTemplate otsJdbcTemplate() {
        return new JdbcTemplate(otsHikariDataSource());
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean otsEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(otsHikariDataSource())
                .packages("com.jpa.eager.test.jpatest.data.entity")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager otsTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(otsEntityManagerFactory(builder).getObject()));
    }
}

