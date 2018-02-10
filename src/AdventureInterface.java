import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;

public class AdventureInterface {

    // https://courses.engr.illinois.edu/cs126/adventure/siebel.json

    public static void main(String[] args) {

            String fileContents = validUrlOrPath(args);

            if(fileContents != null) {

                Layout adventure = initializeLayout(fileContents);

                if(layoutIsValid(adventure)) {
                    AdventureGame game = new AdventureGame();
                    game.startAdventureGame(adventure);
                }
            }
    }

    /**
     * Checks if any arguments were passed into main method. Input will not be null.
     * @param array string array
     * @return true if there were arguments, false otherwise.
     */
    public static boolean checkArgsInput(String[] array){
        if(array == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        if(array.length == 0){
            System.out.println("No arguments entered!");
            return false;
        }
        return true;
    }

    /**
     * Checks if url or path is valid. If it is, parse it to a string. Return null otherwise.
     * @param args string array of arguments
     * @return the file contents if valid, null otherwise.
     * @throws UnirestException if url is invalid
     * @throws MalformedURLException if url is invalid
     */
    public static String validUrlOrPath(String[] args) {
        if(args == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String fileContents = null;
        if (checkArgsInput(args)) {
            String urlOrPath = args[0];

            // Read by filepath
            fileContents = ReadDataFromFilePath.readFilePath(urlOrPath);

            // If filepath reading fails, read by url
            if (fileContents == null) {
                fileContents = ReadDataFromUrl.parseUrlToString(urlOrPath);
            }

            // If both filepath and url reading fails, print both fails.
            if (fileContents == null) {
                System.out.println("Couldn't find file: " + urlOrPath);
            }
        }
        return fileContents;
    }

    /**
     * Checks if layout is valid by checking if ending room is reachable
     * and if a room can access and be accessed.
     * @param adventure
     * @return true if layout is valid.
     */
    public static boolean layoutIsValid(Layout adventure) {
        if(adventure == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        if (!adventure.isEndingRoomReachable()) {
            System.out.println("The layout JSON is not valid. The endingRoom " +
                    "cannot be reached from the " +
                    "startingRoom.");
            return false;
        }
        if (!adventure.isFloorPlanValid()) {
            System.out.println("Rooms are not connected! Faulty floor plan.");
            return false;
        }
        return true;
    }

    /**
     * Initializes Layout object with gson
     * @param fileContents string that contains all the file's contents
     * @return the Layout object.
     */
    public static Layout initializeLayout(String fileContents){
        if(fileContents == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        Gson gson = new Gson();
        return gson.fromJson(fileContents, Layout.class);
    }
}




