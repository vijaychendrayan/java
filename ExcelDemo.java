/**
 * Created by VC024129 on 5/1/2017.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//test
//test
//test3
//test4



public class ExcelDemo {

    public static void main(String []args) throws IOException{
        String excelFilePath = "C:\\Users\\VC024129\\Documents\\Vijay\\TestFrameWork\\TestExcelRead.xlsx";
        FileInputStream inputStream = new FileInputStream((new File(excelFilePath)));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()){
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                System.out.println(cell);
            }
            System.out.println("1----------1");
        }
        System.out.println("2----------2");
        workbook.close();
        inputStream.close();
    }

}
