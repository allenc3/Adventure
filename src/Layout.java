import java.util.ArrayList;
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

//    /**
//     * Custom equals to method to compare two Layout objects.
//     * @param another another Layout object
//     * @return true if two Layout objects are equal, false otherwise.
//     * @throws IllegalArgumentException if input is null
//     */
//    public boolean equals(Layout another){
//        if(another == null) {
//            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
//        }
//
//        if(this.startingRoom.equals(another.startingRoom)
//                && this.endingRoom.equals(another.endingRoom)
//                && Room.arrayEquals(this.getRooms(), another.getRooms())){
//            return true;
//        }
//        return false;
//    }

    /**
     * Method to find next room based on the name of a room.
     * @param nextRoomName room to be found
     * @return the room if it is found, null otherwise.
     * @throws IllegalArgumentException if nextRoomName is null
     */
    public Room findNextRoom(String nextRoomName){
        if(nextRoomName == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        nextRoomName = nextRoomName.toLowerCase();
        for(Room room: rooms){
            if(room.getName().toLowerCase().equals(nextRoomName)){
                return room;
            }
        }
        return null;
    }

    /**
     * Adds the name of the all rooms that are reachable from the starting room in the arraylist
     * @param reachableRooms arraylist of reachable rooms
     * @param adventure the layout to be validated
     * @param startingRoom the starting room object
     * @throws IllegalArgumentException if adventure or reachableRooms is null
     */
    public static void roomConnectedToStartingRoom(ArrayList<String> reachableRooms,
                                                   Layout adventure, Room startingRoom){
        if(reachableRooms == null || adventure == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        // If next room cannot be found(null), then terminate.
        if(startingRoom == null){
            return;
        }

        // Adds the first room encountered
        reachableRooms.add(startingRoom.getName());

        // Recurse through all possible rooms connected to the starting room. Skips if the room has
        // been traversed before, else add it in arraylist.
        for (int i = 0; i < startingRoom.getDirections().length; i++) {
            if(!reachableRooms.contains(startingRoom.getDirections()[i].getRoom())){
                roomConnectedToStartingRoom(reachableRooms, adventure,
                        adventure.findNextRoom(startingRoom.getDirections()[i].getRoom()));

            }
        }
    }

    /**
     * Determines if ending room is reachable from starting room.
     * @param adventure the layout to be validated
     * @return true if ending room can be reached, false otherwise.
     * @throws IllegalArgumentException if adventure is null
     */
    public static boolean endingRoomReachable(Layout adventure){
        if(adventure == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        // Initializes starting room.
        Room startingRoom = null;
        for (int i = 0; i < adventure.getRooms().length; i++) {
            if(adventure.getRooms()[i].getName().equals(adventure.getStartingRoom())){
                startingRoom = adventure.getRooms()[i];
            }
        }

        ArrayList<String> reachableRooms = new ArrayList<String>();
        roomConnectedToStartingRoom(reachableRooms, adventure, startingRoom);

        // Checks if the ending room is in the arraylist of reachableRooms.
        //If not, then ending room is not reachable.
        for(String roomName: reachableRooms){
            if(roomName.equals(adventure.getEndingRoom())){
                return true;
            }
        }
        return false;
    }

    /**
     * All rooms should connect to each other.
     * @param adventure map to be validated
     * @return true if rooms are connected, false otherwise.
     */
    public static boolean validateFloorPlan(Layout adventure){
        // Loops through all rooms
        for (int i = 0; i < adventure.getRooms().length; i++) {
            // Gets a connected room
            for (int j = 0; j < adventure.getRooms()[i].getDirections().length; j++) {
                Room nextRoom = adventure.findNextRoom(adventure.getRooms()[i].
                        getDirections()[j].getRoom());
                boolean roomsConnect = false;
                // Check if the connected room has the CURRENT room in the room array

                for (int k = 0; k < nextRoom.getDirections().length; k++) {

                    if(nextRoom.getDirections()[k].getRoom().equals(adventure.
                            getRooms()[i].getName())){
                        roomsConnect = true;
                    }
                }
                // If not, rooms do not connect.
                if(!roomsConnect){
                    return false;
                }
            }
        }
        return true;
    }
}
