import java.util.Arrays;

/**
 * Layout object that includes Room and Direction objects.
 * Maps entire adventure.
 */
public class Layout {

    /**
     * Variables initialized according to the adventure's properties.
     */
    private String startingRoom;
    private String endingRoom;
    private Room[] rooms;

    /**
     * @return the ending room that will signify the end of the adventure.
     */
    public String getEndingRoom() {
        return endingRoom;
    }

    /**
     * @return the starting room that signifies the start of the adventure.
     */
    public String getStartingRoom() {
        return startingRoom;
    }

    /**
     * @return a room array of all the possible rooms in this adventure.
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * Custom equals to method to compare two Layout objects.
     * @param another another Layout object
     * @return true if two Layout objects are equal, false otherwise.
     * @throws IllegalArgumentException if input is null
     */
    public boolean equals(Layout another){
        if(another == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        if(this.startingRoom.equals(another.startingRoom)
                && this.endingRoom.equals(another.endingRoom)
                && Room.arrayEquals(this.getRooms(), another.getRooms())){
            return true;
        }
        return false;
    }

    public Room findNextRoom(String nextRoomName){
        nextRoomName = nextRoomName.toLowerCase();
        for(Room room: rooms){
            if(room.getName().toLowerCase().equals(nextRoomName)){
                return room;
            }
        }
        return null;
    }
}
