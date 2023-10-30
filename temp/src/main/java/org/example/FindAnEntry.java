package org.example;

import java.util.*;

public class FindAnEntry {
    public void searchByName(Map<Integer, ResourceInfo> resourceMap, String nameToFind) {
        List<ResourceInfo> list = new ArrayList<>();
        for (Map.Entry<Integer, ResourceInfo> entry : resourceMap.entrySet()) {
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
        if(!list.isEmpty()){
            for (ResourceInfo resourceInfo : list) {
                System.out.println(resourceInfo);
            }
        }
        else{
            System.out.println("Записи не найдены");
        }
    }
}