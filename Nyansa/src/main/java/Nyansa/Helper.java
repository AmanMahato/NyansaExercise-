package Nyansa;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by amanmahato on 7/2/18.
 */
public class Helper {

    /**
     * This method is used to convert the
     * @param input
     * @return
     */
    public static String getHumanReadableDate(String input){
        long unixSeconds = Long.parseLong(input);
        Date date = new java.util.Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    /**
     * This method is used to read the file and extract each line and put in a list
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static List<String> getFileContent(String fileName) throws FileNotFoundException {
        List<String> returnList = new LinkedList<>();
        File file = new File("/Users/amanmahato/Desktop/NyansaExercise-/Nyansa/src/main/resources/".concat(fileName));
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            returnList.add(sc.nextLine());
          }
        return returnList;
    }

    /**
     * This method is used to print the map content
     * @param map
     */
    public static void printMap(Map<String,Integer> map){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }
    }

    /**
     * This method is used to split the given string based on the | dilameter
     * @param input
     * @return
     */
    public static String[] getSubString(String input){
        String date = "";
        String url = "";
        Boolean boo = true;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!='|' && boo){
                date = date+input.charAt(i);
            } else {
                boo = false;
                url = url+input.charAt(i);
            }
        }
        return new String[]{date,url.replace('|',' ').trim()};
    }

    /**
     * This method is used to sort the map based on values
     * @param unsortMap
     * @return
     */
    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
