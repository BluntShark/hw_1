package com.thewhite.study.repositorytests;

import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.model.ResourceInfo;
import com.thewhite.study.repository.ResourceInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTests {
    private UploadingFiles uploadingFiles;
    private ResourceInfoRepository repository;
    private ClassPathResource resource;
    @BeforeEach
    void setUp() {
        resource = new ClassPathResource("src/test/java/resources/test-dictionary.json");
        uploadingFiles = new UploadingFiles(resource.getPath());
        repository = new ResourceInfoRepository();
        repository.upload(uploadingFiles.hashMap());
    }
    @Test
    void searchByNameTest(){
        String nameToFind = "name6";

        List<ResourceInfo> list = repository.searchByName(nameToFind);

        assertEquals(nameToFind, list.get(0).getName());
        assertEquals(1, list.size());
    }
    @Test
    void printID(){
        int idInt = 5;

        ResourceInfo resourceInfo = repository.printID(5);

        assertEquals(idInt, resourceInfo.getId());
    }
}
