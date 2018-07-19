package com.agesun.mybatis.dao;

import java.util.List;

import com.agesun.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps(); 
	
	//批量保存员工
	public Long addEmp(Employee employee);

}
