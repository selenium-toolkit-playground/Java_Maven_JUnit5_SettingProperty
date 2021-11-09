package com.seleniumToolkit.selenium.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAdapter {



    private static XSSFRow row;

    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        Object[][] tabArray = null;

        try {
            ClassLoader classLoader = System.class.getClassLoader();
            File file = new File("src/test/resources/".concat(FilePath));
            FileInputStream ExcelFile = new FileInputStream(file);
            // Access the required test data sheet
            XSSFWorkbook excelWBook = new XSSFWorkbook(ExcelFile);
            XSSFSheet excelWSheet = excelWBook.getSheet(SheetName);

            int startRow = 1;
            int startCol = 1;
            int ci, cj;
            int totalRows = excelWSheet.getLastRowNum();
            int totalCols = excelWSheet.getRow(0).getLastCellNum()-startCol;
            tabArray = new Object[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j <= totalCols; j++, cj++) {
                    tabArray[ci][cj] = getCellData(excelWSheet, i, j);
                }
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);

    }

    public static Object getCellData(XSSFSheet excelWSheet, int RowNum, int ColNum) {

        XSSFCell cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        //System.out.println(cell);
        if(cell == null){
            return null;
        }
        if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            //if cell is a date, format it in dd.mm.yyyy
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String date = formatter.format(cell.getDateCellValue());
                return date;
            } else {
                //Currency stays formatted
                ExcelNumberFormat enf = ExcelNumberFormat.from(cell.getCellStyle());
                if (enf != null && enf.getFormat().contains("CHF")) {
                    return new DataFormatter().formatCellValue(cell).replace(",", "’");
                } else {
                    if(enf != null && (enf.getFormat().contains(".")||enf.getFormat().contains(","))){
                        return cell.getNumericCellValue();
                    } else {
                        return new Double(cell.getNumericCellValue()).intValue();
                    }
                }
            }
        }

        return cell.toString();

    }
}
