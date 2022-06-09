package com.fileReaderWriter.fileReaderWriter.controllers;

import com.fileReaderWriter.fileReaderWriter.services.FileReaderWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileReaderWriterController {
    @Autowired
    FileReaderWriterService fileReaderWriterService;
    
    public List<String>readFromExcel(MultipartFile file) throws IOException {
        return fileReaderWriterService.readFromExcel(file);
    }
}
