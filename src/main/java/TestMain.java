import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {
    public static void main(String[] args) throws IOException {
        //文件所在位置
        String FilePos = "D:\\中国联通";
        //Excel所在位置
        String ExcelPos = "D:\\1.xlsx";
        //根目录所在目录
        String RootPos = "D:\\";


        ArrayList a = new ArrayList();
        FileManage.listDirectory(new File(FilePos),a);
        HashMap h = ExcelManage.readExcelcol(new File(ExcelPos),RootPos);
        /*FileManage.findSame(a,h);
        FileManage.delFile(a);
        FileManage.clear(new File(FilePos));*/


        for(Object key:h.keySet()){
            System.out.println(key+"");
        }

    }
}
