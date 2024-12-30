package edu.tute.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repair {
    private Integer assignmentId;   // 维修任务id
    private Integer orderId;    // 订单id
    private Integer userId; // 维修人员id
    private String status;  // 维修任务状态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate assignmentDate;   // 维修任务日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate expectedCompletionDate;   // 预期完成时间
}
