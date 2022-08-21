package com.example.ssm.controller;

import com.alibaba.druid.stat.TableStat;
import com.example.ssm.pojo.Employee;
import com.example.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    查询所有员工信息-->/employee-->get
    根据id查询员工信息-->/employee/1-->get
    跳转到添加页面-->/to/add-->get
    添加员工信息-->/employee-->post
    修改员工信息-->/employee-->put
    删除员工信息-->/employee/1-->delete
    查询所有员工信息-->/employee-->get


*/
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee/page/{pageNumber}")
    public String getEmployeeByPage(@PathVariable("pageNumber") Integer pageNumber,Model model){
//        获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNumber);
//        将分页数据共享到请求域中
        model.addAttribute("page",page);
//        跳转到employee_list
        return "employee_list";
    }

    /*@GetMapping("/employee")
    public String getAllEmployee(Model model){
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("employees",list);
        return "employee_list";
    }*/

    @PostMapping("/employee/add")
    public String insertEmployee(Employee employee){
        employeeService.insertEmployee(employee);
//        return "redirect:/employee";
        return "redirect:/employee/page/1";
    }

    @RequestMapping("/to/update{emp_id}")
    public String toUpdate(@PathVariable("emp_id") Integer emp_id,Model model){
        Employee employee = employeeService.getEmployeeById(emp_id);
        model.addAttribute("employee_update",employee);
        return "employee_update";
    }

    @PostMapping("/employee/update")
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
//        return "redirect:/employee";
        return "redirect:/employee/page/1";
    }

    @RequestMapping("/to/delete{emp_id}")
    public String toDelete(@PathVariable("emp_id") Integer emp_id,Model model){
        Employee employee = employeeService.getEmployeeById(emp_id);
        model.addAttribute("employee_delete",employee);
        return "employee_delete";
    }

    @PostMapping("/employee/delete")
    public String deleteEmployee(Employee employee){
        Integer emp_id = employee.getEmp_id();
        employeeService.deleteEmployee(emp_id);
//        return "redirect:/employee";
        return "redirect:/employee/page/1";
    }


}
