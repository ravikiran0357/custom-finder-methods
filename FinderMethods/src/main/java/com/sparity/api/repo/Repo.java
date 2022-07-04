package com.sparity.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sparity.api.Entity.Employee;


@Repository
public interface Repo extends JpaRepository<Employee, Integer> 
{
	//Select * from Employee where id=101 ;
	public Employee findByid(Integer id);
	//select * from Employee where userName = 'RAVI';
	public List<Employee> findByuserName(String name);// can be done by using findByUserNameIs, findByUserNameEquals 
	//select * from Employee where userName = 'RAVI' and id=101;
	public Employee findByUserNameAndId(String name,Integer id);
	//select * from Employee where userName='RAVI' or id=104;
	public List<Employee> findByUserNameOrId(String name,Integer id);
	//select * from Employee where userName In('RAVI','sidhu');
	public List<Employee> findByUserNameIn(List<String> name);
	//select * from Employee where Id Between 102 and 104;
	//for Between operator we should use individual parameters
	public List<Employee> findByIdBetween(Integer id1,Integer id2);
	
	//select Distinct from Employee;
	public List<Employee> findDistinctBy();
	//select Distinct UserName from Employee  where userName='RAVI';
	public List<Employee> findDistinctByUserName(String Name);
	//select Distinct Address from Employee WHERE Address="Madhapur";
	public List<Employee> findDistinctByAddress(String Address);
	
	//select * from Employee where id<103;
	public List<Employee> findByIdLessThan(Integer id); //findByIdBefore      Id<
	//select * from Employee where id<=103;
	public List<Employee> findByIdLessThanEqual(Integer id);
	//select * from Employee where id>103;
	public List<Employee> findByIdGreaterThan(Integer id);  //findByIdAfter    Id>
	//select * from Employee where id>=103;
	public List<Employee>  findByIdGreaterThanEqual(Integer id);
	//select * from Employee where id is null;
	public List<Employee> findByIdIsNull();
	//select * from Employee where id is not null;
	public List<Employee> findByIdIsNotNull();
	//select * from Employee where UserName Like 'R%';
	public List<Employee> findByUserNameLike(String NAME);
	//select * from Employee where UserName not Like'R%';
	public List<Employee> findByUserNameNotLike(String Name);
	//select * from Empoyee where Address Like'M%';
	public List<Employee> findByAddressStartingWith(String Address); //by default it insert %
	//select * from Employee where Address Like'%R';
	public List<Employee> findByAddressEndingWith(String Address);//by default it insert %
	//Select * from Employee Where Address Like'%R%';
	public List<Employee> findByAddressContaining(String Name);
	//select * from Employee  order by id ASC;
	public List<Employee> findAllByOrderByIdAsc();
	//select * from Employee order by  id Desc Fetch first 2 rows only
	public List<Employee> findTop2ByOrderByIdDesc();
	//select * from Employee  where UserName 

}
