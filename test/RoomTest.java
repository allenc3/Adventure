import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {


    private static Layout adventure;
    private static Room[] roomArrForTest;

    @Before
    public void setUp() throws Exception{
        Gson gson = new Gson();
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
    public void roomDirection(){
        assertTrue(Direction.arrayEquals(roomArrForTest[1].getDirections(),adventure.getRooms()[1].getDirections()));
    }

    @Test
    public void roomItems(){
        assertArrayEquals(new String[]{"pizza", "swag"},adventure.getRooms()[2].getItems());
    }

    @Test
    public void roomEquals(){
        assertTrue(roomArrForTest[0].equals(adventure.getRooms()[0]));
    }

    @Test
    public void roomArrayEquals(){
        assertTrue(Room.arrayEquals(roomArrForTest, adventure.getRooms()));
    }

}