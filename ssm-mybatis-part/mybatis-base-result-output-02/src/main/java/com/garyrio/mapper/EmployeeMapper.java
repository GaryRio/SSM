package com.garyrio.mapper;

import com.garyrio.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    int deleteById(Integer id);

    String queryNameById(Integer id);

    Double querySalaryById(Integer id);

    Employee queryById(Integer id);

    Map<String, Object> selectEmpNameAndMaxSalary();

    int insertEmp(Employee employee);
}
