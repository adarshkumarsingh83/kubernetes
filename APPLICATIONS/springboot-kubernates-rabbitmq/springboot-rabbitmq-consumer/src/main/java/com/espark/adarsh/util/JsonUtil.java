package com.espark.adarsh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class JsonUtil {

    private static ObjectMapper objectMapper=new ObjectMapper();

    public  Map getData(String data) throws IOException {
        return objectMapper.readValue(data,Map.class);
    }

    public  String getData(Map map) throws JsonProcessingException {
        return objectMapper.writeValueAsString(map);
    }
}
