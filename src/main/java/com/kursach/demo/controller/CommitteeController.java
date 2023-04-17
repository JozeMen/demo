package com.kursach.demo.controller;

import com.kursach.demo.dto.CommitteeDTO;
import com.kursach.demo.service.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/committee")
public class CommitteeController {
    @Autowired
    private CommitteeService committeeService;

    @GetMapping
    public List<CommitteeDTO> showAllCCommittee() {
        return committeeService.showAllCCommittee();
    }

    @GetMapping("/{name}")
    public CommitteeDTO showCommitteeByName(@PathVariable String name) {
        return committeeService.showCommitteeByName(name);
    }
    @PostMapping
    public CommitteeDTO createCommittee(@RequestBody CommitteeDTO committeeDTO){
        return committeeService.createCommittee(committeeDTO);
    }
    @DeleteMapping("/{name}")
    public int deleteCommittee(@PathVariable String name) {
       return committeeService.deleteCommitteeByName(name);
    }
    @PutMapping("/{name}")
    public CommitteeDTO editCommittee(@PathVariable String name, @RequestBody CommitteeDTO committeeDTO) {
        return committeeService.editCommittee(name, committeeDTO);
    }
}
