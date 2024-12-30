package edu.tute.service;

import edu.tute.pojo.Order;
import edu.tute.pojo.PageResult;
import edu.tute.pojo.QueryParam;
import edu.tute.pojo.Repair;

public interface RepairService {

    /*
    * 维修任务抢单(维修师)
    * */
    void repairAssignment(Repair repair);

    /*
    *查询维修任务详情(维修师已接受的订单)（管理员）
    * */
    PageResult<Order> getRepairAssignment(QueryParam queryParam);

    /*
    * 更新维修任务状态(维修师和管理员)
    * */
    void updateRepairStatus(Integer assignmentId, Repair repair);
}
