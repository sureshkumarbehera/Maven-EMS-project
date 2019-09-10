package com.ems.dao;

import java.sql.Connection;
import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDao2 {

	//public boolean validateEmployee(Employee emp)  throws Exception ;
	public Connection getConnection() throws Exception;
	//public  String  genearateId(String empName);
	public boolean  save(Employee emp) throws Exception;
	public  boolean  delete (String empId) throws Exception;
	public  boolean update (Employee emp) throws Exception;
	public Employee  getEmployee( String empId) throws Exception;
	public  List<Employee> display()throws Exception;
	public List<Employee> getAllEmployee() throws Exception;
}
