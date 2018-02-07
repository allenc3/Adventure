import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LayoutTest {

    private static Layout adventure;
    private static Layout layoutObjForTest;

    @Before
    public void setUp() throws Exception{
        Gson gson = new Gson();
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

    @Test
    public void layoutStartingRoom(){
        assertEquals("MatthewsStreet",adventure.getStartingRoom());
    }

    @Test
    public void layoutEndingRoom(){
        assertEquals("Siebel1314",adventure.getEndingRoom());
    }

    @Test
    public void layoutFindNextRoomSuccess(){
        assertTrue(adventure.getRooms()[1].equals(layoutObjForTest
                .findNextRoom("SiebelEntry")));
    }

    @Test
    public void layoutFindNextRoomFail(){
        assertEquals(null, layoutObjForTest.findNextRoom("ISR"));
    }

    @Test
    public void layoutFindNextRoomNull(){
        try{
            layoutObjForTest.findNextRoom(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

}