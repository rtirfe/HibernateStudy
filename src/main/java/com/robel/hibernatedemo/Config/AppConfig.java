package com.robel.hibernatedemo.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.robel.hibernatedemo")
@PropertySource("classpath:prod.properties")
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.pass"));

        return dataSource;
    }

    //SPI interface that allows to plug in vendor-specific behavior into
    // Spring's EntityManagerFactory creators
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabase(Database.MYSQL);
        return adapter;
    }

    //LocalContainerEntityManagerFactoryBean : FactoryBean that creates a JPA EntityManagerFactory according to
    // JPA's standard container bootstrap contract.
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory
    (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){

        Properties props= new Properties();
        props.setProperty("hibernate.format_sql", String.valueOf(true));
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.robel.hibernatedemo.Entities");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setJpaProperties(props);

        return emf;
    }
}
