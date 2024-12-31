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
public class Repair {
    private Integer assignmentId;   // 维修任务id
    private Integer orderId;    // 订单id
    private Integer userId; // 维修人员id
    private String status;  // 维修任务状态
    private LocalDateTime assignmentDate;   // 维修任务日期
    private LocalDate expectedCompletionDate;   // 预期完成时间
}
