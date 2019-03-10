package twilioOA;

import java.util.LinkedList;
import java.util.List;

public class TranslateDate {
    public List<String> translateDat(List<String> s){

        List<String> res = new LinkedList<>();
        for(String str : s){
            String[] date = str.split(" ");
            String year = date[2];
            String day = date[0];
            String month = date[1];
            System.out.println(month);
            String resM = "";
            String resD = "";

            switch (month){
                case "Jan":
                    resM = "01";
                    break;

                case "Feb":
                    resM = "02";
                    break;

                case "Mar":
                    resM = "03";
                    break;

                case "Apr":
                    resM = "04";
                    break;

                case "May":
                    resM = "05";
                    break;

                case "Jun":
                    resM = "06";
                    break;

                case "Jul":
                    resM = "07";
                    break;

                case "Aug":
                    resM = "08";
                    break;

                case "Sep":
                    resM = "09";
                    break;

                case "Oct":
                    resM = "10";
                    break;

                case "Nov":
                    resM = "11";
                    break;

                case "Dec":
                    resM = "12";
                    break;

            }
            //System.out.println(resM);
            switch (day){
                case "1st":
                    resD = "01";
                    break;
                case "2nd":
                    resD = "02";
                    break;
                case "3rd":
                    resD = "03";
                    break;
                case "4th":
                    resD = "04";
                    break;
                case "5th":
                    resD = "05";
                    break;
                case "6th":
                    resD = "06";
                    break;
                case "7th":
                    resD = "07";
                    break;
                case "8th":
                    resD = "08";
                    break;
                case "9th":
                    resD = "09";
                    break;
                case "10th":
                    resD = "10";
                    break;
                case "11th":
                    resD = "11";
                    break;
                case "12th":
                    resD = "12";
                    break;
                case "13th":
                    resD = "13";
                    break;
                case "14th":
                    resD = "14";
                    break;
                case "15th":
                    resD = "15";
                    break;
                case "16th":
                    resD = "16";
                    break;

            }
            //System.out.println(resD);

            StringBuilder sb = new StringBuilder();
            sb.append(year);
            sb.append("-");
            sb.append(resM);
            sb.append("-");
            sb.append(resD);

            res.add(sb.toString());
        }



      return res;


    }

    public static void main(String[] arg){
        List<String> s = new LinkedList<>();
        s.add("1st May 1989");
        s.add("2nd Jun 2001");
        s.add("4th Aug 2011");
        TranslateDate d = new TranslateDate();
        System.out.println(d.translateDat(s));
    }
}
