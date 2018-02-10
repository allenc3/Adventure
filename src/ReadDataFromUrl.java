import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Makes API requests, retrieves JSON file according to provided url, and returns it as a string.
 * Citation (class below derived from Professor Evans in-class demo):
 * https://github.com/zillesc/WashingtonPost
 */
public class ReadDataFromUrl {

    /**
    * HTTP response status code: 200 means OK(the request succeeded).
    */
    private static final int REQUEST_SUCCESS = 200;

    public static String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";

    /**
     * Makes API request according to provided url and returns the string form of the json file.
     * @param url the url that provides the json file.
     * @return the string form of the json file.
     * @throws UnirestException if network is not responding.
     * @throws MalformedURLException if url is invalid.
     */
    public static String parseUrlToString(String url) {
        if(url == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        final HttpResponse<String> fileContent;

        try{
            new URL(url);
        } catch (MalformedURLException e){
            System.out.println("Bad URL: " + url);
            return null;
        }

        try {
            fileContent = Unirest.get(url).asString();
        } catch (UnirestException e){
            System.out.println("Network not responding");
            return null;
        } catch (IllegalArgumentException e){
            System.out.println("Bad URL: " + url);
            return null;
        }

        // Check to see if the request was successful
        if (fileContent.getStatus() == REQUEST_SUCCESS) {
            return fileContent.getBody();
        } else{
            System.out.println("Error: " + fileContent.getStatus());
            System.out.println("Bad URL: " + url);
            return null;
        }
    }
}
