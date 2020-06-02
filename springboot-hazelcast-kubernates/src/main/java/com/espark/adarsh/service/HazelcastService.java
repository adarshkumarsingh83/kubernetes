package com.espark.adarsh.service;

import com.espark.adarsh.entity.HazelcastEntity;
import com.espark.adarsh.repository.HazelcastEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class HazelcastService {

    @Autowired
    HazelcastEntityRepository hazelcastEntityRepository;

    public HazelcastEntity getData(String key) {
        log.info("label=HazelcastService getData()");
        return this.hazelcastEntityRepository.findByKey(key);
    }


    public List<HazelcastEntity> getDataAll() {
        log.info("label=HazelcastService getDataAll()");
        List<HazelcastEntity> list = new LinkedList<>();
        this.hazelcastEntityRepository.findAll().forEach(data -> list.add(data));
        return list;
    }


    public HazelcastEntity deleteData(String key) {
        log.info("label=HazelcastService deleteData()");
        HazelcastEntity hazelcastEntity = this.hazelcastEntityRepository.findByKey(key);
        this.hazelcastEntityRepository.deleteById(hazelcastEntity.getId());
        return hazelcastEntity;
    }

    public HazelcastEntity updateData(HazelcastEntity entity) {
        log.info("label=HazelcastService updateData()");
        HazelcastEntity hazelcastEntity = this.hazelcastEntityRepository.findByKey(entity.getKey());
        hazelcastEntity = this.hazelcastEntityRepository.save(hazelcastEntity);
        return hazelcastEntity;
    }

    public HazelcastEntity createData(HazelcastEntity entity) {
        log.info("label=HazelcastService createData()");
        HazelcastEntity hazelcastEntity = this.hazelcastEntityRepository.save(entity);
        return hazelcastEntity;
    }
}
