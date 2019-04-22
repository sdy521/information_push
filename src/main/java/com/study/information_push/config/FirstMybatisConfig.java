package com.study.information_push.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author sdy
 * @date 2019/4/17 9:51
 * 第一数据源
 */
@Configuration
@MapperScan(basePackages = "com.study.information_push.dao.first", sqlSessionTemplateRef = "sqlSessionTemplate1")
@EnableAutoConfiguration(exclude = {MapperAutoConfiguration.class, MybatisAutoConfiguration.class})
public class FirstMybatisConfig {

    @Bean("firstDatasource")
    @ConfigurationProperties("spring.datasource.first")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sessionFactory1")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("firstDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.study.information_push.entity.first");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("firstDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
