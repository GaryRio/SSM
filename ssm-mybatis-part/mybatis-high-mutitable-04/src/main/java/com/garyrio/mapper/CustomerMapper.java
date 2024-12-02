package com.garyrio.mapper;

import com.garyrio.pojo.Customer;
import com.garyrio.pojo.Order;

import java.util.List;

public interface CustomerMapper {
    List<Customer> queryList();
}
