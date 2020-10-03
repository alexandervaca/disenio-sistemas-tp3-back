package ar.com.ifts.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.model.Employee;

@RestController
@RequestMapping(path = "/tp3")
public class TestController {

	@RequestMapping(path = "/test")
	public Employee getTest() {
		Employee employee = new Employee();
		employee.setFirstname("Alex");
		employee.setLastname("Vaca");
		employee.setEmail("alex@mail2.com");
		return employee;
	}

}
