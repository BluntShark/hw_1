package com.thewhite.study.config;

import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.repository.ResourceInfoRepository;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ConfigApp {
    UploadingFiles uploadingFiles;

    ResourceInfoRepository resource;
    @PostConstruct
    public void uploadRepository() {
        resource.upload(uploadingFiles.HashMapFromJSONFile());
    }
}
