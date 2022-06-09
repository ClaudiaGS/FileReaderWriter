package com.fileReaderWriter.fileReaderWriter.services;

import com.fileReaderWriter.fileReaderWriter.repositories.FileReaderWriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileReaderWriterService {
    @Autowired
    FileReaderWriterRepository fileReaderWriterRepository;
    
    public List<String> readFromExcel(MultipartFile file) throws IOException {
        return fileReaderWriterRepository.readFromExcel(file);
    }
}
