package com.thewhite.study;

import java.util.*;

import static java.util.Collections.list;

public class FindAnEntry {
    public void searchByName(Map<Integer, ResourceInfo<String>> resourceMap, String nameToFind) {
        List list = new ArrayList();
        for (Map.Entry<Integer, ResourceInfo<String>> entry : resourceMap.entrySet()) {
            int id = entry.getKey();
            ResourceInfo<String> data = entry.getValue();
            String name = data.getName();

            if (name != null && name.toLowerCase().contains(nameToFind.toLowerCase())) {
                String description = data.getDescription();
                String link = data.getLink();

                ResourceInfo resource = new ResourceInfo(id, name, description, link);
                list.add(resource);
            }
        }
        if(!list.isEmpty()){
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
        else{
            System.out.println("Записи не найдены");
        }
    }

}
