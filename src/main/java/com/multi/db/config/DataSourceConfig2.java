package com.multi.db.config;

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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test2EntityManagerFactory",
        transactionManagerRef = "test2TransactionManager",
        basePackages = { "com.multi.db.repository.test2" }
)
public class DataSourceConfig2 {

    @Bean(name = "test2db")
    @ConfigurationProperties(prefix = "test2.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    test1EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("test2db") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.multi.db.model")
                        .build();
    }
    @Bean(name = "test2TransactionManager")
    public PlatformTransactionManager test1TransactionManager(
            @Qualifier("test2EntityManagerFactory") EntityManagerFactory
                    barEntityManagerFactory
    ) {
        return new JpaTransactionManager(barEntityManagerFactory);
    }
}
