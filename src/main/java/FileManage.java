import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManage {

    public  static  void findSame(ArrayList a, HashMap h){
        for(int i=a.size()-1;i>=0;i--){
            //从文件夹中找是否有相同的
            boolean b = h.containsKey(a.get(i));
            //如果有相同把该文件从队列中删除
            if(b) {
                h.remove(a.get(i));
                a.remove(i);
            }
        }
    }

    public static void delFile(ArrayList a){
        for(int i=0;i<a.size();i++){
            String s = (String) a.get(i);
            s = s.replaceAll("\\\\", "\\\\\\\\");
           File file = new File(s);
           file.delete();
        }
    }

        public static void clear(File f) {
            for (File f1 : f.listFiles()) {
                if (f1.isDirectory()) {
                    clear(f1);
                    //一直递归到最后的目录
                    if (f1.listFiles().length == 0) {
                        //如果是文件夹里面没有文件证明是空文件，进行删除
                        f1.delete();
                    }
                }
            }
        }

    public static ArrayList listDirectory(File dir,ArrayList a)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }

        File[] files=dir.listFiles();
        if(files!=null&&files.length>0){
            for(File file:files){
                boolean b = file.getName().contains(".files");
                if(file.isDirectory()&&!b)
                    //递归
                    listDirectory(file,a);
                else{
                    if(!b) {
                        String s = file+"";
                        a.add(s);
                    }

                }

            }
        }
        return a;
    }
}
