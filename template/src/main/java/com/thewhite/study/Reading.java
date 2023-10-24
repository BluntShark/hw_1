package com.thewhite.study;

import java.io.*;
import java.util.*;

import static com.thewhite.study.Main.filePath;


public class Reading {
    //public final static String filePath = "projectFiles/dictionary.txt";
    public Map<Integer, ResourceInfo<String>> HashMapFromTextFile(){
        Map<Integer, ResourceInfo<String>> resourceMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    ResourceInfo resourceInfo = new ResourceInfo(Integer.parseInt(parts[0].trim()), parts[1].trim(), parts[2].trim(), parts[3].trim());
                    resourceMap.put(resourceInfo.getId(), new ResourceInfo<>(resourceInfo.getId(), resourceInfo.getName(), resourceInfo.getDescription(), resourceInfo.getLink()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resourceMap;
    }

}
