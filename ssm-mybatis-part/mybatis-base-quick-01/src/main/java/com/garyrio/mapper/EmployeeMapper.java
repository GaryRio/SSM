package com.garyrio.mapper;

import com.garyrio.pojo.Employee;

public interface EmployeeMapper {

    //查询员工信息
    Employee queryById(Integer id);
}
