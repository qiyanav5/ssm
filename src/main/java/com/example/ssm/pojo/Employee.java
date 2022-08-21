package com.example.ssm.pojo;

public class Employee {
    private Integer emp_id;
    private String emp_name;
    private Integer age;
    private String sex;
    private String email;

    public Employee(Integer emp_id, String emp_name, Integer age, String sex, String email) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Employee() {
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
