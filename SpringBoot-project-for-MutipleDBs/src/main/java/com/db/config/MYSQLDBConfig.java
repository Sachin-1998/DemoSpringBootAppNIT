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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.db.repo.prod", entityManagerFactoryRef = "mysqlEMF", transactionManagerRef = "mysqlTxManager")
public class MYSQLDBConfig {
	@Bean(name = "mysqlDs")
	@ConfigurationProperties(prefix = "mysql.datasource")
	@Primary
	public DataSource createMysqlDs() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createMysqlLocaContainerEntityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {
		// create map object having hibernate properties
		Map<String, Object> props = new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");

		// create and return LocalContainerEntityManagerFactoryBean class object which
		// makes entityManagerFactory as spring bean.

		return builder.dataSource(createMysqlDs()).packages("com.db.model.prod").properties(props).build();

	}

	@Bean(name = "mysqlTxManager")
	@Primary
	public JpaTransactionManager createMysqlTxManager(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
