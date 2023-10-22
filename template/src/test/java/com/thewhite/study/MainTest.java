package com.thewhite.study;
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
    @Test
    void testGetIDInf0(){
        DisplayToScreen displayToScreen = new DisplayToScreen();

        Map<Integer, String[]> resourceMap = new HashMap<>();
        resourceMap.put(1, new String[]{"Name1", "Description1", "Link1"});
        resourceMap.put(2, new String[]{"Name2", "Description2", "Link2"});

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        displayToScreen.printID(resourceMap, 1);
        String expectedOutput = "Найденная запись:\n1 Name1 Description1 Link1\n";
        assertEquals(expectedOutput, outContent.toString());

        outContent.reset();
        displayToScreen.printID(resourceMap, 3);
        expectedOutput = "Запись с указанным идентификатором не найдена\n";
        assertEquals(expectedOutput, outContent.toString());

    }
    @Test
    void testFindInfo(){

    }
    @Test
    void testWriteToFile(){
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.writeToFile();

        try (BufferedReader reader = new BufferedReader(new FileReader("projectFiles/testFile.txt"))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                assertEquals(4, parts.length);
                assertEquals(Integer.toString(lineNumber), parts[0]);
                assertEquals("name" + lineNumber, parts[1]);
                assertEquals("description" + lineNumber, parts[2]);
                assertEquals("link" + lineNumber, parts[3]);
                lineNumber++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
