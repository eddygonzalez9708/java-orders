package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT o.ordnum, o.advanceamount, o.ordamount, o.orddescription FROM Orders o WHERE o.custcode IN (SELECT c.custcode FROM Customers c WHERE c.custname = :custname)", nativeQuery = true)
    List<Object> findCustomerOrdersByName(@Param("custname") String custname);
}
