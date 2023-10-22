package com.thewhite.study;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.thewhite.study.Reading.filePath;

public class ResourceInfo {
    private int id;
    private String name;
    private String description;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nmae) {
        this.name = nmae;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public void writeToFile(){
        Map<Integer, String[]> resourceMap = new HashMap<>();
        resourceMap.put(1, new String[]{"name1", "description1", "link1"});
        resourceMap.put(2, new String[]{"name2", "description2", "link2"});
        resourceMap.put(3, new String[]{"name3", "description3", "link3"});
        resourceMap.put(4, new String[]{"name4", "description4", "link4"});
        resourceMap.put(5, new String[]{"name5", "description5", "link5"});
        resourceMap.put(6, new String[]{"name6", "description6", "link6"});


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("projectFiles/testFile.txt"))) {
            for (Map.Entry<Integer, String[]> entry : resourceMap.entrySet()) {
                int id = entry.getKey();
                String[] values = entry.getValue();
                String line = id + "," + values[0] + "," + values[1] + "," + values[2];
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("HashMap записана в файл " + "projectFiles/testFile.txt");
    }

}
