import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdventureInterfaceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static Layout layoutObjForTest;

    @Before
    public void setUp() throws Exception{
        Gson gson = new Gson();
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
                "          \"directionName\": \"WHERE?\",\n" +
                "          \"room\": \"WHEREYOUGOING\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"AcmOffice\",\n" +
                "      \"description\": \"You are in the ACM office.  " +
                "There are lots of friendly ACM people.\",\n" +
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
                "      \"description\": \"You are in the north hallway.  " +
                "You can see Siebel 1112 and the door toward NCSA.\",\n" +
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
                "      \"description\": \"You are in Siebel 1112.  " +
                "There is space for two code reviews in this room.\",\n" +
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
                "      \"description\": \"You are in the east hallway. " +
                " You can see Einstein Bros' Bagels and a stairway.\",\n" +
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
                "      \"description\": \"You are in Siebel 1314.  " +
                "There are happy CS 126 students doing a code review.\",\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"North\",\n" +
                "          \"room\": \"SiebelEastHallway\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"SiebelBasement\",\n" +
                "      \"description\": \"You are in the basement of Siebel.  " +
                "You see tables with students working and door to computer labs.\",\n" +
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


    @Test
    public void checkArgsFalse(){
        System.setOut(new PrintStream(outContent));
        String[] empty = new String[0];
        assertFalse(AdventureInterface.checkArgsInput(empty));
        assertEquals("No arguments entered!\r\n", outContent.toString());
    }

    @Test
    public void checkArgsTrue(){
        String[] empty = new String[1];
        assertTrue(AdventureInterface.checkArgsInput(empty));

    }

    @Test
    public void connectingRooms(){
        ArrayList<String> tracker = new ArrayList<String>();
        Layout.roomConnectedToStartingRoom(tracker, layoutObjForTest, layoutObjForTest.getRooms()[0]);
        for (String hi: tracker){
            System.out.println(hi);
        }
    }
}