package Nyansa;


import java.util.*;

import static Nyansa.Helper.getSubString;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        List<String> fileContent = Helper.getFileContent("input.txt");
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        Map<String, Integer> extractedValue = new HashMap<>();
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
                //Map<String, Integer> extractedValue = map.get(humanReadableDate);
                extractedValue = map.get(humanReadableDate);
                if(!extractedValue.containsKey(url)){
                    extractedValue.put(url,1);
                }else{
                    extractedValue.put(url,extractedValue.get(url)+1);
                }
            }
        }
        extractedValue = Helper.sortByValue(extractedValue);
        //TODO--Printing map
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString());
            Helper.printMap(entry.getValue());
        }
    }

}
