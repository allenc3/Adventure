import java.util.ArrayList;

/**
 * Class to respond to inputs by user.
 */
public class AdventureInput {


    /**
     * Determines the next room the user is proceeding to.
     * @param adventure the entire adventure
     * @param currentRoom the room the player in in now
     * @param inputDirection the direction the player inputted
     * @return the next room if found, otherwise null.
     */
    public static Room determineNextRoom(Layout adventure, Room currentRoom, String inputDirection){
        String userInputLowerCaseTrimmed = inputDirection.toLowerCase().trim();
        String direction = userInputLowerCaseTrimmed.substring(2).trim();
        Room nextRoom;
        Direction nextDirection;
        if(currentRoom.findNextDirection(direction) == null){
            System.out.println("I can't go " + direction);
            return null;
        } else {
            nextDirection = currentRoom.findNextDirection(direction);
            nextRoom = adventure.findNextRoom(nextDirection.getRoom());
        }
        return nextRoom;
    }

    /**
     * Takes item from room
     * @param currentRoom the room the user is in
     * @param inputItem the item the user wants to take
     * @return the item the user took, null otherwise.
     */
    public static String takeItem(Room currentRoom, String inputItem){
        String userInputLowerCaseTrimmed = inputItem.toLowerCase().trim();
        String itemName = userInputLowerCaseTrimmed.substring(5).trim();
        String originalItemName = inputItem.substring(5).trim();
        String item;
        if(currentRoom.getItems() == null){
            currentRoom.setItems(new String[0]);
        }
        int itemIndex = currentRoom.findItemIndex(itemName);
        if(itemIndex != -1) {
            item = currentRoom.getItems()[itemIndex];
            currentRoom.removeItem(itemIndex);
            return item;
        }
        System.out.println("I can't take " + originalItemName);
        return null;
    }

    /**
     * Drops item in room
     * @param currentRoom the room the user is in
     * @param dropItem the item the user wants to drop
     * @param currentItems the arraylist of current items the user has
     */
    public static void dropItem(Room currentRoom, String dropItem, ArrayList<String> currentItems){
        String userInputLowerCaseTrimmed = dropItem.toLowerCase().trim();
        String itemName = userInputLowerCaseTrimmed.substring(5).trim();
        String originalItemName = dropItem.substring(5).trim();

        if(!currentItems.contains(itemName)){
            System.out.println("I can't drop " + originalItemName);
            return;
        }

        if(currentRoom.getItems() == null){
            currentRoom.setItems(new String[0]);
        }
        int indexOfItem = currentItems.indexOf(itemName);
        currentRoom.addItem(currentItems.get(indexOfItem));
        currentItems.remove(indexOfItem);
    }

    /**
     * Prints the list of items the user currently has.
     * @param currentItems the arraylist of items the user has.
     */
    public static void printList(ArrayList<String> currentItems){
        System.out.print("You are carrying ");
        if(currentItems.size() == 0){
            System.out.println("nothing.");
        } else if(currentItems.size() == 1){
            System.out.println(currentItems.get(0));
        } else if(currentItems.size() == 2) {
            System.out.println(currentItems.get(0) + " and " + currentItems.get(1));
        } else{
            for (int i = 0; i < currentItems.size(); i++) {
                if(i == currentItems.size() - 1){
                    System.out.println("and " + currentItems.get(i));
                } else {
                    System.out.print(currentItems.get(i) + ", ");
                }
            }
        }
    }

    /**
     * Determines if user command is in the form of "go aDirection"
     * @param userInput
     * @return
     */
    public static boolean goInADirectionCommand(String userInput){
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() > 3) {
            if (userInput.substring(0, 3).equals("go ")) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param userInput
     * @return
     */
    public static boolean takeItemCommand(String userInput){
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() > 5) {
            if (userInput.substring(0, 5).equals("take ")) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param userInput
     * @return
     */
    public static boolean dropItemCommand(String userInput){
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() > 5) {
            if (userInput.substring(0, 5).equals("drop ")) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param userInput
     * @return
     */
    public static boolean exitCommand(String userInput){
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() == 4) {
            if (userInput.equals("quit") || userInput.equals("exit")) {
                return true;
            }
        }
        return false;
    }

    public static boolean listCommand(String userInput){
        userInput = userInput.toLowerCase().trim();
        if(userInput.length() == 4) {
            if (userInput.equals("list")) {
                return true;
            }
        }
        return false;
    }

    public static void responseToInvalidInput(String userInput){
        System.out.println("I don't understand '" + userInput + "'");
    }



}
