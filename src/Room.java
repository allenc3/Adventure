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
     * Custom equals to method to comapre two Room objects
     * @param another
     * @return
     */
     public boolean equals(Room another){
         if(this.name.equals(another.name) && this.description.equals(another.description)
                 && Arrays.deepEquals(this.getItems(), another.getItems())
                 && Direction.arrayEquals(this.getDirections(), another.getDirections())) {
             return true;
         }
         return false;
     }


    /**
     *
     * @param arr1
     * @param arr2
     * @return
     */
    @SuppressWarnings("Duplicates")
    public static boolean arrayEquals(Room[] arr1, Room[] arr2){
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






