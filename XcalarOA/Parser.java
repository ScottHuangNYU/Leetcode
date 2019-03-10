package XcalarOA;

import java.util.*;

public class Parser {
    public static void main(String args[]) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        Map<Integer, Map<String, String>> map = new TreeMap<>();
        Set<String> headerSet = new HashSet<>();
        int i = 0;
        String date = "";
        String key = "";
        String value = "";
        String lastLine = "";

        while(scanner.hasNextLine()){

            String line = scanner.nextLine();
            if("quit".equals(line)) break;
            if(line.isEmpty()){
                i++;
            }
            if(!map.containsKey(i)){
                Map<String, String> innerMap = new TreeMap<>();
                map.put(i,innerMap);
            }else {
                Map<String, String> innerMap = map.get(i);
                char[] array = line.toCharArray();
                if (lastLine.isEmpty() && Character.isUpperCase(line.charAt(0)) && line.charAt(1) == ' '
                        && Character.isUpperCase(line.charAt(2)) && line.charAt(3) == ' '
                        && Character.isUpperCase(line.charAt(4)) && line.charAt(5) == ' '
                        && line.charAt(6) == ' ' && line.charAt(7) == ' ') {
                    date = line;
                    innerMap.put("DATE", date);
                    headerSet.add("DATE");
                }
                if(lastLine.isEmpty() && (Character.isLowerCase(line.charAt(0)) || line.charAt(1) != ' '
                        || Character.isLowerCase(line.charAt(2)) || line.charAt(3) != ' '
                        || Character.isLowerCase(line.charAt(4)) || line.charAt(5) != ' '
                        || line.charAt(6) != ' ' || line.charAt(7) != ' ')){
                    innerMap.put("DATE", date);
                }
                if(Character.isLowerCase(line.charAt(0)) || line.charAt(1) != ' '
                        || Character.isLowerCase(line.charAt(2)) || line.charAt(3) != ' '
                        || Character.isLowerCase(line.charAt(4)) || line.charAt(5) != ' '
                        || line.charAt(6) != ' ' || line.charAt(7) != ' ') {
                    int index = 0;
                    for (int j = 0; j < array.length; j++) {
                        if (line.charAt(j) == ':' && j + 1 < array.length && line.charAt(j + 1) == ' ') {
                            index = j;
                            break;
                        }else{
                            index++;
                        }
                    }
                    if (index != array.length) {
                        key = line.substring(0, index);
                        value = line.substring(index+2, array.length);
                        innerMap.put(new String(key), new String(value));
                        headerSet.add(key);
                    } else {
                        value = value + " " + line.substring(0, array.length);
                        innerMap.put(new String(key), new String(value));
                    }
                }
            }
            lastLine = line;
            //System.out.println("------" + line);
        }
        System.out.println("i是: " + i);
        map.remove(i);
        System.out.println(map.size());
        System.out.println("看存进去了没" + map.get(1).get("GDH"));
        String header = "";
        List<String> headerList = new ArrayList<>(headerSet);
        System.out.println("---------");

        Collections.sort(headerList);
        for(String ss: headerList){
            System.out.println(ss);
        }
        for(String s: headerList){
            if(!s.equals("DATE")){
                header = header + s + "|";
            }
        }

        header = header + "DATE";
        headerList.remove("DATE");
        headerList.add("DATE");
        System.out.println(header);


        for(int k = 1; k < i; k++){
            String content = "";
            int index = 0;
            for(Map.Entry<String, String> innerMapEntry : map.get(k).entrySet()){
                if(innerMapEntry.getKey().equals("DATE")) continue;
                else{
                    boolean flag = true;
                    while(flag){
                        if(headerList.get(index).equals(innerMapEntry.getKey())){
                            content += innerMapEntry.getValue() + "|";
                            index++;
                            flag = false;
                        }else{
                            content += "|";
                            index++;
                        }
                    }
                }
            }
            content += map.get(k).get("DATE");
            System.out.println(content);
        }
    }
}
