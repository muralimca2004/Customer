/**
 *  http://forum.spring.io/forum/spring-projects/container/724356-how-to-use-javaconfig-to-declare-a-jndi-datasource
 */
package com.maple.it.core.dao;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
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
	
	private Logger log = Logger.getLogger(JndiDataSourceConfig.class);
			
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
		log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setPackagesToScan("com.maple.it.core.model");
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
	
	private Properties hibernateProperties() {
		log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		final Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		
		return jpaProperties;
	}
	
	@Bean
	public DataSource dataSource() {
		log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		DataSource dataSource = dataSourceLookup.getDataSource("jdbc/mybank");
		
		return dataSource;
	}
	
}
