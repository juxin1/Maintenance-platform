package edu.tute.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;    // 订单id
    private Integer userId; // 用户id
    private String productModel;    // 产品型号
    private String faultDescription;    // 故障描述
    private String customerPhone;   // 客户联系方式
    private String status;  // 订单状态
    private double actualCost; // 实际花费
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime repairOrderDate;   // 报修时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeDate; // 完成时间

}
