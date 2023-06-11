package com.backend.repository;

import com.backend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value="select * from bill where account_id = :id", nativeQuery = true)
    List<Order> getOrderByIdUser(Long id);
}