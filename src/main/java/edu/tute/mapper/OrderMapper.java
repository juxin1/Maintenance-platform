package edu.tute.mapper;

import edu.tute.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void createOrder(Order order);

    Order getOrder(Integer orderId);

    void updateOrder(Order order);
}
