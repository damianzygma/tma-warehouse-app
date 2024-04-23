package com.damianzygma.tmawarehouseapp.service;

import com.damianzygma.tmawarehouseapp.entity.Employee;

public interface EmployeeService {

    Employee findByEmail(String email);

}
