
package com.ems.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ems.Configuration.EmsConfig;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpli;
@Component
public class EmployeeManagementApp {

	@Autowired
		EmployeeService es;
	
	
		public EmployeeService getEs() {
		return es;
	}
	public void setEs(EmployeeService es) {
		this.es = es;
	}
	public BufferedReader getIn() {
		return in;
	}
	public void setIn(BufferedReader in) {
		this.in = in;
	}


		BufferedReader in;
		public EmployeeManagementApp()
		{
			es=new EmployeeServiceImpli();
			in=new BufferedReader(new InputStreamReader(System.in));
		}
		public void addEmployee() throws Exception
		{
			String empName;
			LocalDate dob;
			float sal;
			System.out.println("enter employee details (name,dob(dd-mm-yy),salary");
			empName=in.readLine();
			String strDate=in.readLine();
		    StringTokenizer stk=new StringTokenizer(strDate,"-");
		    int date=Integer.parseInt(stk.nextToken());
		    int month=Integer.parseInt(stk.nextToken());
		    int year=Integer.parseInt(stk.nextToken());
		    dob=LocalDate.of(year, month,date);
		    sal=Float.parseFloat(in.readLine());
		    
		    
		    Employee emp=new Employee();
		    emp.setEmpname(empName);
		    emp.setBasicSalary(sal);
		    emp.setDob(dob);
		    
		    es.save(emp);
			
		}
		
		
		public static void main(String[] args) throws Exception {
			
			ApplicationContext context=new AnnotationConfigApplicationContext(EmsConfig.class);
			EmployeeManagementApp app=new EmployeeManagementApp();
			app.setEs(context.getBean("service", EmployeeService.class));
			app.addEmployee();
			
		}
		

	}


