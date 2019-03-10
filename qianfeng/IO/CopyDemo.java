package qianfeng.IO;

import java.io.*;

public class CopyDemo {

    public static void copy(String scr, String target){

        File srcFile = new File(scr);
        File targetFile = new File(target);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(targetFile);

            byte[] bytes = new byte[1024];
            int len = -1;

            while ((len = in.read(bytes)) != -1){
                out.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(in != null) in.close();
                if(out != null) out.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args){
        copy("src/qianfeng/IO/a.txt", "bb.txt");
    }
}
