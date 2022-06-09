package com.fileReaderWriter.fileReaderWriter.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ViewController {
    private static final Logger logger = LogManager.getLogger("ViewController");
    @Autowired
    FileReaderWriterController fileReaderWriterController;
    private String fileLocation;
    
    @GetMapping("/")
    public String home(MultipartFile file, Model model) {
        model.addAttribute("file", file);
        return "chooseFile";
    }
    
    @PostMapping("/uploadExcelFile")
    public String uploadFile(Model model, MultipartFile file) throws IOException {
        
        List<String> dataRead = (fileReaderWriterController.readFromExcel(file));
        model.addAttribute("datas", dataRead);
        return "fileContent";
    }
}


//@Controller
//public class ViewController {
//
//    @Autowired
//    FileReaderWriterController fileReaderWriterController;
//
//    @GetMapping("/")
//    public String home(MultipartFile file, Model model) {
//        model.addAttribute("file",file);
//        return "chooseFile";
//    }
//
//    @PostMapping("/file/add")
//    public String addFile(@RequestParam("file") MultipartFile file, Model model) {
//        List<String> dataRead = null;
//
//        try {
//            dataRead = fileReaderWriterController.readFromExcel(file.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        model.addAttribute("datas", dataRead);
//        return "fileContent";
//    }
//}
