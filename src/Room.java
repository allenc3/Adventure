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
     * @param items
     */
    public void setItems(String[] items) {
        this.items = items;
    }


    /**
     * Setter to change items in items array
     * @param indexToBeRemoved the index of the item to be removed.
     */
    public void removeItem(int indexToBeRemoved) {
        ArrayList<String> itemArraylist = new ArrayList<String>(Arrays.asList(items));
        itemArraylist.remove(indexToBeRemoved);
        String[] arrWithItemRemoved = new String[itemArraylist.size()];
        arrWithItemRemoved = itemArraylist.toArray(arrWithItemRemoved);
        this.items = arrWithItemRemoved;
    }

    public void addItem(String itemToBeAdded) {
        ArrayList<String> itemArraylist = new ArrayList<String>(Arrays.asList(items));
        itemArraylist.add(itemToBeAdded);
        String[] arrWithItemAdded = new String[itemArraylist.size()];
        arrWithItemAdded = itemArraylist.toArray(arrWithItemAdded);
        this.items = arrWithItemAdded;
    }

     /**
      * @return a direction array that consists of the possible directions one may proceed to
      */
     public Direction[] getDirections() {
         return directions;
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
     * @throws IllegalArgumentException if input is null
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


    public Direction findNextDirection(String inputDirection){
        inputDirection = inputDirection.toLowerCase().trim();
        for(Direction direction: directions){
            if(direction.getDirectionName().toLowerCase().equals(inputDirection)){
                return direction;
            }
        }
        return null;
    }

    public int findItemIndex(String inputItem) {
        for (int i = 0; i < items.length; i++) {

            if (items[i].toLowerCase().equals(inputItem)) {
                return i;
            }
        }
        return -1;
    }

    public void printItemsInRoom(){
        if(this.getItems() == null){
            System.out.println("This room contains nothing!");
            return;
        }
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

    public void printDirectionsToGo(){
        if(this.getDirections().length == 0){
            System.out.println("You can't go anywhere!");
        } else {
            System.out.print("From here, you can go: ");

            // Case when items = 1
            if(this.getDirections().length == 1){
                System.out.println(this.getDirections()[0].getDirectionName());
            }
            // Case when items >= 2
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






