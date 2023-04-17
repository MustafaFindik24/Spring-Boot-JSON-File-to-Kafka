package com.mustafafindik.jsonfiletokafka.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JsonFileReader {
    @Value("${mustafafindik.json.filepath}")
    String filePath;
    public List<Object> readJsonFile() throws IOException {
        //String filePath = "C:\\Users\\P2343\\Desktop\\file.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> dataList = objectMapper.readValue(new File(filePath), new TypeReference<List<Object>>(){});
        return dataList;
    }
}
