package com.ems.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ems.dao.EmployeeDaoImpli2;
import com.ems.service.EmployeeServiceImpli;

@Configuration
@ComponentScan({"com.ems"})
public class EmsConfig {

	
	@Bean
	public Connection getConnection() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sakhadb","suresh","Suresh@6123");
		return con;
	}
	@Bean
	public BufferedReader getBufferReaderBean()
	{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		return in;
	}
	
	
}
