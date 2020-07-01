package com.ihrm.pay.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.pay.Flow;
import com.ihrm.pay.dao.FlowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {
    @Autowired
    private FlowDao flowDao;
    @Autowired
    private IdWorker idWorker;

    public void save(Flow flow) {
        flowDao.save(flow);
    }
    public Flow findById(String id) {
        return   flowDao.findById(id).get();
    }
    public List<Flow> findAll() {
        return flowDao.findAll();
    }
}