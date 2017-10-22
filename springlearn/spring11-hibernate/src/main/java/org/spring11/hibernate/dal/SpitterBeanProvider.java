package org.spring11.hibernate.dal;

import java.util.Properties;

import javax.sql.DataSource;

import org.spring11.hibernate.dal.entity.Spitter;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class SpitterBeanProvider {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/gzwdb01");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		//会扫描JPA的@Entity @MappedSuperClass Hibernate的@Entity
		//sfb.setPackagesToScan(new String[] {"org.spring11.hibernate.dal.entity"});
		//sfb.setAnnotatedPackages(new String[] {"org.spring11.hibernate.dal.entity"});
		//也可以直接指定
		sfb.setAnnotatedClasses(Spitter.class);
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		sfb.setHibernateProperties(prop);
		return sfb;
	}
	
	/**
	 * 将hibernate异常转成spring的各种异常
	 * @return
	 */
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
