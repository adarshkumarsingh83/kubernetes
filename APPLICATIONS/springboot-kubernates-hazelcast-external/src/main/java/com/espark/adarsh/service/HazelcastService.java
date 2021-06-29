package com.espark.adarsh.service;

import com.espark.adarsh.bean.HazelCastBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class HazelcastService {

    @Autowired
    private Map<String, HazelCastBean> instanceMap;

    public String save(HazelCastBean bean) {
        log.info("label=HazelcastService save()");
        instanceMap.put(bean.getKey(), bean);
        return "DATA SAVED IN HAZELCAST";
    }

    public Object get(String key) {
        log.info("label=HazelcastService get() key={}",key);
        return instanceMap.get(key);
    }

    public Object delete(String key) {
        log.info("label=HazelcastService delete() key={}",key);
        return instanceMap.remove(key);
    }
}
