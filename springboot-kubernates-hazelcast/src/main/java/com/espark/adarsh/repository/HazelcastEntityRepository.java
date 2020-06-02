package com.espark.adarsh.repository;

import com.espark.adarsh.entity.HazelcastEntity;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

public interface HazelcastEntityRepository extends HazelcastRepository<HazelcastEntity,Long> {

    HazelcastEntity findByKey(String key);

}
