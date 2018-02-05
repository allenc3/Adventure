import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureOutput {

    public static void main(String[] args) throws UnirestException, MalformedURLException{
        // Parsing URL with Gson.
        Gson gson = new Gson();
        boolean validUrl = false;
        while(!validUrl){
            validUrl = JsonStringRetriever.urlIsValid(JsonStringRetriever.url);
            System.out.println("Please enter a valid url!");
        }
        Layout adventure = gson.fromJson(JsonStringRetriever
                .convertUrlToString(JsonStringRetriever.url), Layout.class);

        boolean exit = false;
        boolean reachEnd = false;
        boolean started = false;
        Room currentRoom = adventure.findNextRoom(adventure.getStartingRoom());

        ArrayList<String> currentItems = new ArrayList<String>();

        while(!exit){

            if(!started){
                proceedWithAdventure(currentRoom, started, reachEnd);
                started = true;
            } else {
                proceedWithAdventure(currentRoom, started, reachEnd);
            }
            while(true) {
                Scanner scn = new Scanner(System.in);
                String userInput = scn.nextLine();
            }


        }

    }

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
        // Case when items = 0
        if(aRoom.getItems().length == 0){
            System.out.println("This room contains nothing!");
        } else {
            System.out.print("This room contains: ");

            // Case when items = 1
            if(aRoom.getItems().length == 1){
                System.out.println(aRoom.getItems()[0]);
            }
            // Case when items >= 2
            else {
                for (int i = 0; i < aRoom.getItems().length; i++) {
                    if (i == aRoom.getItems().length - 1) {
                        System.out.println("and " + aRoom.getItems()[i]);
                    } else{
                        System.out.print(aRoom.getItems()[i] + ", ");
                    }
                }
            }
        }

        // 5). Print directions player can go
        if(aRoom.getDirections().length == 0){
            System.out.println("You can't go anywhere!");
        } else {
            System.out.print("From here, you can go: ");

            // Case when items = 1
            if(aRoom.getDirections().length == 1){
                System.out.println(aRoom.getDirections()[0].getDirectionName());
            }
            // Case when items >= 2
            else {
                for (int i = 0; i < aRoom.getDirections().length; i++) {
                    if (i == aRoom.getDirections().length - 1) {
                        System.out.println("and " + aRoom.getDirections()[i].getDirectionName());
                    } else{
                        System.out.print(aRoom.getDirections()[i] + ", ");
                    }
                }
            }
        }
        return adventureEnded;
    }

    public boolean determineExit(String userInput) {
        String userInputLowerCaseTrimmed = userInput.toLowerCase().trim();
        if(userInputLowerCaseTrimmed.equals("quit") || userInputLowerCaseTrimmed.equals("exit")){
            return true;
        }
        return false;
    }

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
