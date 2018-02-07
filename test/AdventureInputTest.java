import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdventureInputTest {

    private static Layout adventure;
    private static Layout layoutObjForTest;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception{
        Gson gson = new Gson();
        System.setOut(new PrintStream(outContent));

        adventure = gson.fromJson(RetrieveJsonFromUrl.convertUrlToString(RetrieveJsonFromUrl.url),
                Layout.class);
        layoutObjForTest = gson.fromJson("{\n" +
                "  \"startingRoom\": \"MatthewsStreet\",\n" +
                "  \"endingRoom\": \"Siebel1314\",\n" +
                "  \"rooms\": [\n" +
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
                "      \"description\": \"You are in Siebel 1112.  There is space for " +
                "two code reviews in this room.\",\n" +
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
                "  ]\n" +
                "}", Layout.class);
    }
    @After
    public void restore(){
        System.setOut(System.out);
    }

    // takeItem, dropItem, list, and exit is implemented in a similar way
    @Test
    public void goInADirectionCommandNormal(){
        assertTrue(AdventureInput.goInADirectionCommand("go east"));
    }

    @Test
    public void goInADirectionCommandCaps(){
        assertTrue(AdventureInput.goInADirectionCommand("GO EAST"));
    }

    @Test
    public void goInADirectionCommandSpaceBefore(){
        assertTrue(AdventureInput.goInADirectionCommand("   GO EAST"));
    }

    @Test
    public void goInADirectionCommandSpaceAfter(){
        assertTrue(AdventureInput.goInADirectionCommand("GO      EAST"));
    }

    @Test
    public void goInADirectionCommandTabs(){
        assertTrue(AdventureInput.goInADirectionCommand("GO\t EAST"));
    }

    @Test
    public void goInADirectionCommandNewLines(){
        assertTrue(AdventureInput.goInADirectionCommand("GO\n EAST"));
    }

    @Test
    public void goInADirectionCommandStringTooSmall(){
        assertFalse(AdventureInput.goInADirectionCommand("go"));
    }


    @Test
    public void goInADirectionCommandInvalid(){
        assertFalse(AdventureInput.goInADirectionCommand("randomStuff"));
    }

    @Test
    public void goInADirectionCommandEmpty(){
        assertFalse(AdventureInput.goInADirectionCommand(""));
    }

    @Test
    public void goInADirectionCommandNull(){
        try{
            AdventureInput.goInADirectionCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    // goInADirection, takeItem, and dropItem commands are implemented in a similar way.
    @Test
    public void takeItemCommandNormal(){
        assertTrue(AdventureInput.takeItemCommand("take me"));
    }

    @Test
    public void takeItemCommandInvalid(){
        assertFalse(AdventureInput.takeItemCommand("randomStuff"));
    }

    @Test
    public void takeItemCommandNull(){
        try{
            AdventureInput.takeItemCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void dropItemCommandNormal(){
        assertTrue(AdventureInput.dropItemCommand("drop me"));
    }

    @Test
    public void dropItemCommandInvalid(){
        assertFalse(AdventureInput.dropItemCommand("randomStuff"));
    }

    @Test
    public void dropItemCommandNull(){
        try{
            AdventureInput.dropItemCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    // listCommand and exitCommand are implemented in a similar way
    @Test
    public void listCommand(){
        assertTrue(AdventureInput.listCommand("list"));
    }

    @Test
    public void listCommandCaps(){
        assertTrue(AdventureInput.listCommand("LIST"));
    }

    @Test
    public void listCommandSpaceBeforeAndAfter(){
        assertTrue(AdventureInput.listCommand("      list       "));
    }

    @Test
    public void listCommandTabs(){
        assertTrue(AdventureInput.listCommand("list\t"));
    }

    @Test
    public void listCommandInvalid(){
        assertFalse(AdventureInput.listCommand("randomStuff"));
    }

    @Test
    public void listCommandNull(){
        try {
            AdventureInput.listCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void exitCommandForExit(){
        assertTrue(AdventureInput.exitCommand("exit"));
    }

    @Test
    public void exitCommandForQuit(){
        assertTrue(AdventureInput.exitCommand("quit"));
    }

    @Test
    public void exitCommandInvalid(){
        assertFalse(AdventureInput.exitCommand("randomStuff"));
    }

    @Test
    public void exitCommandNull(){
        try {
            AdventureInput.exitCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void determineNextRoomSuccess(){
        Room nextRoom = AdventureInput.determineNextRoom(adventure, adventure.getRooms()[0],
                "go east");
        assertTrue(adventure.getRooms()[1].equals(nextRoom));
    }

    @Test
    public void determineNextRoomFail(){
        Room nextRoom = AdventureInput.determineNextRoom(adventure, adventure.getRooms()[0],
                "go west");
        assertEquals("I can't go west" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void determineNextRoomFailOriginalString(){
        Room nextRoom = AdventureInput.determineNextRoom(adventure, adventure.getRooms()[0],
                "go WESTYYYYYYYYYY");
        assertEquals("I can't go WESTYYYYYYYYYY" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void determineNextRoomFailSpaceBetweenInput(){
        Room nextRoom = AdventureInput.determineNextRoom(adventure, adventure.getRooms()[0],
                "go WESTYYYY   YYYYYY");
        assertEquals("I can't go WESTYYYY   YYYYYY" + System.getProperty("line.separator"),
                outContent.toString());
    }

    // Take items null test implemented in a similar way.
    @Test
    public void determineNextRoomLayoutNull(){
        try {
            AdventureInput.determineNextRoom(null, adventure.getRooms()[0],
                    "go SOUTH");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void determineNextRoomRoomObjNull(){
        try {
            AdventureInput.determineNextRoom(adventure, null, "go SOUTH");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void determineNextRoomStringNull(){
        try {
            AdventureInput.determineNextRoom(adventure, adventure.getRooms()[1], null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void takeItemSuccess(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        AdventureInput.takeItem(adventure.getRooms()[0], "take coin", tempInventory);
        assertTrue(tempInventory.get(0).equals("coin"));
        assertTrue(adventure.getRooms()[0].getItems().length == 0);
    }

    @Test
    public void takeItemFail(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        AdventureInput.takeItem(adventure.getRooms()[0], "take RANDOM", tempInventory);
        assertEquals("I can't take RANDOM" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void dropItemSuccess(){

        ArrayList<String> tempInventory = new ArrayList<String>();
        tempInventory.add("Allen");
        AdventureInput.dropItem(adventure.getRooms()[0], "drop Allen", tempInventory);
        assertTrue(adventure.getRooms()[0].getItems()[1].equals("Allen"));
        assertTrue(tempInventory.size() == 0);
    }

    @Test
    public void dropItemFail(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        AdventureInput.dropItem(adventure.getRooms()[0], "drop random", tempInventory);
        assertEquals("I can't drop random" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printOneItemsList(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        tempInventory.add("Allen");
        AdventureInput.printList(tempInventory);
        assertEquals("You are carrying Allen" + System.getProperty("line.separator"),
                outContent.toString());

    }

    @Test
    public void printEmptyList(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        AdventureInput.printList(tempInventory);
        assertEquals("You are carrying nothing." + System.getProperty("line.separator"),
                outContent.toString());

    }

    @Test
    public void printTwoItemsList(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        tempInventory.add("Allen");
        tempInventory.add("Eric");
        AdventureInput.printList(tempInventory);
        assertEquals("You are carrying Allen and Eric" +
                        System.getProperty("line.separator"), outContent.toString());

    }

    @Test
    public void printThreeItemsList(){
        ArrayList<String> tempInventory = new ArrayList<String>();
        tempInventory.add("Allen");
        tempInventory.add("Eric");
        tempInventory.add("Paul");
        AdventureInput.printList(tempInventory);
        assertEquals("You are carrying Allen, Eric, and Paul" +
                        System.getProperty("line.separator"), outContent.toString());

    }

    @Test
    public void responseToInvalidInput(){
        AdventureInput.responseToInvalidInput("CS126 is so fun!");
        assertEquals("I don't understand 'CS126 is so fun!'"+
                        System.getProperty("line.separator"), outContent.toString());
    }

    @Test
    public void responseToInvalidInputSpaces(){
        AdventureInput.responseToInvalidInput("   ");
        assertEquals("I don't understand '   '"+
                System.getProperty("line.separator"), outContent.toString());
    }





}