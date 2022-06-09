package com.fileReaderWriter.fileReaderWriter.repositories;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class FileReaderWriterRepository {
    
    private static final Logger logger = LogManager.getLogger("FileReaderWriterRepository");
    
    public List<String> readFromExcel(MultipartFile fileMultipart) throws IOException {
        
        String filename = fileMultipart.getOriginalFilename();
        
        List sheetData = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Integer shhetNo=workbook.getNumberOfSheets();
            logger.info("sheet no "+shhetNo);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                
                List data = new ArrayList();
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return sheetData;
    }


//    with switch (extension)
//
//    public List<String> readFromExcel(MultipartFile fileMultipart) throws IOException {
//
//        String filename = fileMultipart.getOriginalFilename();
//
//        logger.info("fileName is " + filename);
//
//        String extension= filename.split("\\.")[1];
//
//
//        logger.info("extension is " + extension);
//
//        List sheetData = new ArrayList();
//        FileInputStream fis = null;
//        try {
//
//            switch (extension) {
//                case "xlsx":
//                    fis = new FileInputStream(filename);
//                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//                    XSSFSheet sheet = workbook.getSheetAt(0);
//                    Iterator rows = sheet.rowIterator();
//                    while (rows.hasNext()) {
//                        XSSFRow row = (XSSFRow) rows.next();
//                        Iterator cells = row.cellIterator();
//
//                        List data = new ArrayList();
//                        while (cells.hasNext()) {
//                            XSSFCell cell = (XSSFCell) cells.next();
//                            data.add(cell);
//                        }
//                        sheetData.add(data);
//                    }
//                case "xls":
//                    fis = new FileInputStream(filename);
//                    HSSFWorkbook workbookXlsx = new HSSFWorkbook(fis);
//                    HSSFSheet sheetXlsx = workbookXlsx.getSheetAt(0);
//                    Iterator rowsXlsx = sheetXlsx.rowIterator();
//                    while (rowsXlsx.hasNext()) {
//                        HSSFRow row = (HSSFRow) rowsXlsx.next();
//                        Iterator cells = row.cellIterator();
//
//                        List data = new ArrayList();
//                        while (cells.hasNext()) {
//                            HSSFCell cell = (HSSFCell) cells.next();
//                            data.add(cell);
//                        }
//
//                        sheetData.add(data);
//                    }
//                default:
//
//                    return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                fis.close();
//            }
//        }
//        return sheetData;
//    }
}