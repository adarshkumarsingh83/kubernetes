package com.espark.adarsh.repository;

import com.espark.adarsh.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageEntityRepository extends CrudRepository<MessageEntity,Long> {
}