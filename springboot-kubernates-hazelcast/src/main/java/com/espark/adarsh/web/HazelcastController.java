package com.espark.adarsh.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.espark.adarsh.entity.HazelcastEntity;
import org.springframework.web.bind.annotation.*;
import com.espark.adarsh.service.HazelcastService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RestController
@RequestMapping("/api/hazelcast")
public class HazelcastController {

    @Autowired
    HazelcastService hazelcastService;

    @GetMapping("/{key}")
    public HazelcastEntity getData(@PathVariable("key") String key) {
        log.info("label=HazelcastController getData()");
        return this.hazelcastService.getData(key);
    }

    @GetMapping
    public List<HazelcastEntity> getDataAll() {
        log.info("label=HazelcastController getDataAll()");
        return this.hazelcastService.getDataAll();
    }

    @DeleteMapping("/{key}")
    public HazelcastEntity deleteData(@PathVariable("key") String key) {
        log.info("label=HazelcastController deleteData()");
        return this.hazelcastService.deleteData(key);
    }

    @PutMapping
    public HazelcastEntity updateData(@RequestBody HazelcastEntity entity) {
        log.info("label=HazelcastController updateData()");
        return this.hazelcastService.updateData(entity);
    }

    @PostMapping
    public HazelcastEntity createData(@RequestBody HazelcastEntity entity) {
        log.info("label=HazelcastController createData()");
        return this.hazelcastService.createData(entity);
    }


}
