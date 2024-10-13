package lk.ijse.thogakadepos_backend.config;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.thogakadepos_backend")
@EnableJpaRepositories(basePackages = "lk.ijse.thogakadepos_backend.dao")
@EnableTransactionManagement
public class WebAppRootConfig {

    // convert dto to entity and entity to dto
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // Database connectivity eka hada ganna
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/thogakade?createDatabaseIfNotExist=true&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Ijse@123");

        return driverManagerDataSource;
    }


    // ORM tool eka config kara ganna
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter); // Hibernate Core dependency eka da gathma meka vada karanva
        factory.setPackagesToScan("lk.ijse.thogakadepos_backend.entity.impl");
        factory.setDataSource(dataSource()); // uda hadala thiyena dataSource() method ekata call venava
        return factory;
    }


    // Transaction manage karanna
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
