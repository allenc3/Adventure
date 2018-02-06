import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;

public class AdventureInterface {

    // https://courses.engr.illinois.edu/cs126/adventure/siebel.json

    public static void main(String[] args) throws UnirestException, MalformedURLException{

        if(checkArgs(args)) {

            String url = args[0];

            // Checks url validity
            boolean urlAccepted = RetrieveJsonFromUrl.urlIsValid(url);

            if(urlAccepted) {
                // Starts parsing json file.
                Gson gson = new Gson();
                Layout adventure = gson.fromJson(RetrieveJsonFromUrl.
                                convertUrlToString(url), Layout.class);

                AdventureOutput.startAdventureGame(adventure);
            }
        }
    }

    public static boolean checkArgs(String[] array){
        if(array.length == 0){
            System.out.println("No arguments entered!");
            return false;
        }
        return true;
    }
}



