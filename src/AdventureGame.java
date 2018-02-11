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

        Player player = adventure.getPlayer();

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
                    takeItem(currentRoom, userInput, player);
                    inputIsListCommand = false;
                }

                // 3). If user inputs "drop anItem"
                else if (dropItemCommand(userInput)) {
                    dropItem(currentRoom, userInput, player);
                    inputIsListCommand = false;
                }

                // 4). If user inputs "exit" or "quit"
                else if (exitCommand(userInput)) {
                    exit = true;
                    inputIsListCommand = false;
                }

                // 5). If user inputs "list"
                else if (listCommand(userInput)) {
                    player.printList();
                }

                else if (playerInfoCommand(userInput)) {
                    player.printPlayerInfo();
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
        if (aRoom == null || endingRoom == null || startingRoom == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        // 1). Print Description of the room
        System.out.println(aRoom.getDescription());

        // 2). If room is starting room, print statement below.
        if (aRoom.getName().equals(startingRoom)) {
            System.out.println("Your journey begins here.");
        }

        // 3). If room is the ending room, print statement below, and terminate program.
        if (aRoom.getName().equals(endingRoom)) {
            System.out.println("You have reached your final destination!");
            return true;
        }

        // 4). Print items in room.
        aRoom.printItemsInRoom();

        // 5). Print all the monsters in the room
        aRoom.printMonstersInRoom();

        // 6). Print directions player can go
        if (aRoom.getMonstersInRoom().size() == 0) {
            aRoom.printDirectionsToGo();
        }
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
     * Determines if user command is in the form of "playerInfo"
     * @param userInput input by user
     * @return true if command is playerinfo, false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean playerInfoCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("playerInfo");
    }

    /**
     * Determines if user command is in the form of "duel aMonster"
     * @param userInput input by user
     * @return true if command is duel monster, false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean duelMonsterCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        String[] input = userInput.split("\\s+", 2);
        if(input.length == 2) {
            return input[0].equalsIgnoreCase("duel");
        }
        return false;
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
     * @param player the player
     * @throws IllegalArgumentException null input if all three inputs are null
     */
    public void takeItem(Room currentRoom, String userInput, Player player){
        if(currentRoom == null || userInput == null || player == null){
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
        Item itemObj;
        if(itemIndex != -1) {
            itemObj = currentRoom.getItems().get(itemIndex);
            currentRoom.removeItems(itemIndex);
            player.addItem(itemObj);
            return;
        }
        System.out.println("I can't take " + item);
    }


    /**
     * Drops item in room, remove item from user's inventory.
     * @param currentRoom the room the user is in
     * @param userInput the item the user wants to drop
     * @param player the player
     * @throws IllegalArgumentException if either of the 3 parameters is null
     */
    public void dropItem(Room currentRoom, String userInput, Player player){
        if(currentRoom == null || userInput== null || player == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputTrimmed = userInput.trim();
        // Get the direction following the word "take"
        String[] input = userInputTrimmed.split("\\s+", 2);
        String item = input[1];

        int indexOfItem = -1;
        for (int i = 0; i < player.getItems().size(); i++) {
            if(item.equalsIgnoreCase(player.getItems().get(i).getName())){
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

        currentRoom.addItems(player.getItems().get(indexOfItem));
        player.removeItem(indexOfItem);
    }


    public void duelMonster(Layout adventure, Room currentRoom, String userInput, Player player){
        if(currentRoom == null || userInput== null || player == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputTrimmed = userInput.trim();
        // Get the direction following the word "take"
        String[] input = userInputTrimmed.split("\\s+", 2);
        String monster = input[1];

        if(currentRoom.findMonster(monster)) {
            for(Monster monsterObj: adventure.getMonsters()){
                if(monster.equalsIgnoreCase(monsterObj.getName())){
                    Duel(monsterObj);
                }
            }
        }
    }

    public void Duel(Monster monster){

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