import java.util.ArrayList;

/**
 * Class to respond to inputs by user.
 */
public class AdventureInput {

    /**
     * Determines if user command is in the form of "go aDirection"
     * @param userInput input by user
     * @return true if user wants to "go aDirection", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public static boolean goInADirectionCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.toLowerCase().trim();
        // String has to be at least 3 characters("go ")
        if(userInput.length() > 3) {
            if (userInput.substring(0, 3).matches("go\\s+")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if user command is in the form of "take anItem"
     * @param userInput input by user
     * @return true if user command is "take anItem", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public static boolean takeItemCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() > 5) {
            if (userInput.substring(0, 5).matches("take\\s+")){
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if user command is in the form of "drop anItem"
     * @param userInput input by user
     * @return true if user command is in the form of "drop anItem", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public static boolean dropItemCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() > 5) {
            if (userInput.substring(0, 5).matches("drop\\s+")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the user command is in the form of "list"
     * @param userInput input by user
     * @return true if user command is in the form of "list", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public static boolean listCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() == 4) {
            if (userInput.equals("list")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if user command is in the form of "exit" or "quit"
     * @param userInput input by user
     * @return true if user command is in the form of "exit" or "quit"
     * @throws IllegalArgumentException if userInput is null
     */
    public static boolean exitCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() == 4) {
            if (userInput.equals("quit") || userInput.equals("exit")) {
                return true;
            }
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
    public static Room determineNextRoom(Layout adventure, Room currentRoom, String userInput){
        if(userInput == null || adventure == null || currentRoom == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputLowerCaseTrimmed = userInput.toLowerCase().trim();
        // Get the direction folllowing the word "go"
        String direction = userInputLowerCaseTrimmed.substring(2).trim();
        String originalDirection = userInput.trim().substring(2).trim();

        Room nextRoom;

        // Case if the direction is not found.
        Direction nextDirection;
        if(currentRoom.findNextDirection(direction) == null){
            System.out.println("I can't go " + originalDirection);
            return currentRoom;
        }

        // If next direction is found, proceed to finding next room
        // and then initialize the next room object.
        else {
            nextDirection = currentRoom.findNextDirection(direction);
            nextRoom = adventure.findNextRoom(nextDirection.getRoom());
        }
        return nextRoom;
    }

    /**
     * Takes item from room and adds it to user's inventory.
     * @param currentRoom the room the user is in
     * @param userInput the item the user wants to take
     */
    public static void takeItem(Room currentRoom, String userInput, ArrayList<String> userInventory){
        if(currentRoom == null || userInput == null || userInventory == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputLowerCaseTrimmed = userInput.toLowerCase().trim();
        String itemName = userInputLowerCaseTrimmed.substring(5).trim();
        // Name to return if can't find item.
        String originalItemName = userInput.trim().substring(5).trim();
        String item;

        // Items may not be initialized.
        if(currentRoom.getItems() == null){
            currentRoom.setItems(new String[0]);
        }

        // If item is found, return item.
        int itemIndex = currentRoom.findItemIndex(itemName);
        if(itemIndex != -1) {
            item = currentRoom.getItems()[itemIndex];
            currentRoom.removeItem(itemIndex);
            userInventory.add(item);
            return;
        }
        System.out.println("I can't take " + originalItemName);
    }


    /**
     * Drops item in room, remove item from user's inventory.
     * @param currentRoom the room the user is in
     * @param dropItem the item the user wants to drop
     * @param userInventory the arraylist of current items the user has
     * @throws IllegalArgumentException if either of the 3 parameters is null
     */
    public static void dropItem(Room currentRoom, String dropItem, ArrayList<String> userInventory){
        if(currentRoom == null || dropItem == null || userInventory == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputLowerCaseTrimmed = dropItem.toLowerCase().trim();
        String itemName = userInputLowerCaseTrimmed.substring(5).trim();
        // Item name to return if item is not found.
        String originalItemName = dropItem.trim().substring(5).trim();

        int indexOfItem = -1;
        for (int i = 0; i < userInventory.size(); i++) {
            if(itemName.equals(userInventory.get(i).toLowerCase())){
                indexOfItem = i;
            }
        }
        if(indexOfItem == -1){
            System.out.println("I can't drop " + originalItemName);
            return;
        }

        // Initializes items if it is null.
        if(currentRoom.getItems() == null){
            currentRoom.setItems(new String[0]);
        }

        currentRoom.addItem(userInventory.get(indexOfItem));
        userInventory.remove(indexOfItem);
    }


    /**
     * Prints the list of items the user currently has.
     * @param userInventory the arraylist of items the user has.
     * @throws IllegalArgumentException if userInventory is null
     */
    public static void printList(ArrayList<String> userInventory){
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
    public static void responseToInvalidInput(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        System.out.println("I don't understand '" + userInput + "'");
    }

}
