package com.thewhite.study.repository;

import com.thewhite.study.model.ResourceInfo;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ResourceInfoRepository {
    private final Map<Integer, ResourceInfo> resourceInfo = new HashMap<>();

    public void upload(@NonNull Map<Integer, ResourceInfo> resourceInfoMap) {
        resourceInfo.putAll(resourceInfoMap);
    }
}
