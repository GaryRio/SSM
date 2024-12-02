package com.garyrio.mapper;

import com.garyrio.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    //根据姓名、工资查询
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);
    //批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);
    int update(Employee employee);

}
