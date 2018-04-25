/**
 * 
 */
package com.maple.it.core.dao;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

/**
 * @author murali
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan({ "com.maple.it.core.dao" })
@PropertySource(value = { "classpath:application.properties" })
public class JndiDataSourceConfig {
	
	@Autowired
	Environment environment;
	
	/**
	 *  Default constructor
	 */
	public JndiDataSourceConfig() {
		
	}
	
	@Bean
	public AbstractPlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	
	@Bean
    public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		factoryBean.setJpaProperties(hibernateProperties());
		return factoryBean.getObject();
	}
	
	private Properties hibernateProperties() {
		final Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		
		return jpaProperties;
	}
	
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		DataSource dataSource = dataSourceLookup.getDataSource("jds/myBank");
		return dataSource;
	}
	
}
