package com.espark.adarsh.config;

import com.espark.adarsh.bean.HazelCastBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.ByteArraySerializer;

import java.io.IOException;
import java.io.InputStream;

public class HazelCastBeanSerializer implements ByteArraySerializer<HazelCastBean> {

    ObjectMapper mapper = new ObjectMapper();

    public int getTypeId() {
        return 5;
    }

    public void write(ObjectDataOutput out, HazelCastBean object)
            throws IOException {
        byte[] data = mapper.writeValueAsBytes(object);
        System.out.println("Size is " + data.length);
        out.write(data);
    }

    public HazelCastBean read(ObjectDataInput in) throws IOException {
        return mapper.readValue((InputStream) in,
                HazelCastBean.class);
    }

    public void destroy() {
    }

    @Override
    public byte[] write(HazelCastBean employee) throws IOException {
        return mapper.writeValueAsBytes(employee);
    }

    @Override
    public HazelCastBean read(byte[] bytes) throws IOException {
        return mapper.readValue(bytes, HazelCastBean.class);
    }
}