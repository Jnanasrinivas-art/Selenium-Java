package excelData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven
{
    public  ArrayList<String> getData(String sheetName,String testCaseName) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        //fileInputStream for input files
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //count no of Sheets
        int noSheets = workbook.getNumberOfSheets();
        System.out.println("Number of Sheets" + " " + noSheets);

        //navigate to particular sheet
        for (int i = 0; i < noSheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();

                //navigate to firstRow
                Row firstrow = rows.next();

                //navigate to each cell
                Iterator<Cell> ce = firstrow.cellIterator();
                int k = 0;
                int column = 0;
                while (ce.hasNext()) //checks whether next cell is present or not
                {
                    Cell value = ce.next(); // navigates to next cell
                    //System.out.println(value.getStringCellValue());


                    if (value.getStringCellValue().equalsIgnoreCase("testcases"))
                    {
                        column = k;
                        System.out.println("------------------------------------");
                    }
                    k++;
                }
                System.out.println(column);

                while (rows.hasNext()) {
                    Row r = rows.next();
                    //System.out.println(r.getCell(column).getStringCellValue());
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> c1 = r.cellIterator();
                        while (c1.hasNext())
                        {
                            //System.out.println(c1.next().getStringCellValue());
                            Cell c = c1.next();
                            if(c.getCellType()== CellType.STRING)
                            {
                                a.add(c.getStringCellValue());
                            }
                            else
                            {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
