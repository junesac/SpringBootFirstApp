package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	// @Bean(name = "dataSource")
	// public DriverManagerDataSource dataSource() {
	// DriverManagerDataSource driverManagerDataSource = new
	// DriverManagerDataSource();
	// driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	// driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
	// driverManagerDataSource.setUsername("root");
	// driverManagerDataSource.setPassword("password");
	// return driverManagerDataSource;
	// }

}
