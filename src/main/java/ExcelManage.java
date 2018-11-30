import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;


//读取excel文档
public class ExcelManage {
    public static HashMap<String, Integer> readExcelcol(File file,String s) {
        HashMap<String, Integer> colList = new HashMap<String, Integer>();
        try {
            InputStream in = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheetAt(0);

            XSSFRow row = null;
            XSSFCell cell = null;
            int last = sheet.getLastRowNum();
            for (int i = 1; i <= last; i++) {
                //取得第i行
                row = sheet.getRow(i);
                cell = row.getCell(0);
                String cellValue = cell.getStringCellValue().trim();
                cellValue = cellValue.replaceAll("/", "\\\\");
                colList.put(s+cellValue, i);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return colList;
    }

}