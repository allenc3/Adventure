import com.example.Adventure;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureInterface {

    //https://courses.engr.illinois.edu/cs126/adventure/siebel.json

    public static void main(String[] args) throws UnirestException, MalformedURLException{

        /**
         * Asks for url and checks if it is valid.
         */
        String url = promptForUrl(args[0]);

        /**
         * Starts parsing json file
         */
        Gson gson = new Gson();
        Layout adventure = gson.fromJson(JsonStringRetriever.convertUrlToString(url), Layout.class);

        /**
         * Starts the adventure game!
         */
        adventureGame(adventure);

    }

    /**
     * Repeatedly asks user for valid url.
     * @return the vaid url.
     */
    public static String promptForUrl(String url){

        if(!JsonStringRetriever.urlIsValid(url)) {
            System.exit(0);
        }
        return url;
    }

    /**
     * Method to play adventure game!
     * @param adventure the layout object parsed from a json file. MAPS the adventure
     */
    public static void adventureGame(Layout adventure) {

        // The starting room
        Room currentRoom = adventure.findNextRoom(adventure.getStartingRoom());

        // Initializes inventory
        ArrayList<String> userInventory = new ArrayList<String>();

        // Accounts for the "Your journey begins here" statement
        boolean started = false;
        AdventureOutput.proceedWithAdventure(currentRoom, started, adventure.getEndingRoom());
        started = true;

        // Loops on until exit
        while (true) {

            // Deals with the command "list", as the details of the room
            // does not have have to be restated.
            boolean inputIsListCommand = true;

            while (inputIsListCommand) {
                // Gets user input
                Scanner scn = new Scanner(System.in);
                String userInput = scn.nextLine();

                // 1). If user inputs "go aDirection"
                if (AdventureInput.goInADirectionCommand(userInput)) {
                    // Prevents null pointer exception
                    Room checkForNull = AdventureInput.determineNextRoom(adventure,
                            currentRoom, userInput);
                    if (checkForNull != null) {
                        currentRoom = checkForNull;
                    }

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
                    System.exit(0);
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
            AdventureOutput.proceedWithAdventure(currentRoom, started, adventure.getEndingRoom());
        }
    }
}



