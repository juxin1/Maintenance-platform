package edu.tute.service;

import edu.tute.pojo.Order;

public interface OrderService {

    /*
    * 创建订单
    * */
    void createOrder(Order order);

    /*
    * 查询订单
    * */
    Order getOrder(Integer orderId);

    /*
    *跟新维修进度(维修师，管理员)
    * */
    void updateOrder(Integer orderId, Order order);
}
