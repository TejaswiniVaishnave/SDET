import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity4_3 {
    private static final String FILE_NAME = "resources/TestSheet.xlsx";
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };
        int rowNum = 0;
        System.out.println("Creating excel");
        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
/*
 * For this activity we will be using Excel to store data and Apache POI to
 * retrieve that data. First make sure that APache POI has been installed for
 * your project. To start with create a static global variable that is going to
 * contain the file path for the Excel sheet. In the main function, create an
 * object for XSSFWorkbook class. This object that will be used to create the
 * Excel sheets. Create an object for the XSSFSheet class as well. Initialize it
 * as shown below. Next we create the data that will inserted into the sheet.
 * The data is input as a 2D array of objects. Each row is one object and each
 * item in that object counts as column value. Finally in a try block, Create a
 * FileOutputStream object and pass in the FILE_NAME global variable. Use
 * workbook.write() method with the FileOutputStream object to write to the
 * Excel sheet specified.
 */