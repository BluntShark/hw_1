package com.thewhite.study;

import java.io.*;
import java.util.*;


public class Reading {
    public final static String filePath = "projectFiles/dictionary.txt";

    public Map<Integer, String[]> HashMapFromTextFile(){
        Map<Integer, String[]> resourceMap = new HashMap<>();
        ResourceInfo resourceInfo = new ResourceInfo();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    resourceInfo.setId(Integer.parseInt(parts[0].trim()));
                    resourceInfo.setName(parts[1].trim());
                    resourceInfo.setDescription(parts[2].trim());
                    resourceInfo.setLink(parts[3].trim());

                    resourceMap.put(resourceInfo.getId(), new String[]{resourceInfo.getName(), resourceInfo.getDescription(), resourceInfo.getLink()});
                    //System.out.println(resourceInfo.getId() + resourceInfo.getName() + resourceInfo.getDescription() + resourceInfo.getLink());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resourceMap;
    }

}
