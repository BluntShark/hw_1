package com.thewhite.study.repository;

import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.model.ResourceInfo;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ResourceInfoRepository {
    //необходимый map
    private final Map<Integer, ResourceInfo> resourceInfo = new HashMap<>();


    //пока так оставила, чтобы работало (и в методах этот map использую)
    private UploadingFiles files = new UploadingFiles("src/main/resources/description.json");
    Map<Integer, ResourceInfo> map = files.hashMap();

    public void upload(@NonNull Map<Integer, ResourceInfo> resourceInfoMap) {
        resourceInfo.putAll(resourceInfoMap);
    }
    public List<ResourceInfo> searchByName(@NonNull String nameToFind){
        List<ResourceInfo> list = new ArrayList<>();
        for (Map.Entry<Integer, ResourceInfo> entry : map.entrySet()) {
            int id = entry.getKey();
            ResourceInfo data = entry.getValue();
            String name = data.getName();

            if (name != null && name.toLowerCase().contains(nameToFind.toLowerCase())) {
                String description = data.getDescription();
                String link = data.getLink();

                ResourceInfo resource = new ResourceInfo(id, name, description, link);
                list.add(resource);
            }
        }
        return list;
    }
    public ResourceInfo printID(int idInt) {
        return map.get(idInt);
    }
    public void printHashMap() {
        for (Map.Entry<Integer, ResourceInfo> entry : map.entrySet()) {
            int id = entry.getKey();
            ResourceInfo data = entry.getValue();
            String name = data.getName();
            String description = data.getDescription();
            String link = data.getLink();

            System.out.println("id: " + id
                    + " name: " + name
                    + " description: " + description
                    + " link: " + link);
        }
    }
}
