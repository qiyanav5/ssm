package com.example.ssm.mapper;

import com.example.ssm.pojo.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    void insertEmployee(@PathVariable("employee") Employee employee);

    Employee getEmployeeById(@PathVariable("emp_id") Integer id);

    void updateEmployee(@PathVariable("employee_update") Employee employee);

    void deleteEmployee(@PathVariable("emp_id") Integer emp_id);
}
