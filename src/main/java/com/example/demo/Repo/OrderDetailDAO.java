package com.example.demo.Repo;


import com.example.demo.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}