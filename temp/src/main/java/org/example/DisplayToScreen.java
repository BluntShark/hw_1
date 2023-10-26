package org.example;

import java.util.*;

public class DisplayToScreen {
    public void printID(Map<Integer, ResourceInfo> resourceMap, int idInt) {
        var result = resourceMap.get(idInt);
        if (result == null) {
            System.out.println("Запись с указанным идентификатором не найдена");
            return;
        }
        System.out.println(result.toString());
    }
    public void printHashMap(Map<Integer, ResourceInfo> resourceMap) {
        for (Map.Entry<Integer, ResourceInfo> entry : resourceMap.entrySet()) {
            int id = entry.getKey();
            ResourceInfo data = entry.getValue();
            String name = data.getName();
            String description = data.getDescription();
            String link = data.getLink();

            print(id, name, description, link);
        }
    }
    public void print(int id, String name, String description, String link){
        System.out.println("id: " + id
                + " name: " + name
                + " description: " + description
                + " link: " + link);
    }
}