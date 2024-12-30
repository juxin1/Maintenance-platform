package edu.tute.service.impl;

import edu.tute.mapper.OrderMapper;
import edu.tute.pojo.Order;
import edu.tute.service.OrderService;
import edu.tute.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        order.setUserId(CurrentHolder.getCurrentId());
        orderMapper.createOrder(order);
    }

    @Override
    public Order getOrder(Integer orderId) {
        return orderMapper.getOrder(orderId);
    }

    @Override
    public void updateOrder(Integer orderId, Order order) {
        order.setOrderId(orderId);
        orderMapper.updateOrder(order);
    }
}
