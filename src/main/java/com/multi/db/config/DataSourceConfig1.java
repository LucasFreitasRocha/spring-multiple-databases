package com.multi.db.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test1EntityManagerFactory",
        transactionManagerRef = "test1TransactionManager",
        basePackages = { "com.multi.db.repository.test1" }
)
public class DataSourceConfig1 {

    @Primary
    @Bean(name = "test1db")
    @ConfigurationProperties(prefix = "test1.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "test1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    test1EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("test1db") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.multi.db.model")
                        .build();
    }
    @Primary
    @Bean(name = "test1TransactionManager")
    public PlatformTransactionManager test1TransactionManager(
            @Qualifier("test1EntityManagerFactory") EntityManagerFactory
                    barEntityManagerFactory
    ) {
        return new JpaTransactionManager(barEntityManagerFactory);
    }
}
