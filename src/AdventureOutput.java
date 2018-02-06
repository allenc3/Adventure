import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureOutput {

    /**
     * Method to travel from one room to another.
     * @param aRoom the room to be traveled to
     * @param started if the adventure has started
     * @param endingRoom the ending room
     * @throws IllegalArgumentException if aRoom or endingRoom is null
     */
    public static boolean proceedWithAdventure(Room aRoom, boolean started, String endingRoom){

        if(aRoom == null || endingRoom == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        // 1). Print Description of the room
        System.out.println(aRoom.getDescription());

        // 2). If room is starting room, print statement below.
        if(!started){
            System.out.println("Your journey begins here.");
        }

        // 3). If room is the ending room, print statement below, and terminate program.
        if(aRoom.getName().equals(endingRoom)){
            System.out.println("You have reached your final destination!");
            return false;
        }

        // 4). Print items in room.
        aRoom.printItemsInRoom();

        // 5). Print directions player can go
        aRoom.printDirectionsToGo();

        return true;
    }
}
