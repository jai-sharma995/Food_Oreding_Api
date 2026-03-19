package com.ar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ar.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
