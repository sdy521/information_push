package com.study.information_push.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author sdy
 * @date 2019/4/22 15:32
 * 第二数据源
 */
@Configuration
@MapperScan(basePackages = "com.study.information_push.dao.second", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class SecondMybatisConfig {

    @Bean("secondDatasource")
    @ConfigurationProperties("spring.datasource.second")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     *  根据数据源创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "sessionFactory2")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("secondDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);// 指定数据源(这个必须有，否则报错)
        bean.setTypeAliasesPackage("com.study.information_push.entity.second");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }

    @Bean(name = "transactionManager2")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("secondDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
