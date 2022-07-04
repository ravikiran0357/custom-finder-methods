package com.sparity.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sparity.api.Entity.Department;

public interface Repo1 extends JpaRepository<Department, Integer> {
	// Custom Queries with SQL & HQL
	@Query(value = "Select * from Department_Details", nativeQuery = true) // SQL
	public List<Department> getDepartmentDetails();
	@Query(value = "From Department")
	public List<Department> getDepartment();//HQL 
	@Query(value = "select p.dept_id from department_details p", nativeQuery =true) 
	public List<Integer> getDepartmentIds();
	@Query(value = "From Department where id= ?1") // HQL 
	public List<Department>getDepartmentId(Integer id);
	// HQL	 
	@Query(value="From Department where id=:id")//HQL
	public List<Department>getDepartmentid(Integer id);
	@Query(value ="From Department where id=:id and userName=:userName")//HQL
    public List<Department> getDeptIdAndUserName(Integer id,String userName);
    @Query(value ="From Department where id=:id or userName=:userName")//HQL
    public List<Department> getDeptIdOrUserName(Integer id,String userName);
	@Query(value="From Department where id In(:id1,:id2)") 
	public List<Department> getDeptIdIn(Integer id1,Integer id2);//List<Integer> HQL
    @Query(value="From Department where id In(?1,?2) And userName In(?3,?4)" )
    public List<Department> getDeptIdAndUserNameIn(Integer id1,Integer id2,String userName1,String userName2);
  	@Query(value="From Department where id In(:id1,:id2) or userName In(:userName1,:userName2)")
  	public List<Department> getDeptIdOrUserNameIn(Integer id1,Integer  id2,String userName1,String userName2);
    @Query(value="select id From Department ")
    public List<Integer> getDepartmentIdHQL();
	@Query(value="select id,userName from Department")
	public List<String> getDepartmentIdUserName();
	@Query(value="select id,userName from Department where id=?1" )
	public List<String> getDepartmentIduserName(Integer id);
	@Query(value="select id,userName from Department where userName Like:userName")
    public List<String> getDepartmentIdUserNameLike(String userName);
	//DML
	@Transactional// The transactional annotation itself defines the scope of a single database transaction. The database transaction happens inside the scope of apersistence context.
	@Modifying // is used to enhance the @Query annotation so that we can execute not only SELECT queries, but also INSERT, UPDATE, DELETE, and even DDL queries.
	@Query(value="delete from Department where id=:id1")
	public void deleteDeptId(Integer id1);
	@Transactional
	@Modifying
	@Query(value="update Department set id=:id1 where id=:id2")
	public void updateId(Integer id1,Integer id2);
	@Transactional  
	@Modifying  
	@Query(value="insert into department_details(dept_id,dept_address,dept_mail,dept_name) values(:id1,:address,:mail,:name)",nativeQuery = true) 
	public void InsertDeptDetails(Integer id1,String address,String mail,String  name);
	
	 
}
