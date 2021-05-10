package com.codetest.restservice.utils;

import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class URLUtils {

    //this method takes the get request and transforms it if and only if  the response code is accepted (200)
    //@param url: the url to get the information
    public String readURLData(URL url)throws Exception{
        String data = "";
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                data += scanner.nextLine();
            }
            scanner.close();
        }
        return data;
    }

}
