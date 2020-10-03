package ar.com.ifts.app.service;

import java.util.List;

import ar.com.ifts.app.model.Employee;

/**
 * 
 * @author Alex
 *
 */
public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(Long id);
}
