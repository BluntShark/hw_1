package com.thewhite.study.filestests;

import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.model.ResourceInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadFilesTests {
    private UploadingFiles uploadingFiles;
    private ClassPathResource resource;

    @BeforeEach
    void setUp() {
        resource = new ClassPathResource("src/test/java/resources/test-dictionary.json");
        uploadingFiles = new UploadingFiles(resource.getPath());
    }
    @Test
    void testReadingFromFile(){
        Map<Integer, ResourceInfo> resourceMap = uploadingFiles.hashMap();

        assertEquals(1, resourceMap.get(1).getId());
        assertEquals("name2", resourceMap.get(2).getName());
        assertEquals("description3", resourceMap.get(3).getDescription());
        assertEquals("link4", resourceMap.get(4).getLink());
        assertEquals(6, resourceMap.size());
    }
}
