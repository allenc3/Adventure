import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RoomTest {


    private static Layout adventure;
    private static Room[] roomArrForTest;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception{

        Gson gson = new Gson();
        System.setOut(new PrintStream(outContent));

        adventure = gson.fromJson(JsonStringRetriever
                .convertUrlToString(JsonStringRetriever.url), Layout.class);
        roomArrForTest = gson.fromJson("[\n" +
                "    {\n" +
                "      \"name\": \"MatthewsStreet\",\n" +
                "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
                "      \"items\": [\"coin\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"East\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"SiebelEntry\",\n" +
                "      \"description\": \"You are in the west entry of Siebel Center.  You can " +
                "see the elevator, the ACM office, and hallways to the north and east.\",\n" +
                "\t  \"items\": [\"sweatshirt\", \"key\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"West\",\n" +
                "          \"room\": \"MatthewsStreet\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"directionName\": \"Northeast\",\n" +
                "          \"room\": \"AcmOffice\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"directionName\": \"North\",\n" +
                "          \"room\": \"SiebelNorthHallway\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"directionName\": \"East\",\n" +
                "          \"room\": \"SiebelEastHallway\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"AcmOffice\",\n" +
                "      \"description\": \"You are in the ACM office.  There are lots " +
                "of friendly ACM people.\",\n" +
                "      \"items\": [\"pizza\", \"swag\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"South\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"SiebelNorthHallway\",\n" +
                "      \"description\": \"You are in the north hallway.  You can see " +
                "Siebel 1112 and the door toward NCSA.\",\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"South\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        }, \n" +
                "        {\n" +
                "          \"directionName\": \"NorthEast\",\n" +
                "          \"room\": \"Siebel1112\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Siebel1112\",\n" +
                "      \"description\": \"You are in Siebel 1112.  There is space for two " +
                "code reviews in this room.\",\n" +
                "      \"items\": [\"USB-C connector\", \"grading rubric\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"West\",\n" +
                "          \"room\": \"SiebelNorthHallway\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"SiebelEastHallway\",\n" +
                "      \"description\": \"You are in the east hallway.  You can see " +
                "Einstein Bros' Bagels and a stairway.\",\n" +
                "      \"items\": [\"bagel\", \"coffee\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"West\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"directionName\": \"South\",\n" +
                "          \"room\": \"Siebel1314\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"directionName\": \"Down\",\n" +
                "          \"room\": \"SiebelBasement\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Siebel1314\",\n" +
                "      \"description\": \"You are in Siebel 1314.  There are happy " +
                "CS 126 students doing a code review.\",\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"North\",\n" +
                "          \"room\": \"SiebelEastHallway\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"SiebelBasement\",\n" +
                "      \"description\": \"You are in the basement of Siebel.  You see " +
                "tables with students working and door to computer labs.\",\n" +
                "      \"items\": [\"pencil\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"Up\",\n" +
                "          \"room\": \"SiebelEastHallway\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]", Room[].class);
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void roomName(){
        assertEquals("MatthewsStreet",adventure.getRooms()[0].getName());
    }

    @Test
    public void roomDescription(){
        assertEquals("You are in the west entry of Siebel Center.  You can see the " +
                "elevator, the ACM office, and hallways to the north and east.",
                adventure.getRooms()[1].getDescription());
    }

    @Test
    public void roomItems(){
        assertArrayEquals(roomArrForTest[1].getItems(), adventure.getRooms()[1].getItems());
    }

    @Test
    public void roomSetItems(){
        roomArrForTest[0].setItems(new String[]{"hi", "bye"});
        assertArrayEquals(new String[]{"hi", "bye"}, roomArrForTest[0].getItems());
    }

    @Test
    public void roomSetItemsNull(){
        try{
            roomArrForTest[0].setItems(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void roomDirection(){
        assertTrue(Direction.arrayEquals(roomArrForTest[1].getDirections(),adventure.getRooms()[1].getDirections()));
    }

    @Test
    public void roomRemoveItem(){
        roomArrForTest[0].removeItem(0);
        assertArrayEquals(new String[0], roomArrForTest[0].getItems());
    }

    @Test
    public void roomRemoveItemNegativeIndex(){
        try{
            roomArrForTest[0].removeItem(-1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NEGATIVE_INDEX, e.getMessage());
        }
    }

    @Test
    public void roomAddItem(){
        roomArrForTest[0].addItem("Allen");
        assertArrayEquals(new String[]{"coin", "Allen"}, roomArrForTest[0].getItems());
    }

    @Test
    public void roomAddItemNull(){
        try{
            roomArrForTest[0].addItem(null);
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
    public void roomArrayEqualsFirstArrNull(){
        try{
            Room.arrayEquals(roomArrForTest, null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void roomArrayEqualsSecondArrNull(){
        try{
            Room.arrayEquals(null, roomArrForTest);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void roomFindNextDirectionSuccess(){
        Direction test = roomArrForTest[0].findNextDirection("east");
        assertEquals(roomArrForTest[0].getDirections()[0], test);
    }

    @Test
    public void roomFindNextDirectionFail(){
        Direction test = roomArrForTest[0].findNextDirection("northsoutheastwest");
        assertEquals(null, test);
    }

    @Test
    public void roomFindNextDirectionNull(){
        try{
            roomArrForTest[0].findNextDirection(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void roomFindItemIndexSuccess(){
        int test = roomArrForTest[0].findItemIndex("coin");
        assertEquals(0, test);
    }

    @Test
    public void roomFindItemIndexFail(){
        int test = roomArrForTest[0].findItemIndex("notcoin");
        assertEquals(-1, test);
    }

    @Test
    public void roomFindItemIndexNull(){
        try{
            roomArrForTest[0].findItemIndex(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void roomPrintOneItems(){
        roomArrForTest[0].printItemsInRoom();
        assertEquals("This room contains: coin" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void roomPrintMoreItems(){
        roomArrForTest[1].printItemsInRoom();
        assertEquals("This room contains: sweatshirt and key" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void roomPrintNoItems(){
        roomArrForTest[0].removeItem(0);
        roomArrForTest[0].printItemsInRoom();
        assertEquals("This room contains nothing!" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void roomPrintOneDirectionToGo(){
        roomArrForTest[0].printDirectionsToGo();
        assertEquals("From here, you can go: East" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void roomPrintMoreDirectionToGo(){
        roomArrForTest[1].printDirectionsToGo();
        assertEquals("From here, you can go: West, Northeast, North, and East" + System.getProperty("line.separator"),
                outContent.toString());
    }
    
}