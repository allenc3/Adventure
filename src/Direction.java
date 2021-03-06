
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
     * @param another another Direction object
     * @return true if two Direction objects are equal, false otherwise.
     * @throws IllegalArgumentException if input is null
     */
    public boolean equals(Direction another){
        if(another == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        if(this.directionName.equals(another.directionName) && this.room.equals(another.room)){
            return true;
        }
        return false;
    }

    /**
     * Compares if two arrays of Direction objects are equal.
     * @param directionArr1 first Direction array
     * @param directionArr2 second Direction array
     * @return true if the two array contain equal Direction objects, false otherwise.
     * @throws IllegalArgumentException if input is null
     */
    @SuppressWarnings("Duplicates")
    public static boolean arrayEquals(Direction[] directionArr1, Direction[] directionArr2){
        if(directionArr1 == null || directionArr2 == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        if(directionArr1.length == directionArr2.length){
            for (int i = 0; i < directionArr1.length; i++) {
                if(!directionArr1[i].equals(directionArr2[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

