package com.parv.izdoo.conf;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.parv.izdoo")
/*@EnableAspectJAutoProxy*/
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@10.96.177.169:1521:xe");
		ds.setUsername("parv");
		ds.setPassword("parv123");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(getDataSource());

		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		//props.put("hibernate.default_schema", "parv");

		sessionFactory.setHibernateProperties(props);
		sessionFactory.setPackagesToScan("com.parv.izdoo.entities");

		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;

	}

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE")
					.allowedHeaders("Access-Control-Allow-Origin", "Origin",
							"X-Requested-With", "Content-Type", "Accept");
			}
		};
	}
}
