package com.db.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.db.repo.promotions",entityManagerFactoryRef = "postgresqlEMF",transactionManagerRef = "postgresqlTxManager")
public class POSTGRESQLConfig 
{
	@Bean(name="postgresqlDs")
	@ConfigurationProperties(prefix = "postgresql.datasource")
	public DataSource createPostgresqlDb()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="postgresqlEMF")
	public LocalContainerEntityManagerFactoryBean createPostgresqlEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
	{
		//create map object for hibernate properties
		Map<String, Object> props=new HashMap();
		//props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		// create and return LocalContainerEntityManagerFactoryBean class object which
		// makes entityManagerFactory as spring bean.
		
		return builder.dataSource(createPostgresqlDb())
				      .packages("com.db.model.promotions")
				      .properties(props)
				      .build();
	}
	@Bean(name="postgresqlTxManager")
	public JpaTransactionManager createPostgresqlTxManager( @Qualifier("postgresqlEMF") EntityManagerFactory factory)
	{
		return new JpaTransactionManager(factory);
	}

}
