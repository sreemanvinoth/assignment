package com.te.bootwithstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.bootwithstream.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
