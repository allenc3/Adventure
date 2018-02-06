import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Defines a room object.
 */
public class Room {
    /**
     * Variables initialized according to the room's properties.
     */
    private String name;
    private String description;
    private String[] items;
    private Direction[] directions;


    /**
     * @return name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }

     /**
      * @return a string arraylist of the items in the room
      */
     public String[] getItems() {
         return items;
     }

    /**
     * Sets an item array since it might not be initialized.
     * @param items the item array to be added
     * @throws IllegalArgumentException if items is null
     */
    public void setItems(String[] items) {
        if(items == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        this.items = items;
    }

    /**
     * @return a direction array that consists of the possible directions one may proceed to
     */
    public Direction[] getDirections() {
        return directions;
    }


    /**
     * Removes item from items array.
     * @param indexToBeRemoved the index of the item to be removed.
     * @throws IllegalArgumentException if index if negative
     */
    public void removeItem(int indexToBeRemoved) {
        if(indexToBeRemoved < 0){
            throw new IllegalArgumentException(ErrorConstants.NEGATIVE_INDEX);
        }

        // Converts array to arraylist
        ArrayList<String> itemArrayList = new ArrayList<String>(Arrays.asList(items));

        // Removes item
        itemArrayList.remove(indexToBeRemoved);

        // Converts arraylist back to array and assigns the item array to it.
        String[] arrWithItemRemoved = new String[itemArrayList.size()];
        arrWithItemRemoved = itemArrayList.toArray(arrWithItemRemoved);
        this.items = arrWithItemRemoved;
    }

    /**
     * Adds item to items array.
     * @param itemToBeAdded the string of the item to be added.
     * @throws IllegalArgumentException if itemToBeAdded is null
     */
    public void addItem(String itemToBeAdded) {

        if(itemToBeAdded == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        // Converts array to arraylist
        ArrayList<String> itemArrayList = new ArrayList<String>(Arrays.asList(items));

        // Adds item
        itemArrayList.add(itemToBeAdded);

        // Converts arraylist back to array and assigns the item array to it
        String[] arrWithItemAdded = new String[itemArrayList.size()];
        arrWithItemAdded = itemArrayList.toArray(arrWithItemAdded);
        this.items = arrWithItemAdded;
    }


    /**
     * Custom equals to method to compare two Room objects
     * @param another another Room object
     * @return true if two Room objects are equal, false otherwise.
     * @throws IllegalArgumentException if input is null
     */
     public boolean equals(Room another){
         if(another == null) {
             throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
         }

         if(this.name.equals(another.name) && this.description.equals(another.description)
                 && Arrays.deepEquals(this.getItems(), another.getItems())
                 && Direction.arrayEquals(this.getDirections(), another.getDirections())) {
             return true;
         }
         return false;
     }


    /**
     * Compares if two arrays of Room objects are equal.
     * @param arr1 first Room array
     * @param arr2 second Room array
     * @return true if the two array contain equal Room objects, false otherwise.
     * @throws IllegalArgumentException if either arr 1 or arr 2 is null
     */
    @SuppressWarnings("Duplicates")
    public static boolean arrayEquals(Room[] arr1, Room[] arr2){
        if(arr1 == null || arr2 == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        if(arr1.length == arr2.length){
            for (int i = 0; i < arr1.length; i++) {
                if(!arr1[i].equals(arr2[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * Finds if a direction exists in the Direction array.
     * @param inputDirection the direction inputted by user
     * @return the direction object if it is found, null otherwise.
     * @throws IllegalArgumentException if inputDirection is null
     */
    public Direction findNextDirection(String inputDirection){
        if(inputDirection == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        inputDirection = inputDirection.toLowerCase().trim();
        for(Direction direction: directions){
            if(direction.getDirectionName().toLowerCase().equals(inputDirection)){
                return direction;
            }
        }
        return null;
    }

    /**
     * Finds the index of a item in the item array
     * @param inputItem the item to be searched for
     * @return the index of the item if it is found, -1 otherwise.
     * @throws IllegalArgumentException if inputItem is null
     */
    public int findItemIndex(String inputItem) {
        if(inputItem == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        for (int i = 0; i < items.length; i++) {

            if (items[i].toLowerCase().equals(inputItem)) {
                return i;
            }
        }
        return -1;
    }

    /**S
     * Prints all the items in the room object.
     */
    public void printItemsInRoom(){
        // If item array is not initialized, prints following message.
        if(this.getItems() == null){
            System.out.println("This room contains nothing!");
            return;
        }

        // Case if items is empty
        if(this.getItems().length == 0){
            System.out.println("This room contains nothing!");
        } else {
            System.out.print("This room contains: ");

            // Case when items = 1
            if(this.getItems().length == 1){
                System.out.println(this.getItems()[0]);
            }

            // Case when items = 2
            else if(this.getItems().length == 2) {
                System.out.println(this.getItems()[0] + " and " + this.getItems()[1]);
            }

            // Case when items >= 3
            else {
                for (int i = 0; i < this.getItems().length; i++) {
                    if (i == this.getItems().length - 1) {
                        System.out.println("and " + this.getItems()[i]);
                    } else{
                        System.out.print(this.getItems()[i] + ", ");
                    }
                }
            }
        }
    }

    /**
     * Prints all direction names in the Direction array.
     */
    public void printDirectionsToGo(){
        if(this.getDirections().length == 0){
            System.out.println("You can't go anywhere!");
        } else {
            System.out.print("From here, you can go: ");

            // Case when items = 1
            if(this.getDirections().length == 1){
                System.out.println(this.getDirections()[0].getDirectionName());
            }

            // Case when items = 2
            else if(this.getDirections().length == 2){
                System.out.println(this.getDirections()[0].getDirectionName() + " and " + this.getDirections()[1].getDirectionName());
            }

            // Case when items >= 3
            else {
                for (int i = 0; i < this.getDirections().length; i++) {
                    if (i == this.getDirections().length - 1) {
                        System.out.println("and " + this.getDirections()[i].getDirectionName());
                    } else{
                        System.out.print(this.getDirections()[i].getDirectionName() + ", ");
                    }
                }
            }
        }
    }

}






