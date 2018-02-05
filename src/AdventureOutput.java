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
     * @param reachEnd if the adventure has reached its end
     */
    public static boolean proceedWithAdventure(Room aRoom, boolean started, boolean reachEnd){

        boolean adventureEnded = false;
        // 1). Print Description
        System.out.println(aRoom.getDescription());

        // 2). If room is starting room, print statement below.
        if(!started){
            System.out.println("Your journey beings here.");
        }

        // 3). If room is the ending room, print statement below.
        if(reachEnd){
            System.out.println("You have reached your final destination");
            adventureEnded = true;
        }

        // 4). Print items in room.
        aRoom.printItemsInRoom();

        // 5). Print directions player can go
        aRoom.printDirectionsToGo();

        return adventureEnded;
    }
}
