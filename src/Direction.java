
/**
 * Defines a direction object.
 */
public class Direction {

    /**
     * Variables initialized according to the direction's properties.
     */
    private String directionName;
    private String room;

    /**
     * @return the direction that one may proceed to
     */
    public String getDirectionName() {
        return directionName;
    }

    /**
     * @return the room that one will be in if they head in the direction.
     */
    public String getRoom() {
        return room;
    }

    /**
     * Custom equals to method that compares two Direction objects
     * @param other
     * @return
     */
    public boolean equals(Direction other){
        if(this.directionName.equals(other.directionName) && this.room.equals(other.room)){
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
    public static boolean arrayEquals(Direction[] arr1, Direction[] arr2){
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

