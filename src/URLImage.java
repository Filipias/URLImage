/**
 * Created by grel14 on 2017-05-05.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLImage {
    public static void main(String[] args) throws Exception {
        String url = "https://www.oracle.com/index.html";
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("img=") && inputLine.contains("http")){
                int start = inputLine.indexOf("img=");
                int stop = inputLine.indexOf("\"", start+6);
                if (stop < 0){
                    stop = inputLine.indexOf(">", start+6);
                }

                String link = inputLine.substring(start+6, stop);
                if (!inputLine.contains("[!--$")){
                    System.out.println(link);
                }
            }
        }
        in.close();
    }
}

