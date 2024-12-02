package com.garyrio.test;

import com.garyrio.mapper.EmployeeMapper;
import com.garyrio.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.lang.model.SourceVersion;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void init() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sessionFactory.openSession(true);
    }

    @Test
    public void test_if_where() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.query(null, 200.0);
        System.out.println("employees = " + employees);
    }

    @Test
    public void test_foreach() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        //TODO: 不能将两条查询装到一个分页区
        PageHelper.startPage(1, 2);
        List<Employee> employees = mapper.queryBatch(ids);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        //pageInfo获取数据
        //当前页的数据
        List<Employee> list = pageInfo.getList();
        System.out.println("list = " + list);
        //总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        //总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        //页号
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        //页大小
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);

    }


}
