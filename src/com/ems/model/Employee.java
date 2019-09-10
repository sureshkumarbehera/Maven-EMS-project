package com.ems.model;

import java.time.*;


public class Employee {
	
	 String empid;
	  String empname;
	  LocalDate dob;
	  float basicSalary;
	  
   public Employee(String empid,String empname,LocalDate dob,float basicSalary)
   {
	   this.empid=empid;
	   this.empname=empname;
	   this.dob=dob;
	   this.basicSalary=basicSalary;
   }

public Employee() {
	
}

public void setEmpid(String empid) {
	this.empid = empid;
}

public void setEmpname(String empname) {
	this.empname = empname;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public void setBasicSalary(float basicSalary) {
	this.basicSalary = basicSalary;
}

public String getEmpid() {
	return empid;
}

public String getEmpname() {
	return empname;
}

public LocalDate getDob() {
	return dob;
}

public float getBasicSalary() {
	return basicSalary;
}
	
}
