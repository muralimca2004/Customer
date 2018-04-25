package com.maple.it.core.dao;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.maple.it.core.dao" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	
	@Resource
	private Environment environment;
	
	public HibernateConfiguration() {
		
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		//DriverManagerDataSource datasource = new DriverManagerDataSource("jdbc:mysql://192.168.142.138:3306/mybank", "murali", "admin");
		//datasource.setDriverClassName("com.mysql.jdbc.Driver");
		//sessionFactory.setDataSource(new DriverManagerDataSource("jdbc:mysql://192.168.142.138:3306/mybank", "murali", "admin"));
		//sessionFactory.setDataSource(datasource);
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.maple.it.core.model"} );
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
		
	}
	
	//@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		datasource.setUrl(environment.getRequiredProperty("jdbc.url"));
		datasource.setUsername(environment.getRequiredProperty("jdbc.username"));
		datasource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		/*datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl(environment.getRequiredProperty("jdbc:mysql://192.168.142.138:3306/mybank"));
		datasource.setUsername(environment.getRequiredProperty("murali"));
		datasource.setPassword(environment.getRequiredProperty("admin"));*/
		
		return datasource;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		
		/*properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");*/
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
