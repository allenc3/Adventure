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


    /**
     * Method to play adventure game!
     * @param adventure the layout object parsed from a json file. MAPS the adventure
     */
    public static void startAdventureGame(Layout adventure) {

        // The starting room
        Room currentRoom = adventure.findNextRoom(adventure.getStartingRoom());

        ArrayList<String> userInventory = new ArrayList<String>();

        // Accounts for the "Your journey begins here" statement
        boolean started = false;
        AdventureOutput.proceedWithAdventure(currentRoom, started, adventure.getEndingRoom());
        started = true;

        // If exit is true, terminate program.
        boolean exit = false;

        // Loops on until exit
        while (!exit) {

            // Deals with the command "list", as the details of the room
            // does not have have to be restated.
            boolean inputIsListCommand = true;

            while (inputIsListCommand) {
                // Gets user input
                Scanner scn = new Scanner(System.in);
                String userInput = scn.nextLine();


                // 1). If user inputs "go aDirection"
                if (AdventureInput.goInADirectionCommand(userInput)) {

                    // Returns next room if found, current room if otherwise.
                    currentRoom = AdventureInput.determineNextRoom(adventure,
                            currentRoom, userInput);


                    // Exits loop to print details of next room.
                    inputIsListCommand = false;
                }

                // 2). If user inputs "take anItem"
                else if (AdventureInput.takeItemCommand(userInput)) {
                    AdventureInput.takeItem(currentRoom, userInput, userInventory);
                    inputIsListCommand = false;
                }

                // 3). If user inputs "drop anItem"
                else if (AdventureInput.dropItemCommand(userInput)) {
                    AdventureInput.dropItem(currentRoom, userInput, userInventory);
                    inputIsListCommand = false;
                }

                // 4). If user inputs "exit" or "quit"
                else if (AdventureInput.exitCommand(userInput)) {
                    exit = true;
                    inputIsListCommand = false;
                }

                // 5). If user inputs "list"
                else if (AdventureInput.listCommand(userInput)) {
                    AdventureInput.printList(userInventory);
                }

                // 6). If user inputs unknown command
                else {
                    AdventureInput.responseToInvalidInput(userInput);
                    inputIsListCommand = false;
                }

            }

            // Prints out details of the next room.
            if(!exit){
                boolean continueAdventure = AdventureOutput.proceedWithAdventure(currentRoom,
                        started, adventure.getEndingRoom());
                if(!continueAdventure){
                    exit = true;
                }
            }
        }


    }
}
