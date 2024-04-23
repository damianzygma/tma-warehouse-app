package com.damianzygma.tmawarehouseapp.repository;

import com.damianzygma.tmawarehouseapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByEmail(String email);

}
