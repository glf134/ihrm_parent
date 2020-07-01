package com.ihrm.pay.service;

import com.ihrm.common.payUtils.OrderStatusEnum;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.pay.Flow;
import com.ihrm.domain.pay.Orders;
import com.ihrm.pay.dao.FlowDao;
import com.ihrm.pay.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private FlowDao flowDao;
    @Autowired
    private IdWorker  idWorker;

    public void save(Orders flow) {
        ordersDao.save(flow);
    }
    public void update(Orders flow) {
        // flow.setId(idWorker.nextId());
        ordersDao.saveAndFlush(flow);
    }
    public Orders findById(String id) {
        return   ordersDao.findById(id).get();
    }
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }
    public void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount) {
        Orders order = findById(orderId);
        if (order.getOrderStatus().equals(OrderStatusEnum.WAIT_PAY.key)) {
            order = new Orders();
            order.setId(orderId);
            order.setOrderStatus(OrderStatusEnum.PAID.key);
            order.setPaidTime(new Date());
            order.setPaidAmount(paidAmount);

            update(order);

            order = findById(orderId);

            String flowId =  UUID.randomUUID().toString().replaceAll("-","");
            Flow flow = new Flow();
            flow.setId(flowId);
            flow.setFlowNum(alpayFlowNum);
            flow.setBuyCounts(order.getBuyCounts());
            flow.setCreateTime(new Date());
            flow.setOrderNum(orderId);
            flow.setPaidAmount(paidAmount);
            flow.setPaidMethod(1);
            flow.setProductId(order.getProductId());

            flowDao.save(flow);
        }
    }
}
