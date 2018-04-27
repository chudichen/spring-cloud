package com.test.order.dao;

import com.test.order.databoject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chudichen
 * @date 2018/4/15
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
