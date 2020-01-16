package com.example.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.example.spring.dao"), @ComponentScan("com.example.spring.service") })
public class AppConfig {

	private static final Object DRIVER = null;
	private static final Object URL = null;
	private static final Object USER = null;
	private static final Object PASSWORD = null;
	private static final Object SHOW_SQL = null;
	private static final Object HBM2DDL_AUTO = null;
	private static final Object MIN_SIZE = null;
	private static final Object MAX_SIZE = null;
	private static final Object ACQUIRE_INCREMENT = null;
	private static final Object TIMEOUT = null;
	private static final Object MAX_STATEMENT = null;
	
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSession() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties prop = new Properties();
		prop.put(DRIVER, env.getProperty("driverClassName"));
		prop.put(URL, env.getProperty("url"));
		prop.put(USER, env.getProperty("username"));
		prop.put(PASSWORD, env.getProperty("password"));

		prop.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		prop.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		prop.put(MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		prop.put(MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		prop.put(ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		prop.put(TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		prop.put(MAX_STATEMENT, env.getProperty("hibernate.c3p0.max_statement"));

		factoryBean.setHibernateProperties(prop);
		factoryBean.setPackagesToScan("com.example.spring.model");
		return factoryBean;

	}

	@Bean
	public HibernateTransactionManager geTtransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSession().getObject());
		return transactionManager;
	}

}
