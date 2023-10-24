package com.thewhite.study;

import java.util.*;

public class DisplayToScreen {
    public void printID(Map<Integer, ResourceInfo<String>> resourceMap, int idInt) {
        var result = resourceMap.get(idInt);
        if (result == null) {
            System.out.println("Запись с указанным идентификатором не найдена");
        }
        else{
            for (Map.Entry<Integer, ResourceInfo<String>> entry : resourceMap.entrySet()) {
                int id = entry.getKey();
                ResourceInfo<String> data = entry.getValue();
                String name = data.getName();
                String description = data.getDescription();
                String link = data.getLink();

                if(id == idInt) {print(id, name, description, link);}
            }
        }
    }
    public void printHashMap(Map<Integer, ResourceInfo<String>> resourceMap) {
        for (Map.Entry<Integer, ResourceInfo<String>> entry : resourceMap.entrySet()) {
            int id = entry.getKey();
            ResourceInfo<String> data = entry.getValue();
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
    public void printObj(Object object){
        System.out.println(object.toString());
    }
}
