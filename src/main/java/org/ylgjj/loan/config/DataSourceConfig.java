package org.ylgjj.loan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //数据源1-引用配置:spring.datasource.primary
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
     /*   try {
            return new LazyConnectionDataSourceProxy(proxoolDataSource());

        }catch (NullPointerException e) {
            System.out.printf("we get null dataSource");
            e.printStackTrace();
            return null;
        }*/
        //return DataSourceBuilder.create().build();
    }



/*
    @Autowired
    DBConfig dBConfig;
*/

    /*public ProxoolDataSource proxoolDataSource(){
        ProxoolDataSource ds = new ProxoolDataSource();
        ds.setDriver(dBConfig.getDriverClassName());
        ds.setUser(dBConfig.getUsername());
        ds.setDriverUrl(dBConfig.getUrl());
        ds.setPassword(dBConfig.getPassword());
        ds.setMaximumConnectionCount(10);
        ds.setMinimumConnectionCount(2);
        ds.setSimultaneousBuildThrottle(5);

        ds.setTestBeforeUse(true);
        ds.setTestBeforeUse(true);
        ds.setTestAfterUse(true);
        ds.setHouseKeepingTestSql("select CURRENT_DATE");
        System.out.println("ddddddd"+dBConfig.toString());

   *//*     ds.setPreferredTestQuery("select 1");
        ds.setTestConnectionOnCheckout(true);
        ds.setTestConnectionOnCheckin(true);


        <property name=”minEvictableIdleTimeMillis” value=”1800000″ />
        <property name=”numTestsPerEvictionRun” value=”3″ />
        <property name=”testOnBorrow” value=”true” />
        <property name=”testWhileIdle” value=”true” />
        <property name=”testOnReturn” value=”true” />
        <property name=”validationQuery” value=”SELECT 1″ />
        idleConnectionTestPeriod =1800  这个项，意思是如果连接在池里睡的时间超过1800s会做一次连接可用的检查，如果发现连接不可用，，就释放掉

        再加个 jdbc.maxIdleTime=14400*//*
        return ds;
    }*/


    //数据源2-引用配置:spring.datasource.secondary
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasourcesecondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Autowired
    // @Qualifier("primaryDataSource")
    @Qualifier("secondaryDataSource")


    private DataSource dataSource;




}