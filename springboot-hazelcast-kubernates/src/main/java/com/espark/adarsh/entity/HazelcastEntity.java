package com.espark.adarsh.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HazelcastEntity implements Serializable {

    @Id
    private Long id;


    @EqualsAndHashCode.Exclude
    private String key;

    @EqualsAndHashCode.Exclude
    private Object value;


}
