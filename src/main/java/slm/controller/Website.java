package slm.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Website {

    private static String message = "no information";
    private static String style = "";

    public static void setMessage(String message) {
        Website.message = message;
    }

    public static void setStyle(String style) {
        Website.style = style;
    }

    public static String getMessage() {
        return message;
    }

    public static String getStyle() {
        return style;
    }

    private static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getJSON() {
        return "{\"message\": \""+getMessage()+"\", "+
                "\"style\": \""+getStyle()+"\", "+
                "\"time\": \""+getTime()+"\"}";
    }

    //https://stackoverflow.com/questions/12035316/reading-entire-html-file-to-string
    public static String getHTML() {
        String content = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("MaintenanceMonitor.html"));
            String str;
            while ((str = in.readLine()) != null) {
                content +=str;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
