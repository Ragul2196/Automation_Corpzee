package com.corpzee.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;

    private XSSFSheet sheet;

    public ExcelUtils(String path, String sheetName) {

        try {

            FileInputStream fis =
                    new FileInputStream(path);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public String getCellData(int rowNum, int colNum) {

        Row row = sheet.getRow(rowNum);

        Cell cell = row.getCell(colNum);

        DataFormatter formatter =
                new DataFormatter();

        return formatter.formatCellValue(cell);

    }

    public int getRowCount() {

        return sheet.getLastRowNum();

    }

    public int getColumnCount() {

        return sheet.getRow(0).getLastCellNum();

    }

}