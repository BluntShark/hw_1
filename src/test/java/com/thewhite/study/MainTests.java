package com.thewhite.study;
import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.model.ResourceInfo;
import com.thewhite.study.repository.ResourceInfoRepository;
import com.thewhite.study.service.ResourceInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.*;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;


public class MainTests {
    private UploadingFiles uploadingFiles;
    private ResourceInfoService service;
    private Map<Integer, ResourceInfo> resourceMap;
    @BeforeEach
    void setUp() {
        uploadingFiles = new UploadingFiles("src/test/java/resources/test-dictionary.json");
        resourceMap = uploadingFiles.HashMapFromJSONFile();
        service = new ResourceInfoService();
    }
    @Test
    void testGetIDInf0() {
        int idToPrint = 5;
        String expectedOutput = "ResourceInfo(id=5, name=name5, description=description5, link=link5)\r\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        service.printID(resourceMap, idToPrint);

        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }


    @ParameterizedTest
    @ValueSource(strings = {"me3", "name3", "NaMe3", "nAMe3"})
    void testFindInfo(String nameToFind){
        String expectedOutput = "ResourceInfo(id=3, name=name3, description=description3, link=link3)\r\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        service.searchByName(resourceMap, nameToFind);

        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testReadingFromFile(){
        UploadingFiles uploadingFiles = new UploadingFiles("src/test/java/resources/test-dictionary.json");

        Map<Integer, ResourceInfo> resourceMap = uploadingFiles.HashMapFromJSONFile();

        assertEquals(1, resourceMap.get(1).getId());
        assertEquals("name2", resourceMap.get(2).getName());
        assertEquals("description3", resourceMap.get(3).getDescription());
        assertEquals("link4", resourceMap.get(4).getLink());
    }

}



