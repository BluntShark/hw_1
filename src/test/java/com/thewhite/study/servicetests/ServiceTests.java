package com.thewhite.study.servicetests;

import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.model.ResourceInfo;
import com.thewhite.study.service.ResourceInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTests {
    private UploadingFiles uploadingFiles;
    private ResourceInfoService service;
    private Map<Integer, ResourceInfo> resourceMap;
    private ClassPathResource resource;
    @BeforeEach
    void setUp() {
        resource = new ClassPathResource("src/test/java/resources/test-dictionary.json");
        uploadingFiles = new UploadingFiles(resource.getPath());
        resourceMap = uploadingFiles.hashMap();
        service = new ResourceInfoService();
    }
    @Test
    void testGetIDInf0() {
        int idToPrint = 5;
        String expectedOutput = "ResourceInfo(id=5, name=name5, description=description5, link=link5)\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        service.printID(idToPrint);
        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"me3", "name3", "NaMe3", "nAMe3"})
    void testFindInfo(String nameToFind){
        String expectedOutput = "ResourceInfo(id=3, name=name3, description=description3, link=link3)\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        service.searchByName(nameToFind);
        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }
}
