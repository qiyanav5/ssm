package com.example.ssm.service;

import com.example.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer id);

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer emp_id);

    PageInfo<Employee> getEmployeePage(Integer pageNumber);
}
