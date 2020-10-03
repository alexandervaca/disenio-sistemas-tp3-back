package ar.com.ifts.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.Employee;

/**
 * 
 * @author Alex
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
