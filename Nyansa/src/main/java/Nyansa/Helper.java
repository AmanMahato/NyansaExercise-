package Nyansa;

import java.io.*;
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
        try {
            inputStream = new FileInputStream(path);
            DataInputStream data_input = new DataInputStream(inputStream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
            String line;
            while ((line = buffer.readLine()) != null)
            {
                line = line.trim();
                if ((line.length()!=0))
                {
                    result.add(line);
                }
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
        }
        return result;
    }

}
