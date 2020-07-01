package com.ihrm.pay.dao;


import com.ihrm.domain.pay.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlowDao extends JpaRepository<Flow, String>, JpaSpecificationExecutor<Flow> {
}
