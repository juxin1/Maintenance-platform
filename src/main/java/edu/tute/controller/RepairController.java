package edu.tute.controller;

import edu.tute.pojo.Result;
import edu.tute.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/repair_assignments")
public class RepairController {

    @Autowired
    private RepairService repairService;

    /*
    * 维修任务抢单(维修师)
    * */

}
