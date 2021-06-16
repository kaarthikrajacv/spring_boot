package com.hello.world.demo;


import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@SpringBootApplication
@EnableTransactionManagement
@PropertySource({"classpath:persistence-mysql.properties"})
public class DemoApplication {
	
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	private Properties getHibernateProperties() {
		 
		 Properties props = new Properties();
		 props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		 props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		 return props;
	}
	
	@Bean
	//@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource datasource){
		System.out.println("The data source in Session factory method is " + datasource.hashCode());
	 // create session factorys
		 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		 // set the properties
		 sessionFactory.setDataSource(datasource);
		 sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		 sessionFactory.setHibernateProperties(getHibernateProperties());
		 return sessionFactory;
	}
	
	
	@Bean
	public DataSource myDataSource() {
		 // create connection pool
		 ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		 // set the jdbc driver
		 try {
			 myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		 }
		 catch (PropertyVetoException exc) {
			 throw new RuntimeException(exc);
		 }
		 
		 // set database connection props
			myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			myDataSource.setUser(env.getProperty("jdbc.user"));
			myDataSource.setPassword(env.getProperty("jdbc.password"));
		 // set connection pool props
			myDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
			myDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
			myDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
			myDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
			
			System.out.println("The data source in actual method is " + myDataSource.hashCode());
		 return myDataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

	 // setup transaction manager based on session factory
		
	 HibernateTransactionManager txManager = new HibernateTransactionManager();
	 txManager.setSessionFactory(sessionFactory);
	 return txManager;
	}

}
