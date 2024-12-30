package edu.tute.controller;

import edu.tute.pojo.Order;
import edu.tute.pojo.Result;
import edu.tute.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*
     * 创建订单(用户)
     * */
    @PostMapping
    public Result createOrder(@RequestBody Order order) {
        log.info("创建订单，订单信息为：{}", order);
        orderService.createOrder(order);
        return Result.success();
    }

    /*
     * 查询订单(管理员)
     * */
    @GetMapping("/{orderId}")
    public Result getOrder(@PathVariable("orderId") Integer orderId) {
        log.info("查询订单，订单ID为：{}", orderId);
        Order order = orderService.getOrder(orderId);
        return Result.success(order);
    }

    /*
    * 更新维修进度(管理员和维修师)
    * */
    @PutMapping("/{orderId}")
    public Result updateOrder(@PathVariable("orderId") Integer orderId, @RequestBody Order order) {
        log.info("更新订单，订单ID为：{}，订单信息为：{}", orderId, order);
        orderService.updateOrder(orderId, order);
        return Result.success();
    }
}
