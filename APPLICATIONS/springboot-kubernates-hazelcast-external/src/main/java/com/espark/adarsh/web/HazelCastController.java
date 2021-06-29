package com.espark.adarsh.web;

import com.espark.adarsh.bean.HazelCastBean;
import com.espark.adarsh.service.HazelcastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class HazelCastController {

    @Autowired
    HazelcastService hazelcastService;


    @GetMapping("/read/{key}")
    public Object read(@PathVariable("key") String key) {
        log.info("label=HazelCastController read() key={}", key);
        return this.hazelcastService.get(key);
    }

    @DeleteMapping("/read/{key}")
    public Object delete(@PathVariable("key") String key) {
        log.info("label=HazelCastController delete() key={}", key);
        return this.hazelcastService.delete(key);
    }

    @PostMapping("/write")
    public String write(@RequestBody HazelCastBean hazelCastBean) {
        log.info("label=HazelCastController write() hazelCastBean={}", hazelCastBean);
        return this.hazelcastService.save(hazelCastBean);
    }


}
