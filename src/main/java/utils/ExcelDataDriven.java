package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static utils.Constants.FS;
import static utils.Constants.USER_DIR;
import static utils.Utils.getCurrentPlatform;

//TODO
public class ExcelDataDriven {

    private static final String testDataExcelFileName = null;
    public static String testDataExcelPath = null;
    public static int rowNumber;
    public static int columnNumber;
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelWSheet;
    private static XSSFCell cell;
    private static XSSFRow row;

    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }

    public static void setExcelFileSheet(String sheetName, String plan) {

        testDataExcelPath = System.getProperty(USER_DIR) + FS + "src" + FS + "main" + FS + "resources" + FS;

        try {
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + sheetName + ".xlsx");
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(plan);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static String getCellData(int RowNum, int ColNum) {
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public static XSSFRow getRowData(int RowNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
        int i;

        try {
            int rowCount = getRowUsed();
            for (i = 0; i < rowCount; i++) {

                if (getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
                    break;
                }
            }
            return i;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static int getRowUsed() throws Exception {
        try {
            int RowCount = excelWSheet.getLastRowNum();
            return RowCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

    public static void setCellData(String value, int RowNum, int ColNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static String getTestCaseName(String sTestCase) throws Exception {
        String value = sTestCase;
        try {
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            System.out.println("value"+value);
            return value;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static Object[][] getTableArray() throws Exception {
        int startCol = 1;
        int ci = 0, cj;
        int totalRows = 4;
        int totalCols = 6;
        int iTestCaseRow = 1;
        String[][] tabArray = new String[totalRows][totalCols];
        do {
            cj = 0;
            for (int j = startCol; j <= totalCols; j++, cj++) {
                tabArray[ci][cj] = getCellData(iTestCaseRow, j);
                System.out.println(tabArray[ci][cj]);
            }
            iTestCaseRow++;
            ci++;
        }while (iTestCaseRow<=totalRows);
        return tabArray;
    }

}
