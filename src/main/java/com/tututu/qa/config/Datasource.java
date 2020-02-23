package com.tututu.qa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 21:44
 **/
@MapperScan(basePackages = "com.tututu.qa.repository",sqlSessionTemplateRef = "qaSqlSessionTemplate")
@Configuration
public class Datasource {
    @Bean(name = "qa")
    @ConfigurationProperties(prefix = "spring.datasource.qa")
    public DataSource qaDatasource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;

    }

    @Bean(name = "qaSqlSessionFactory")
    public SqlSessionFactory qaSqlSessionFactory(@Qualifier("qa") DataSource dataSource)throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "qaDataSourceTransactionManager")
    public DataSourceTransactionManager qaDataSourceTransactionManager(@Qualifier("qa") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "qaSqlSessionTemplate")
    public SqlSessionTemplate qaSqlSessionTemplate(@Qualifier("qaSqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
