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
      * @return a string array of the items in the room
      */
     public String[] getItems() {
         return items;
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
}






