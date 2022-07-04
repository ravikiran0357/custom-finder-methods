package com.sparity.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import com.sparity.api.repo.Repo;
import com.sparity.api.repo.Repo1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sparity.api.Entity.Department;
import com.sparity.api.Entity.Employee;
@SpringBootApplication
public class FinderMethodsApplication 
{

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context=SpringApplication.run(FinderMethodsApplication.class, args);
	    Repo p1=(Repo)context.getBean(com.sparity.api.repo.Repo.class);
	    System.out.println(p1.getClass().getName());
	    Employee emp1=new Employee(101,"RAVI","Ecil","Ravi@Gmail.com");
	    Employee emp2=new Employee(102,"sidhu","Madhapur","Sidhu@Gmail.com");
	    Employee emp3=new Employee(103,"prashanthi","Ammerpet","Prashanthi@Gmail.com");
	    Employee emp4=new Employee(104,"RAVI","Madhapur","Pavan@Gmail.com");
	    Employee emp5=new Employee(105,"Vidhya","madhapur","vidhay@gmail.com");
	    
	    List<Employee> emp=Arrays.asList(emp1,emp2,emp3,emp4,emp5);
	    p1.saveAll(emp);
	    //finder
	    Employee empId=p1.findByid(101);
	    System.out.println(empId);
	    List<Employee> empName=p1.findByuserName("RAVI");
	    System.out.println(empName);
	    Employee empUserNameAndId= p1.findByUserNameAndId("RAVI",101);
	    System.out.println(empUserNameAndId);
	    List<Employee> empUserNameOrName = p1.findByUserNameOrId("RAVI", 104);
	    System.out.println(empUserNameOrName);
	    List<Employee>empUserNameIn=p1.findByUserNameIn(Arrays.asList("RAVI","sidhu"));
	    System.out.println(empUserNameIn);
	    List<Employee> empIdBetween = p1.findByIdBetween(102,104);
	    System.out.println(empIdBetween);
	    List<Employee> empDistinct=  p1.findDistinctBy();
	    System.out.println(empDistinct);
	    System.out.println("--------------------------------");
	    
	    List<Employee> empUserNameDistinct=p1.findDistinctByUserName("RAVI");
	    System.out.println(empUserNameDistinct);
	    List<Employee> empAddressDistinct=p1.findDistinctByAddress("Madhapur");
	    System.out.println(empAddressDistinct);
	    
	    List<Employee> empIdLessThan= p1.findByIdLessThan(103);
	    System.out.println(empIdLessThan);
	    List<Employee> empIdLessThanEqual= p1.findByIdLessThanEqual(103);
	    System.out.println(empIdLessThanEqual);
	    List<Employee> empIdGreaterThan= p1.findByIdGreaterThan(103);
	    System.out.println(empIdGreaterThan);
	    List<Employee> empIdGreaterThanEqual= p1.findByIdGreaterThanEqual(103);
	    System.out.println(empIdGreaterThanEqual);
	    List<Employee> empIdIsNull= p1.findByIdIsNull();
	    System.out.println(empIdIsNull);
	    List<Employee> empIdIsNotNull= p1.findByIdIsNotNull();
	    System.out.println(empIdIsNotNull);
	    List<Employee> empUserNameLike=p1.findByUserNameLike("R%");
	    System.out.println(empUserNameLike);
	    List<Employee> empUserNameNotLike=p1.findByUserNameNotLike("R%");
	    System.out.println(empUserNameNotLike);
	    System.out.println("-------------------------------");
	    List<Employee> empAddressLikeStart=p1.findByAddressStartingWith("M");
	    System.out.println(empAddressLikeStart);
	    List<Employee> empAddressLikeEnd=p1.findByAddressEndingWith("R");
	    System.out.println(empAddressLikeEnd);
	    List<Employee> empAddressContains=p1.findByAddressContaining("r");
	    System.out.println(empAddressContains);
	    List<Employee> empOrderByIdAsc= p1.findAllByOrderByIdAsc();
	    System.out.println(empOrderByIdAsc);
	    List<Employee> empOrderByIdDescTop2=p1.findTop2ByOrderByIdDesc();
	    System.out.println(empOrderByIdDescTop2);
	    
	    //-----------------------------------------------------------//
	    
	   
	    Repo1 p2=(Repo1)context.getBean(Repo1.class);
	    Department dept1=new Department(101,"Mechanical","1st Floor Block A","Mechanical@Gmail.com");
	    Department dept2=new Department(102,"Civil","5th Floor Block C","Civil@Gmail.com");
	    Department dept3=new Department(103,"IT","2nd Floor Block B","IT@Gmail.com");
	    Department dept4=new Department(104,"Electronics","2nd Floor Block E","Electronics@Gmail.com");
	    Department dept5=new Department(105,"Electrical","3rd Floor Block D","Electrical@gmail.com");
	    Department dept6=new Department(106,"Mechanical","2nd Floor Block A","Mechanical@Gmail.com");
	    Department dept7=new Department(107,"Civil","3rd Floor Block A","Civil@Gmail.com");
	    Department dept8=new Department(108,"IT","4th Floor Block A","IT@Gmail.com");
	    List<Department> dep= Arrays.asList(dept1,dept2,dept3,dept4,dept5,dept6,dept7,dept8);
	    p2.saveAll(dep);
	    //Custom methods
	    List<Department> depto1=p2.getDepartmentDetails();
	    System.out.println(depto1);
		List<Department> depto2= p2.getDepartment(); 
		System.out.println(depto2);
		List<Integer> depto3=p2.getDepartmentIds(); 
		System.out.println(depto3);
		List<Department> Depto3=p2.getDepartmentId(102); 
		System.out.println(Depto3);
		List<Department> Depto4=p2.getDepartmentid(103);
        System.out.println(Depto4);	
        List<Department> Depto5=p2.getDeptIdAndUserName(101,"Mechanical");
        System.out.println(Depto5);
        List<Department> Depto6=p2.getDeptIdOrUserName(103,"Mechanical");
        System.out.println(Depto6);
        List<Department>Depto7=p2.getDeptIdIn(101, 102);
        System.out.println(Depto7);
	    List<Department> Depto8=p2.getDeptIdAndUserNameIn(101,103,"Mechanical","Civil"); 
	    System.out.println(Depto8);
	    List<Department> Depto9= p2.getDeptIdOrUserNameIn(101, 102, "Mechanical", "Civil");
		System.out.println(Depto9);
	    List<Integer> Depto10=	p2.getDepartmentIdHQL();
	    System.out.println(Depto10);   
	    List<String> Depto11=p2.getDepartmentIdUserName();
	    System.out.println(Depto11);
	    List<String>Depto12=p2.getDepartmentIduserName(101);
	    System.out.println(Depto12);
	    List<String> Depto13=p2.getDepartmentIdUserNameLike("M%");
	    System.err.println(Depto13);
		//p2.deleteDeptId(103);
		//p2.updateId(110,102);
		p2.InsertDeptDetails(113, "4th Floor Block B", "Ag@gmail.com", "Agricultural");
		
	}

}
