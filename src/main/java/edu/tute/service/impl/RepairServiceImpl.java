package edu.tute.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.tute.mapper.RepairMapper;
import edu.tute.pojo.Order;
import edu.tute.pojo.PageResult;
import edu.tute.pojo.QueryParam;
import edu.tute.pojo.Repair;
import edu.tute.service.RepairService;
import edu.tute.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;


    @Override
    public void repairAssignment(Repair repair) {
        repair.setStatus("in_progress");
        repair.setAssignmentDate(LocalDateTime.now());
        repairMapper.repairAssignment(repair);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PageResult<Order> getRepairAssignment(QueryParam queryParam) {
        // 启动分页
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        Integer userId = CurrentHolder.getCurrentId();
        String roleType = repairMapper.getRoleType(userId);
        List<Order> orders;
        if ("admin".equals(roleType)) {
            orders = repairMapper.getAllRepairAssignment();
        } else if ("engineer".equals(roleType)) {
            orders = repairMapper.getRepairAssignment(userId);
        } else {
            return null;
        }
        // 获取分页信息
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        // 返回分页结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void updateRepairStatus(Integer assignmentId, Repair repair) {
        repairMapper.updateRepairStatus(assignmentId, repair);
    }
}
