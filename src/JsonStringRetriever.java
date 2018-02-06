import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Makes API requests, retrieves JSON file according to provided url, and returns it as a string.
 * Citation (class below derived from Professor Evans in-class demo):
 * https://github.com/zillesc/WashingtonPost
 */
public class JsonStringRetriever {

    /**
     * HTTP response status code: 200 means OK(the request succeeded)
     */
    private static final int STATUS_OK = 200;

    /**
     * Url to be parsed.
     */
    public static String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";



    /**
     * Checks validity of url, prints error message if an exception was thrown, and terminates program.
     * @param url the url to be checked.
     */
    public static boolean urlIsValid(String url) {
        if(url == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        try {
            convertUrlToString(url);
        } catch (UnirestException e) {
            System.out.println("Network not responding");
            return false;
        } catch (MalformedURLException e) {
            System.out.println("Bad URL: " + url);
            return false;
        }
        // "https://" throws a URISyntaxException
        catch (IllegalArgumentException e) {
            System.out.println("Bad URL: " + url);
            return false;
        }
        return true;
    }

    /**
     * Makes API request according to provided url and returns the string form of the json file.
     * @param url the url that provides the json file.
     * @return the string form of the json file.
     * @throws UnirestException if network is not responding.
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
        else{
            throw new IllegalArgumentException(ErrorConstants.FAULTY_URL);
        }
    }
}
