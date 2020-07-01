package com.ihrm.pay.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.pay.Orders;
import com.ihrm.domain.pay.Product;
import com.ihrm.pay.dao.ProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductsDao productsDao;

  //  @Autowired
  //  private IdWorker idWorker;


    public void save(Product flow) {
        flow.setId(UUID.randomUUID().toString().replaceAll("-",""));
        productsDao.save(flow);
    }
    public Product findById(String id) {
        return  productsDao.findById(id).get();
    }
    public List<Product> findAll() {
        return productsDao.findAll();
    }
}
