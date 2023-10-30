package com.thewhite.study;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainTest {
    public void writeToFile(){
        Map<Integer, ResourceInfo<String>> resourceMap = new HashMap<>();
        resourceMap.put(1, new ResourceInfo<>(1,"name1", "description1", "link1"));
        resourceMap.put(2, new ResourceInfo<>(2,"name2", "description2", "link2"));
        resourceMap.put(3, new ResourceInfo<>(3,"name3", "description3", "link3"));
        resourceMap.put(4, new ResourceInfo<>(4,"name4", "description4", "link4"));
        resourceMap.put(5, new ResourceInfo<>(5,"name5", "description5", "link5"));
        resourceMap.put(6, new ResourceInfo<>(6,"name6", "description6", "link6"));


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("projectFiles/dictionary.txt"))) {
            for (Map.Entry<Integer, ResourceInfo<String>> entry : resourceMap.entrySet()) {
                int id = entry.getKey();
                ResourceInfo<String> values = entry.getValue();
                String line = id + "," + values.getName() + "," + values.getDescription() + "," + values.getLink();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("HashMap записана в файл " + "projectFiles/dictionary.txt");
    }
    @Test
    void testGetIDInf0() {
        DisplayToScreen displayToScreen = new DisplayToScreen();

        Map<Integer, ResourceInfo<String>> resourceMap = new HashMap<>();
        resourceMap.put(1, new ResourceInfo<>(1, "name1", "description1", "link1"));
        resourceMap.put(2, new ResourceInfo<>(2, "name2", "description2", "link2"));
        resourceMap.put(3, new ResourceInfo<>(3, "name3", "description3", "link3"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int idToPrint = 2;
        displayToScreen.printID(resourceMap, idToPrint);

        System.setOut(System.out);

        String expectedOutput = "2, name2, description2, link2\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testFindInfo() {

    }

    @Test
    void testWriteToFile() {

    }

}



