import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to respond to inputs by user.
 */
public class AdventureGame {

    /**
     * Method to play adventure game!
     * @param adventure the layout object parsed from a json file. MAPS the adventure
     */
    public void startAdventureGame(Layout adventure) {

        String startingRoom = adventure.getStartingRoom();
        String endingRoom = adventure.getEndingRoom();
        Room currentRoom = adventure.findRoomByRoomName(startingRoom);

        ArrayList<String> userInventory = new ArrayList<>();

        // If exit is true, terminate program.
        boolean exit = false;

        // Loops on until exit
        while (!exit) {

            exit = proceedWithAdventure(currentRoom, startingRoom, endingRoom);
            if(exit){
                break;
            }

            // Deals with the command "list", as the details of the room
            // does not have have to be restated.
            boolean inputIsListCommand = true;
            while (inputIsListCommand) {


                Scanner scn = new Scanner(System.in);
                String userInput = scn.nextLine();

                // 1). If user inputs "go aDirection"
                if (goInADirectionCommand(userInput)) {

                    // Returns next room if found, current room if otherwise.
                    currentRoom = findNextRoom(adventure, currentRoom, userInput);

                    // Exits loop to print details of next room.
                    inputIsListCommand = false;
                }

                // 2). If user inputs "take anItem"
                else if (takeItemCommand(userInput)) {
                    takeItem(currentRoom, userInput, userInventory);
                    inputIsListCommand = false;
                }

                // 3). If user inputs "drop anItem"
                else if (dropItemCommand(userInput)) {
                    dropItem(currentRoom, userInput, userInventory);
                    inputIsListCommand = false;
                }

                // 4). If user inputs "exit" or "quit"
                else if (exitCommand(userInput)) {
                    exit = true;
                    inputIsListCommand = false;
                }

                // 5). If user inputs "list"
                else if (listCommand(userInput)) {
                    printList(userInventory);
                }

                // 6). If user inputs unknown command
                else {
                    responseToInvalidInput(userInput);
                    inputIsListCommand = false;
                }
            }

        }
    }


    /**
     * Method to travel from one room to another.
     * @param aRoom the room to be traveled to
     * @param startingRoom the starting room
     * @param endingRoom the ending room
     * @throws IllegalArgumentException if aRoom or endingRoom is null
     */
    public boolean proceedWithAdventure(Room aRoom, String startingRoom, String endingRoom) {
        if(aRoom == null || endingRoom == null || startingRoom == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        // 1). Print Description of the room
        System.out.println(aRoom.getDescription());

        // 2). If room is starting room, print statement below.
        if(aRoom.getName().equals(startingRoom)){
            System.out.println("Your journey begins here.");
        }

        // 3). If room is the ending room, print statement below, and terminate program.
        if(aRoom.getName().equals(endingRoom)){
            System.out.println("You have reached your final destination!");
            return true;
        }

        // 4). Print items in room.
        aRoom.printItemsInRoom();

        // 5). Print directions player can go
        aRoom.printDirectionsToGo();

        return false;
    }




    /**
     * Determines if user command is in the form of "go aDirection"
     * @param userInput input by user
     * @return true if user wants to "go aDirection", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean goInADirectionCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        String[] input = userInput.split("\\s+", 2);
        if(input.length == 2) {
            return input[0].equalsIgnoreCase("go");
        }
        return false;
    }

    /**
     * Determines if user command is in the form of "take anItem"
     * @param userInput input by user
     * @return true if user command is "take anItem", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean takeItemCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        String[] input = userInput.split("\\s+", 2);
        if(input.length == 2) {
            return input[0].equalsIgnoreCase("take");
        }
        return false;
    }

    /**
     * Determines if user command is in the form of "drop anItem"
     * @param userInput input by user
     * @return true if user command is in the form of "drop anItem", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean dropItemCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        String[] input = userInput.split("\\s+", 2);
        if(input.length == 2) {
            return input[0].equalsIgnoreCase("drop");
        }
        return false;
    }

    /**
     * Determines if the user command is in the form of "list"
     * @param userInput input by user
     * @return true if user command is in the form of "list", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean listCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("list");
    }

    /**
     * Determines if user command is in the form of "exit" or "quit"
     * @param userInput input by user
     * @return true if user command is in the form of "exit" or "quit"
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean exitCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return (userInput.equalsIgnoreCase("quit")
                || userInput.equalsIgnoreCase("exit"));
    }

    /**
     * Determines the next room the user is proceeding to.
     * @param adventure the entire adventure
     * @param currentRoom the room the player in in now
     * @param userInput the direction the player inputted
     * @return the next room if found, otherwise null.
     * @throws IllegalArgumentException if any of the three inputs is null
     */
    public Room findNextRoom(Layout adventure, Room currentRoom, String userInput){
        if(userInput == null || adventure == null || currentRoom == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputTrimmed = userInput.trim();
        // Get the direction following the word "go"
        String[] input = userInputTrimmed.split("\\s+", 2);
        String direction = input[1];

        Room nextRoom;

        // Case if the direction is not found.
        Direction nextDirection;
        if(currentRoom.findDirection(direction) == null){
            System.out.println("I can't go " + direction);
            return currentRoom;
        }

        else {
            nextDirection = currentRoom.findDirection(direction);
            nextRoom = adventure.findRoomByRoomName(nextDirection.getRoom());
        }
        return nextRoom;
    }

    /**
     * Takes item from room and adds it to user's inventory.
     * @param currentRoom the room the user is in
     * @param userInput the item the user wants to take
     */
    public void takeItem(Room currentRoom, String userInput, ArrayList<String> inventory){
        if(currentRoom == null || userInput == null || inventory == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputTrimmed = userInput.trim();
        // Get the direction following the word "take"
        String[] input = userInputTrimmed.split("\\s+", 2);
        String item = input[1];

        // Items may not be initialized.
        if(currentRoom.getItems() == null){
            currentRoom.setItems();
        }

        // If item is found, return item.
        int itemIndex = currentRoom.findItemIndex(item);
        if(itemIndex != -1) {
            item = currentRoom.getItems().get(itemIndex);
            currentRoom.removeItems(itemIndex);
            inventory.add(item);
            return;
        }
        System.out.println("I can't take " + item);
    }


    /**
     * Drops item in room, remove item from user's inventory.
     * @param currentRoom the room the user is in
     * @param userInput the item the user wants to drop
     * @param userInventory the arraylist of current items the user has
     * @throws IllegalArgumentException if either of the 3 parameters is null
     */
    public void dropItem(Room currentRoom, String userInput, ArrayList<String> userInventory){
        if(currentRoom == null || userInput== null || userInventory == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputTrimmed = userInput.trim();
        // Get the direction following the word "take"
        String[] input = userInputTrimmed.split("\\s+", 2);
        String item = input[1];

        int indexOfItem = -1;
        for (int i = 0; i < userInventory.size(); i++) {
            if(item.equalsIgnoreCase(userInventory.get(i))){
                indexOfItem = i;
            }
        }
        if(indexOfItem == -1){
            System.out.println("I can't drop " + item);
            return;
        }

        // Initializes items if it is null.
        if(currentRoom.getItems() == null){
            currentRoom.setItems();
        }

        currentRoom.addItems(userInventory.get(indexOfItem));
        userInventory.remove(indexOfItem);
    }


    /**
     * Prints the list of items the user currently has.
     * @param userInventory the arraylist of items the user has.
     * @throws IllegalArgumentException if userInventory is null
     */
    public void printList(ArrayList<String> userInventory){
        if(userInventory == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        System.out.print("You are carrying ");
        if(userInventory.size() == 0){
            System.out.println("nothing.");
        } else if(userInventory.size() == 1){
            System.out.println(userInventory.get(0));
        } else if(userInventory.size() == 2) {
            System.out.println(userInventory.get(0) + " and " + userInventory.get(1));
        } else{
            for (int i = 0; i < userInventory.size(); i++) {
                if(i == userInventory.size() - 1){
                    System.out.println("and " + userInventory.get(i));
                } else {
                    System.out.print(userInventory.get(i) + ", ");
                }
            }
        }
    }

    /**
     * If input is invalid, prints message in the form of "I don't understand 'userInput'"
     * @param userInput input by user
     * @throws IllegalArgumentException if userInput is null
     */
    public void responseToInvalidInput(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        System.out.println("I don't understand '" + userInput + "'");
    }

}
