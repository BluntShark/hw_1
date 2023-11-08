package com.thewhite.study.files;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thewhite.study.model.ResourceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class UploadingFiles {
    final private String filePath;
    public UploadingFiles(@Value("${file.name}") String filePath) {
        this.filePath = filePath;
    }
    public Map<Integer, ResourceInfo> hashMap() {
        Map<Integer, ResourceInfo> resourceMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            if (jsonNode.isArray()) {
                for (JsonNode node : jsonNode) {
                    ResourceInfo resourceInfo = objectMapper.treeToValue(node, ResourceInfo.class);
                    resourceMap.put(resourceInfo.getId(), resourceInfo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resourceMap;
    }
}
