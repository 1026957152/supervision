package org.ylgjj.loan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 注入JPA:
 * entityManagerFactory :  entityManagerFactoryPrimary
 * transactionManager   :  transactionManagerPrimary
 * basePackages         :  com.example.domain.primary
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= {"org.ylgjj.loan.repository"}) //设置Repository所在位置
public class PrimaryConfig {
    @Autowired
    private HibernateProperties hibernateProperties;
    //创建数据源 primaryDataSource - 引用数据源1配置:primaryDataSource
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    /**
     * 创建数据源1的entityManagerFactoryPrimary
     * 1,使用primaryDataSource配置
     * 2,数据实体包名packages:com.example.domain.primary
     */
    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties())
                .packages("org.ylgjj.loan.domain") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Resource
    private JpaProperties jpaProperties;
/*    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }*/
    private Map<String, Object> getVendorProperties() {

       // properties.put("hibernate.hbm2ddl.auto", "DB2ZOSDialect");
        Map<String, String> properties = jpaProperties.getProperties();
/*        spring.jpa.properties.hibernate.dialect=com.my.package.to.MyDB2Dialect
        spring.jpa.database=db2*/

        //org.hibernate.dialect.DB2390Dialect or . This is a FAQ. –
        properties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.DB2400Dialect");
        properties.put("spring.jpa.database", "db2");
        properties.put("spring.jpa.show-sql", "true");
/*  jpa: #统一JPA配置
    database: MYSQL
    show-sql: true
    properties: 
      hibernate:  
        dialect: org.hibernate.dialect.DB2400Dialect
   // database-platform: org.hibernate.dialect.MySQL5InnoDBDialect*/

        return hibernateProperties.determineHibernateProperties(properties, new HibernateSettings());
    }
    //spring.jpa.properties.hibernate.dialect=com.my.package.to.MyDB2Dialect
   // spring.jpa.database=db2
    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }

}