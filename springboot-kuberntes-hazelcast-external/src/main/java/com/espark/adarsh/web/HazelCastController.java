package com.espark.adarsh.web;

import com.espark.adarsh.bean.HazelCastBean;
import com.espark.adarsh.service.HazelcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HazelCastController {

    @Autowired
    HazelcastService hazelcastService;


    @GetMapping("/read/{key}")
    public Object read(@PathVariable("key") String key) {
        return this.hazelcastService.get(key);
    }

    @DeleteMapping("/read/{key}")
    public Object delete(@PathVariable("key") String key) {
        return this.hazelcastService.delete(key);
    }

    @PostMapping("/write")
    public String write(@RequestBody HazelCastBean hazelCastBean) {
        return this.hazelcastService.save(hazelCastBean);
    }


}
