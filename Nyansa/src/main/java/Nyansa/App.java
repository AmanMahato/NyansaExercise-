package Nyansa;

import java.util.*;
import static Nyansa.Helper.getSubString;

/**
 * @author Aman Mahato
 */
public class App {

    public static void main(String[] args) {
        List<String> fileContent = Helper.getFileContent(args[0]);
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        Map<String, Integer> extractedValue ;
        for (String individualLine : fileContent) {
            String[] parsedEachLine = getSubString(individualLine);
            String epochDate = parsedEachLine[0];
            String url = parsedEachLine[1];
            String humanReadableDate = Helper.getHumanReadableDate(epochDate);
            if (!map.containsKey(humanReadableDate)) {
                Map<String, Integer> tempMap = new HashMap<>();
                tempMap.put(url, 1);
                map.put(humanReadableDate, tempMap);
            } else {
                extractedValue = map.get(humanReadableDate);
                if(!extractedValue.containsKey(url)){
                    extractedValue.put(url,1);
                }else{
                    extractedValue.put(url,extractedValue.get(url)+1);
                }
            }
        }
        //Sorting map by value and Printing the sorted map
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + " GMT");
            Set<Map.Entry<String, Integer>> set = entry.getValue().entrySet();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
            Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
            {
                public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
                {
                    return (o2.getValue()).compareTo( o1.getValue());
                }
            });
            for(Map.Entry<String, Integer> entry1:list){
                System.out.println(entry1.getKey()+" "+entry1.getValue().toString());
            }
        }
    }

}
