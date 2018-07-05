package Nyansa;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Aman Mahato
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
    public static List<String> getFileContent(String fileName) {
        List<String> returnList = new LinkedList<>();
        Scanner sc = null;
        try{
            File file = new File("src/main/resources/".concat(fileName));
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found Exception, Please make sure the file exists in the Resources folder "+ ex.getMessage());
        }
        while (sc.hasNextLine()){
            returnList.add(sc.nextLine());
          }
        return returnList;
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

}
