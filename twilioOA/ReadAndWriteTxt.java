package twilioOA;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ReadAndWriteTxt {


    public void readAndWriteFile(String path){

        List<String> readRes = new LinkedList<>();

        try{
            Scanner in = new Scanner(new File(path));

            while(in.hasNext()){
                String url = in.nextLine();
                System.out.println(url);
                readRes.add(url);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        Map<String, Integer> map = new HashMap<>();

        for(String url : readRes){
            map.put(url, map.getOrDefault(url, 0) + 1);
        }
        try {
            String outputFile = "/Users/zijunhuang/Documents/IntelliJ Projects/out/production/Test/twilioOA/output.txt";
            PrintWriter out = new PrintWriter(outputFile);
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                out.write(entry.getKey() + " " + entry.getValue());
                out.write("\n");
            }
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }




    }



    public static void main(String[] arg){
        String path = "/Users/zijunhuang/Documents/IntelliJ Projects/out/production/Test/twilioOA/input.txt";
        ReadAndWriteTxt r = new ReadAndWriteTxt();
        r.readAndWriteFile(path);
    }
}
