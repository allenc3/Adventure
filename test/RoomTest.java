import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class RoomTest {


    private Layout adventure;
    private Room[] roomArrForTest;
    TestingData test;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        test = new TestingData();
        adventure = test.getAdventure();
        roomArrForTest = test.getRoomArrForTest();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void roomName(){
        assertEquals("MatthewsStreet",
                adventure.getRooms()[0].getName());
    }

    @Test
    public void roomDescription(){
        assertEquals("You are in the west entry of Siebel Center.  You can see the " +
                "elevator, the ACM office, and hallways to the north and east.",
                adventure.getRooms()[1].getDescription());
    }

    @Test
    public void roomDirection(){
        assertTrue(Direction.arrayEquals(roomArrForTest[1].getDirections(),
                adventure.getRooms()[1].getDirections()));
    }

    @Test
    public void roomItems(){
        assertEquals(roomArrForTest[0].getItems().get(0), "coin");
    }

    @Test
    public void roomSetItems(){
        roomArrForTest[0].setItems();
        assertEquals(0, roomArrForTest[0].getItems().size());
    }

    @Test
    public void roomRemoveItems(){
        roomArrForTest[0].removeItems(0);
        assertEquals(0, roomArrForTest[0].getItems().size());
    }

    @Test
    public void roomRemoveItemsFail(){
        try{
            roomArrForTest[0].removeItems(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.INDEX_OUT_OF_RANGE, e.getMessage());
        }
    }

    @Test
    public void roomAddItems(){
        Item Allen = new Item("Allen", 30.0);
        roomArrForTest[0].addItems(Allen);
        assertEquals(2, roomArrForTest[0].getItems().size());
    }

    @Test
    public void roomAddItemsNull(){
        try {
            roomArrForTest[0].addItems(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void itemsEqual(){
        assertTrue(adventure.getRooms()[0].itemsEquals(roomArrForTest[0].getItems()));
    }

    @Test
    public void itemsEqualNull(){
        try{
            adventure.getRooms()[0].itemsEquals(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }


    @Test
    public void roomEquals(){
        assertTrue(roomArrForTest[0].equals(adventure.getRooms()[0]));
    }

    @Test
    public void roomEqualsNull(){
        try{
            roomArrForTest[0].equals(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void roomArrayEquals(){
        assertTrue(Room.arrayEquals(roomArrForTest, adventure.getRooms()));
    }

    @Test
    public void arrayEqualsFirstArrNull(){
        try{
            Room.arrayEquals(roomArrForTest, null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void arrayEqualsSecondArrNull(){
        try{
            Room.arrayEquals(null, roomArrForTest);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void findDirectionSuccess(){
        Direction test = roomArrForTest[0].findDirection("east");
        assertEquals(roomArrForTest[0].getDirections()[0], test);
    }

    @Test
    public void findDirectionFail(){
        Direction test = roomArrForTest[0].findDirection("northsoutheastwest");
        assertEquals(null, test);
    }

    @Test
    public void findDirectionNull(){
        try{
            roomArrForTest[0].findDirection(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void findItemIndexSuccess(){
        int test = roomArrForTest[0].findItemIndex("coin");
        assertEquals(0, test);
    }

    @Test
    public void findItemIndexFail(){
        int test = roomArrForTest[0].findItemIndex("notcoin");
        assertEquals(-1, test);
    }

    @Test
    public void findItemIndexNull(){
        try{
            roomArrForTest[0].findItemIndex(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printOneItem(){
        roomArrForTest[0].printItemsInRoom();
        assertEquals("This room contains: coin" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printMoreItems(){
        roomArrForTest[1].printItemsInRoom();
        assertEquals("This room contains: sweatshirt and key" +
                        System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printNoItems(){
        roomArrForTest[0].removeItems(0);
        roomArrForTest[0].printItemsInRoom();
        assertEquals("This room contains nothing!" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printOneDirection(){
        roomArrForTest[0].printDirectionsToGo();
        assertEquals("From here, you can go: East" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printMoreDirection(){
        roomArrForTest[1].printDirectionsToGo();
        assertEquals("From here, you can go: West, Northeast, North, and East" +
                        System.getProperty("line.separator"),
                outContent.toString());
    }

}