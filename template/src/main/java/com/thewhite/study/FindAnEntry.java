package com.thewhite.study;

import java.util.Map;
import java.util.Scanner;

public class FindAnEntry {
    public final static DisplayToScreen displayToScreen = new DisplayToScreen();
    public void searchByName(Map<Integer, String[]> resourceMap, String nameToFind) {

        boolean found = false;
        for (Map.Entry<Integer, String[]> entry : resourceMap.entrySet()) {
            int id = entry.getKey();
            String[] data = entry.getValue();
            String name = data[0];

            if (name != null && name.toLowerCase().contains(nameToFind.toLowerCase())) {
                if (!found) {
                    System.out.println("Найденные записи:");
                    found = true;
                }
                String description = data[1];
                String link = data[2];

                displayToScreen.print(id, name, description, link);
            }
        }

        if (!found) {
            System.out.println("Записи с указанным наименованием не найдены.");
        }
    }

}
