package com.example.restservice;

import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class serv {

    //main method to get the GETmethod from an URL 
    //this method takes the get request and transforms it if and only if  the response code is accepted (200)
    //@param url: the url to get the information
    public static String getGetterGettingGets(URL url)throws Exception{
        String inline = "";
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            scanner.close();
        }
        return inline;
    }

}
