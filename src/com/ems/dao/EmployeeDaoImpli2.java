package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ems.model.Employee;
@Component
public class EmployeeDaoImpli2 implements EmployeeDao2 {
	
	@Autowired
	Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet res=null;
	
	
	public boolean validateEmployee(Employee emp) throws Exception {
		return false;
		
	}


	@Override
	public boolean save(Employee emp) throws Exception{
 		//con =getConnection();
	    pstmt=con.prepareStatement("insert into Employee values(?,?,?,?)");
		pstmt.setString(1,emp.getEmpid());
		pstmt.setString(2,emp.getEmpname());
		LocalDate dobRaw=emp.getDob();
		//String strDate=dobRaw.getYear()+"-"+dobRaw.getMonthValue()+"-"+dobRaw.getDayOfMonth();
		pstmt.setDate(3,new java.sql.Date(dobRaw.getYear(),dobRaw.getMonthValue(),dobRaw.getDayOfMonth()));
		pstmt.setFloat(4,emp.getBasicSalary());		
		
		int r=pstmt.executeUpdate();
		System.out.println("Insert sucessfully......");
		return r>0?true:false;

	}

	@Override
	public boolean delete(String empId) throws Exception {
       //con=getConnection();
       pstmt=con.prepareStatement("delete from Employee where empid=?");
       pstmt.setString(1, empId);
		return pstmt.executeUpdate()>0?true:false;
	}

	@Override
	public boolean update(Employee emp) throws Exception{
		
		//con=getConnection();
		pstmt=con.prepareStatement("update Employee set empname=?, dob=?,salary=?, where empid=?");
		pstmt.setString(1, emp.getEmpname());
		LocalDate dobRaw=emp.getDob();
		pstmt.setDate(2,new java.sql.Date(dobRaw.getYear(),dobRaw.getMonthValue(),dobRaw.getDayOfMonth()));
		pstmt.setFloat(3, emp.getBasicSalary());
		pstmt.setString(4, emp.getEmpid());
		return pstmt.executeUpdate()>0?true:false;
	}

	@Override
	public Employee getEmployee(String empId) throws Exception {
		//con=getConnection();
		pstmt=con.prepareStatement("select * from Employee  where empid=?");
		pstmt.setString(1,empId);
		res=pstmt.executeQuery();
		if(res.next())
		{
			java.sql.Date rawDate=res.getDate(3);
			Employee emp=new Employee(res.getString(1),res.getString(2),LocalDate.of(rawDate.getYear(),rawDate.getMonth(),rawDate.getDate()),res.getFloat(4));
			return emp;
		}
		
		return null;
	}


//	@Override
//	public Connection getConnection() throws Exception {
//		
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sakhadb","suresh","Suresh@6123");
//		
//		return null;
//	}


	@Override
	public List<Employee> display() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Employee> getAllEmployee() throws Exception {
		
		
		//con=getConnection();
		pstmt=con.prepareStatement("select * from Employee ");
		List<Employee> empList=new ArrayList<>();
		res=pstmt.executeQuery();
		while(res.next())
		{
			java.sql.Date rawDate=res.getDate(3);
			Employee emp=new Employee(res.getString(1),res.getString(2),LocalDate.of(rawDate.getYear(),rawDate.getMonth(),rawDate.getDate()),res.getFloat(4));
			empList.add(emp);
		}
		
		
		
		return empList;
	}


	@Override
	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	

}
