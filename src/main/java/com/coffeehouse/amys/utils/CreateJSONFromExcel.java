package com.coffeehouse.amys.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class CreateJSONFromExcel {
    public static void main(String ar[]) {
//        createJSONFromExcel();
        createCSVFromCSV();
    }

    /**
     * will only work for one column with string value
     */
    private static void createJSONFromExcel() {
        String excelFilePath = "C:\\Users\\amya0316\\Desktop\\marketoRecords\\30th OCT\\prepareJSONFromEmails.xlsx";
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("action", "createOrUpdate");
            requestBody.addProperty("lookupField", "email");
            JsonArray input = new JsonArray();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                JsonObject jsonObject = new JsonObject();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    jsonObject.addProperty("email", currentCell.getStringCellValue());
                }
                input.add(jsonObject);
            }
            requestBody.add("input", input);
            workbook.close();
            inputStream.close();
            System.out.println(requestBody.toString());
            try (FileWriter file = new FileWriter("C:\\Users\\amya0316\\Desktop\\marketoRecords\\30th OCT\\output\\1.json")) {
                file.write(requestBody.toString());
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + requestBody);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void createCSVFromCSV() {
        String csvFile = "C:\\Users\\amya0316\\Desktop\\marketoRecords\\30th OCT\\prepareJSONFromEmailsFor15thOctContactsCSV.csv";
        CSVReader reader;
        String outputCSVFile = "C:\\Users\\amya0316\\Desktop\\marketoRecords\\30th OCT\\updatedWithMarketoIds.csv";
        File file = new File(outputCSVFile);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println(line[0].toString());
                // call API to create record and get response
                String[] writeData = {line[0].toString(), "marketoId"};
                writer.writeNext(writeData);
                break;
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
