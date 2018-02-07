import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;

public class AdventureInterface {

    // https://courses.engr.illinois.edu/cs126/adventure/siebel.json

    public static void main(String[] args) throws UnirestException, MalformedURLException{

        //
        if(checkArgsInput(args)) {
            String urlOrPath = args[0];

            // Read by filepath
            String fileContents = ReadData.readFilePath(urlOrPath);

            // If filepath reading fails, read by url
            if(fileContents == null && RetrieveJsonFromUrl.urlIsValid(urlOrPath)){
                fileContents = RetrieveJsonFromUrl.convertUrlToString(urlOrPath);
            }

            // If both filepath and url reading fails, print both fails.
            if(fileContents == null){
                System.out.println("Couldn't find file: " + urlOrPath);
            }

            // Success, initiate start of game.
            if(fileContents != null) {
                Gson gson = new Gson();
                Layout adventure = gson.fromJson(fileContents, Layout.class);


                if (!Layout.endingRoomReachable(adventure)) {
                    System.out.println("The layout JSON is not valid. The endingRoom " +
                            "cannot be reached from the\n" +
                            "startingRoom.\n");
                } else {
                    AdventureOutput.startAdventureGame(adventure);
                }
            }
        }

    }

    /**
     * Checks if any arguments were passed into main method
     * @param array string array
     * @return true if there were arguments, false otherwise.
     */
    public static boolean checkArgsInput(String[] array){
        if(array.length == 0){
            System.out.println("No arguments entered!");
            return false;
        }
        return true;
    }

}




