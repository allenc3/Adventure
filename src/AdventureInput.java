import java.util.ArrayList;

/**
 * Class to respond to inputs by user.
 */
public class AdventureInput {


    public void determineAction(){

    }
    /**
     * Determines if user inputted "exit" or "quit"
     * @param userInput the string inputted by the user
     * @return true if userInput indicates exit. False otherwise
     */
    public boolean determineExit(String userInput) {
        String userInputLowerCaseTrimmed = userInput.toLowerCase().trim();
        if(userInputLowerCaseTrimmed.equals("quit") || userInputLowerCaseTrimmed.equals("exit")){
            return true;
        }
        return false;
    }


    /**
     * Determines the next room the user is proceeding to.
     * @param adventure the entire adventure
     * @param currentRoom the room the player in in now
     * @param inputDirection the direction the player inputted
     * @return the next room if found, otherwise null.
     */
    public Room determineNextRoom(Layout adventure, Room currentRoom, String inputDirection){
        String userInputLowerCaseTrimmed = inputDirection.toLowerCase().trim();
        String direction = userInputLowerCaseTrimmed.substring(2).trim();
        Room nextRoom;
        Direction nextDirection;
        nextDirection = currentRoom.findNextDirection(direction);
        if(nextDirection == null){
            System.out.println("I can't go " + inputDirection);
            return null;
        } else {
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
    public String takeItem(Room currentRoom, String inputItem){
        String userInputLowerCaseTrimmed = inputItem.toLowerCase().trim();
        String item;
        int itemIndex = currentRoom.findItemIndex(inputItem);
        if(itemIndex != -1) {
            item = currentRoom.getItems()[itemIndex];
            currentRoom.removeItem(itemIndex);
            return item;
        }
        System.out.println("I can't take " + inputItem);
        return null;
    }

    /**
     * Drops item in room
     * @param currentRoom the room the user is in
     * @param dropItem the item the user wants to drop
     * @param currentItems the arraylist of current items the user has
     */
    public void dropItem(Room currentRoom, String dropItem, ArrayList<String> currentItems){
        String userInputLowerCaseTrimmed = dropItem.toLowerCase().trim();
        int indexOfItem = -1;
        for (int i = 0; i < currentItems.size(); i++) {
            if(userInputLowerCaseTrimmed.equals(currentItems.get(i).toLowerCase().trim())){
                indexOfItem = i;
                break;
            }
        }

        if(indexOfItem == -1){
            System.out.println("I can't drop " + dropItem);
            return;
        }
        currentRoom.addItem(currentItems.get(indexOfItem));
        currentItems.remove(indexOfItem);
    }

    /**
     * Prints the list of items the user currently has.
     * @param currentItems the arraylist of items the user has.
     */
    public void printList(ArrayList<String> currentItems){
        System.out.print("You are carrying ");
        if(currentItems.size() == 0){
            System.out.println("nothing.");
        } else if(currentItems.size() == 1){
            System.out.println(currentItems.get(0));
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

    


}
