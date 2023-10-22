package com.thewhite.study;

import java.util.*;

public class DisplayToScreen {
    public void printID(Map<Integer, String[]> resourceMap, int idInt) {
        boolean found = false;
        for (Map.Entry<Integer, String[]> entry : resourceMap.entrySet()) {
            int id = entry.getKey();
            String[] data = entry.getValue();
            String name = data[0];
            String description = data[1];
            String link = data[2];

            if(id == idInt) {
                if (!found) {
                    System.out.println("Найденная запись:");
                    found = true;
                }
                print(id, name, description, link);
            }
        }
        if (!found) {
            System.out.println("Запись с указанным идентификатором не найдена");
        }
    }
    public void printHashMap(Map<Integer, String[]> resourceMap) {
        for (Map.Entry<Integer, String[]> entry : resourceMap.entrySet()) {
            int id = entry.getKey();
            String[] data = entry.getValue();
            String name = data[0];
            String description = data[1];
            String link = data[2];

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
