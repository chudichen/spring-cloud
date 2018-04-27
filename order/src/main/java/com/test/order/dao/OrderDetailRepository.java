package com.test.order.dao;

import com.test.order.databoject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chudichen
 * @date 2018/4/15
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
