package qianfeng.IO;

import java.io.*;
import java.sql.SQLOutput;

public class CharStreamDemo {

    private static void in(){
        File file = new File("src/qianfeng/IO/test.txt");

        try {
            Reader in = new FileReader(file);
            char[] cs = new char[1];
            int len = -1;
            StringBuilder buf = new StringBuilder();
            while((len = in.read(cs)) != -1){
                buf.append(new String(cs,0,len));
            }
            in.close();
            System.out.println(buf.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void out(){
        File file = new File("src/qianfeng/IO/test.txt");

        try {
            Writer out = new FileWriter(file);
            out.write("小河流水哗啦啦");
            System.out.println("success");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //out();
        in();
    }
}
