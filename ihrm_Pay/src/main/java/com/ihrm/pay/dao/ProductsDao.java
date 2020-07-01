package com.ihrm.pay.dao;


import com.ihrm.domain.pay.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsDao extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
