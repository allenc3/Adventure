import java.util.ArrayList;

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
    private Player player;
    private ArrayList<Monster> monsters;

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
     * @return player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return arraylist of monsters
     */
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    /**
     * Custom equals for layout object
     * @param another layout object
     * @return true if two layout objects are equal, false otherwise
     */
    public boolean equals(Layout another){
        if (another == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        return this.getStartingRoom().equals(another.getStartingRoom()) &&
                this.getEndingRoom().equals(another.getEndingRoom()) &&
                Room.arrayEquals(this.getRooms(), another.getRooms());
    }

    /**
     * Method to find next room based on the name of a room.
     * @param roomName room to be found
     * @return the room if it is found, null otherwise.
     * @throws IllegalArgumentException if nextRoomName is null
     */
    public Room findRoomByRoomName(String roomName){
        if(roomName == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        roomName = roomName.toLowerCase();
        for(Room room: rooms){
            if(room.getName().toLowerCase().equals(roomName)){
                return room;
            }
        }
        return null;
    }


    /**
     * Adds the name of the all rooms that are reachable from the starting room in the arraylist
     * @param reachableRooms arraylist of reachable rooms
     * @param startingRoom the starting room object
     * @throws IllegalArgumentException if adventure or reachableRooms is null
     */
    public void roomConnectedToStartingRoom(ArrayList<String> reachableRooms, Room startingRoom){
        if(reachableRooms == null) {
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
                roomConnectedToStartingRoom(reachableRooms,
                        this.findRoomByRoomName(startingRoom.getDirections()[i].getRoom()));

            }
        }
    }

    /**
     * Determines if ending room is reachable from starting room.
     * @return true if ending room can be reached, false otherwise.
     * @throws IllegalArgumentException if adventure is null
     */
    public boolean isEndingRoomReachable(){
        // Initializes starting room.
        Room startingRoom = this.findRoomByRoomName(getStartingRoom());

        ArrayList<String> reachableRooms = new ArrayList<>();
        roomConnectedToStartingRoom(reachableRooms, startingRoom);

        // Checks if the ending room is in the arraylist of reachableRooms.
        //If not, then ending room is not reachable.
        for(String roomName: reachableRooms){
            if(roomName.equals(getEndingRoom())){
                return true;
            }
        }
        return false;
    }

    /**
     * All rooms should connect to each other.
     * @return true if rooms are connected, false otherwise.
     */
    public boolean isFloorPlanValid(){
        // Loops through all rooms
        for (int i = 0; i < rooms.length; i++) {
            // Gets a connected room
            for (int j = 0; j < rooms[i].getDirections().length; j++) {
                Room nextRoom = findRoomByRoomName(rooms[i].getDirections()[j].getRoom());
                boolean roomsConnect = false;

                // Check if the connected room has the CURRENT room in the room array
                for (int k = 0; k < nextRoom.getDirections().length; k++) {

                    String originalRoom = getRooms()[i].getName();
                    if(nextRoom.getDirections()[k].getRoom().equals(originalRoom)){
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

    /**
     * Removes monster from monster arraylist
     * @param monster to be removed
     * @throws IllegalArgumentException if monster is null
     */
    public void removeMonster(Monster monster){
        if(monster == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        this.monsters.remove(monster);
    }
}
