package com.thewhite.study;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;


public class MainTests {
    public void writeToFile(){
        Map<Integer, ResourceInfo> resourceMap = new HashMap<>();
        resourceMap.put(1, new ResourceInfo(1,"name1", "description1", "link1"));
        resourceMap.put(2, new ResourceInfo(2,"name2", "description2", "link2"));
        resourceMap.put(3, new ResourceInfo(3,"name3", "description3", "link3"));
        resourceMap.put(4, new ResourceInfo(4,"name4", "description4", "link4"));
        resourceMap.put(5, new ResourceInfo(5,"name5", "description5", "link5"));
        resourceMap.put(6, new ResourceInfo(6,"name6", "description6", "link6"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("projectFiles/dictionary.txt"))) {
            for (Map.Entry<Integer, ResourceInfo> entry : resourceMap.entrySet()) {
                int id = entry.getKey();
                ResourceInfo values = entry.getValue();
                String line = id + ", " + values.getName() + ", " + values.getDescription() + ", " + values.getLink();
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
        int idToPrint = 2;
        String expectedOutput = "id: 2 name: name2 description: description2 link: link2\r\n";

        Map<Integer, ResourceInfo> resourceMap = new HashMap<>();
        resourceMap.put(1, new ResourceInfo(1, "name1", "description1", "link1"));
        resourceMap.put(2, new ResourceInfo(2, "name2", "description2", "link2"));
        resourceMap.put(3, new ResourceInfo(3, "name3", "description3", "link3"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DisplayToScreen displayToScreen = new DisplayToScreen();
        displayToScreen.printID(resourceMap, idToPrint);

        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"me3", "name3", "NaMe3", "nAMe3"})
    void testFindInfo(String nameToFind) {
        String expectedOutput = "id: 3 name: name3 description: description3 link: link3\r\n";

        Map<Integer, ResourceInfo> resourceMap = new HashMap<>();
        resourceMap.put(1, new ResourceInfo(1, "name1", "description1", "link1"));
        resourceMap.put(2, new ResourceInfo(2, "name2", "description2", "link2"));
        resourceMap.put(3, new ResourceInfo(3, "name3", "description3", "link3"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FindAnEntry findAnEntry = new FindAnEntry();
        findAnEntry.searchByName(resourceMap, nameToFind);

        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReadingFromFileFirst(){
        String f1 = "src/test/java/resources/test-dictionary.txt";
        String f2 = "projectFiles/dictionary.txt";
        File filePath1 = new File(f1);
        File filePath2 = new File(f2);
        Map<Integer, ResourceInfo> resourceMap;
        Reading reading = new Reading();
        resourceMap = reading.HashMapFromTextFile(f2);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f1))) {
            for (Map.Entry<Integer, ResourceInfo> entry : resourceMap.entrySet()) {
                int id = entry.getKey();
                ResourceInfo values = entry.getValue();
                String line = id + ", " + values.getName() + ", " + values.getDescription() + ", " + values.getLink();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isEqual = false;
        try
        {
            isEqual = FileUtils.contentEquals(filePath1, filePath2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(isEqual);
    }
    @Test
    void testReadingFromFileSecond(){
        Map<Integer, ResourceInfo> resourceMapReference = new HashMap<>();

        resourceMapReference.put(1, new ResourceInfo(1,"name1", "description1", "link1"));
        resourceMapReference.put(2, new ResourceInfo(2,"name2", "description2", "link2"));
        resourceMapReference.put(3, new ResourceInfo(3,"name3", "description3", "link3"));
        resourceMapReference.put(4, new ResourceInfo(4,"name4", "description4", "link4"));
        resourceMapReference.put(5, new ResourceInfo(5,"name5", "description5", "link5"));
        resourceMapReference.put(6, new ResourceInfo(6,"name6", "description6", "link6"));

        String f1 = "src/test/java/resources/test-dictionary.txt";
        Map<Integer, ResourceInfo> resourceMap;
        Reading reading = new Reading();

        resourceMap = reading.HashMapFromTextFile(f1);

        Iterable<ResourceInfo> itTest;
        itTest = resourceMap.values();

        Iterable<ResourceInfo> itReference;
        itReference = resourceMapReference.values();

        Assertions.assertIterableEquals(itReference, itTest);
    }
    @Test
    void testWriteToFileFirst() {
        String expectedOutput = "HashMap записана в файл projectFiles/dictionary.txt\r\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MainTests mainTests = new MainTests();
        mainTests.writeToFile();

        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    void testWriteToFileThird() {
        int key = 1;
        Map<Integer, ResourceInfo> resourceMap = new HashMap<>();
        resourceMap.put(1, new ResourceInfo(1,"name1", "description1", "link1"));
        resourceMap.put(2, new ResourceInfo(2,"name2", "description2", "link2"));
        resourceMap.put(3, new ResourceInfo(3,"name3", "description3", "link3"));
        resourceMap.put(4, new ResourceInfo(4,"name4", "description4", "link4"));
        resourceMap.put(5, new ResourceInfo(5,"name5", "description5", "link5"));
        resourceMap.put(6, new ResourceInfo(6,"name6", "description6", "link6"));

        Reading reading = new Reading();
        Map<Integer, ResourceInfo> result = reading.HashMapFromTextFile("projectFiles/dictionary.txt");

        assertEquals(resourceMap.get(key).toString(), result.get(key).toString());
    }
}



