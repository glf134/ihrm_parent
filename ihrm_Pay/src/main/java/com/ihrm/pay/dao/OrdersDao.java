package com.ihrm.pay.dao;


import com.ihrm.domain.pay.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrdersDao extends JpaRepository<Orders, String>, JpaSpecificationExecutor<Orders> {
}
