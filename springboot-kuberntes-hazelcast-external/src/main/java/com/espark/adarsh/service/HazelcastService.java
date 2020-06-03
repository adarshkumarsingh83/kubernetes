package com.espark.adarsh.service;

import com.espark.adarsh.bean.HazelCastBean;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HazelcastService {

    @Autowired
    private HazelcastInstance instance;

    public String save(HazelCastBean bean) {
        java.util.Map<String, HazelCastBean> instanceMap = instance.getMap("data-store");
        instanceMap.put(bean.getKey(), bean);
        return "DATA SAVED IN HAZELCAST";
    }

    public Object get(String key) {
        java.util.Map<String, HazelCastBean> instanceMap = instance.getMap("data-store");
        return instanceMap.get(key);
    }

    public Object delete(String key) {
        java.util.Map<String, HazelCastBean> instanceMap = instance.getMap("data-store");
        return instanceMap.remove(key);
    }
}
