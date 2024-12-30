package edu.tute.mapper;

import edu.tute.pojo.Order;
import edu.tute.pojo.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepairMapper {


    void repairAssignment(Repair repair);

    String getRoleType(Integer userId);

    List<Order> getAllRepairAssignment();

    List<Order> getRepairAssignment(Integer userId);

    void updateRepairStatus(@Param("assignmentId") Integer assignmentId,@Param("repair") Repair repair);
}
