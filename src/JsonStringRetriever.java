import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Makes API requests, retrieves JSON file according to provided url, and returns it as a string.
 */
public class JsonStringRetriever {

    /**
     * HTTP response status code: 200 means OK(the request succeeded)
     */
    private static final int STATUS_OK = 200;
    public static String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";


    /**
     * Checks validity of url, prints error message if an exception was thrown, and terminates program.
     * @param url the url to be checked.
     */
    public static void checkUrl(String url) {
        if(url == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        try {
            convertUrlToString(url);
        } catch (UnirestException e) {
            System.out.println("Network not responding");
            System.exit(1);
        } catch (MalformedURLException e) {
            System.out.println("Bad URL: " + url);
            System.exit(1);
        }
    }

    /**
     * Citation: Code provided by Professor Evans during demonstration FINISH CITATION!!!
     * Makes API request according to provided url and returns the string form of the josn file.
     * @param url the url that provides the json file.
     * @return the string form of the json file.
     * @throws UnirestException
     * @throws MalformedURLException if url is invalid.
     */
    public static String convertUrlToString(String url) throws UnirestException, MalformedURLException {

        if(url == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        final HttpResponse<String> jsonAsString;

        // This will throw MalformedURLException if the url is malformed.
        new URL(url);

        jsonAsString = Unirest.get(url).asString();

        // Check to see if the request was successful; if so, convert the payload JSON into Java objects
        if (jsonAsString.getStatus() == STATUS_OK) {
            return jsonAsString.getBody();
        }
        // Returns null if other problems occur.
        return null;
    }
}
