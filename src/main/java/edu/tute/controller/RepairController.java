package edu.tute.controller;

import edu.tute.pojo.*;
import edu.tute.service.RepairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/repair_assignments")
public class RepairController {

    @Autowired
    private RepairService repairService;

    /*
     * 维修任务抢单(维修师)
     * */
    @PostMapping()
    public Result repairAssignment(@RequestBody Repair repair) {
        log.info("维修任务抢单，订单ID为：{}", repair);
        repairService.repairAssignment(repair);
        return Result.success();
    }

    /*
     * 查询维修任务详情(维修师已接受的订单)（管理员）(分页)
     * */
    @GetMapping()
    public Result getRepairAssignment(QueryParam queryParam) {
        log.info("获取维修任务列表");
        PageResult<Order> pageResult = repairService.getRepairAssignment(queryParam);
        if (pageResult == null) {
            return Result.error("无权限");
        } else {
            return Result.success(pageResult);
        }
    }

    /*
     * 更新维修任务状态（维修师和管理员）
     * */
    @PutMapping("/{assignmentId}")
    public Result updateRepairStatus(@PathVariable Integer assignmentId, @RequestBody Repair repair){
        log.info("更新维修任务状态，任务ID为：{}，任务状态为：{}", assignmentId, repair.getStatus());
        repairService.updateRepairStatus(assignmentId, repair);
        return Result.success();
    }
}
