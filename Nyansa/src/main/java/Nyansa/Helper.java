package Nyansa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Aman Mahato
 */
public class Helper {

    /**
     * This method is used to convert the epch date to human readable form
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

    /**
     * This function is used to read the file line by line from the specified path
     * @param path
     * @return
     */
    public static List<String> fileReaderPerLine(String path){
        FileInputStream inputStream = null;
        List<String> result = new LinkedList<>();
        Scanner sc = null;
        String line = "";
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                result.add(line);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (java.io.IOException fnfe) {
            System.out.println(fnfe.getStackTrace());
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return result;
    }

}
