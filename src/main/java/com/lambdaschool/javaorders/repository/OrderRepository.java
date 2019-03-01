package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
