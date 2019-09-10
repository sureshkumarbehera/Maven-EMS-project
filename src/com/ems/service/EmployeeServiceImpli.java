package com.ems.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ems.util.*;

import com.ems.dao.EmployeeDao2;
import com.ems.dao.EmployeeDaoImpli2;
import com.ems.model.Employee;
import java.lang.*;
@Component("service")
public class EmployeeServiceImpli implements EmployeeService {
	
	
	@Autowired
	
	EmployeeDao2 dao;
	public EmployeeServiceImpli()
	{
		dao=new EmployeeDaoImpli2();
	}

	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		
		
		String empName=emp.getEmpname();
		LocalDate dob=emp.getDob();
		float salary=emp.getBasicSalary();
		
		
		if(empName.length()<4 || empName.length()>15)
		{
			throw new InvalidNameEXception("Nmane must be in 4-15 characters");
		}
		if(dob.isAfter(LocalDate.of(1995, 12, 31)) ||  dob.isBefore(LocalDate.of(1990, 1, 1)))
		{
			throw new InvalidDobException("Please enter dob in range 01-01-1900  to  31-12-1995");
		}
		
		if(salary>80000 || salary<20000)
		{
			throw new InvalidSalaryException("salary should be in range of 20000 and 80000");
		}
		
		
		return true;
	}

	@Override
	public String genearateId(String empname) {
		
		
		String nameChar=empname.substring(0,2).toUpperCase();
		Random rand =new Random();
		int dgt = (int)rand.nextDouble()*10000;
		
		return nameChar+dgt;
		

		
	}

	@Override
	public boolean save(Employee emp) throws Exception {
		
		if(validateEmployee(emp))
		{
			emp.setEmpid(genearateId(emp.getEmpname()));
			return (dao.save(emp));
		}
		
		return false;
	}

	@Override
	public boolean delete(String empid) throws Exception {
		
		
		
		return( dao.delete(empid));
		// TODO Auto-
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		
		
		if(validateEmployee(emp))
		{
			return dao.update(emp);	
			
		}
		return false;
	
	}

	@Override
	public Employee getEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		
		return (dao.getAllEmployee());
		// TODO Auto
	}

}
