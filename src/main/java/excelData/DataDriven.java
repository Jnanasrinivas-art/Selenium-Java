package excelData;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataDriven
{
    // Selenium WebDriver be default does not support Excel,need to use third party library Apache POI

    public static String readFromExcel(String sheetName, String colLetter, int rowNum) throws IOException {
        //fileInputStream for reading mode
        //FileOutputStream for writing mode

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\testData\\data.xlsx");

        // Below 4 are the class
        //XSSFWorkbook    --- workbook
        //XSSFSheet       --- Sheet
        //XSSFRow         --- Row
        //XSSFCell        --- Cell

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //count no of Sheets
        int noSheets = workbook.getNumberOfSheets();
        //System.out.println("Number of Sheets" + " " + noSheets);

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int colIndex= CellReference.convertColStringToIndex(colLetter);

        int rowIndex= rowNum-1;

        XSSFRow row = sheet.getRow(rowIndex);

        XSSFCell cell = row.getCell(colIndex);

        String data = cell.getStringCellValue();

        fis.close();
        workbook.close();
        return data;
    }
}
