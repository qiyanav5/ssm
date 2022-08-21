package com.example.ssm.service.impl;

import com.example.ssm.mapper.EmployeeMapper;
import com.example.ssm.pojo.Employee;
import com.example.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
       return employeeMapper.getEmployeeById(id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer emp_id) {
        employeeMapper.deleteEmployee(emp_id);
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNumber) {
        //开启分页功能
        PageHelper.startPage(pageNumber,4);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list,5);
        return page;
    }


}
