package ar.com.ifts.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.model.Employee;
import ar.com.ifts.app.repository.EmployeeRepository;

/**
 * 
 * @author Alex
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.getOne(id);
	}
}
