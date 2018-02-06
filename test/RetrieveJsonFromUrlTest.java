import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class RetrieveJsonFromUrlTest {

    /**
     * Code below derived from:
     * https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void validUrl(){
        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        assertTrue(RetrieveJsonFromUrl.urlIsValid(url));
    }

    @Test
    public void unirestException(){
        // no u in courses
        String unirestErrorUrl = "https://corses.engr.illinois.edu/cs126/adventure/siebel.json";
        RetrieveJsonFromUrl.urlIsValid(unirestErrorUrl);
        assertEquals("Network not responding" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void malformedUrlException(){
        // Missing h in http
        String malformedErrorUrl = "ttps://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        RetrieveJsonFromUrl.urlIsValid(malformedErrorUrl);
        assertEquals("Bad URL: " + malformedErrorUrl + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void faultyUrl(){
        // Missing j in json
        String malformedErrorUrl = "https://courses.engr.illinois.edu/cs126/adventure/siebel.son";
        RetrieveJsonFromUrl.urlIsValid(malformedErrorUrl);
        assertEquals("Bad URL: " + malformedErrorUrl + System.getProperty("line.separator"),
                outContent.toString());
    }


    @Test
    public void nullUrl(){
        try{
            RetrieveJsonFromUrl.urlIsValid(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }



    /**
     * Difference only in line separator(CRLF windows, LF unix, CR mac) so had to use replaceall method.
     */
    @Test
    public void stringRetrieverTest() throws MalformedURLException, UnirestException{
        assertEquals("{\n" +
                        "  \"startingRoom\": \"MatthewsStreet\",\n" +
                        "  \"endingRoom\": \"Siebel1314\",\n" +
                        "  \"rooms\": [\n" +
                        "    {\n" +
                        "      \"name\": \"MatthewsStreet\",\n" +
                        "      \"description\": \"You are on Matthews, outside the " +
                        "Siebel Center\",\n" +
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
                        "      \"description\": \"You are in the west entry of Siebel Center.  " +
                        "You can see the elevator, the ACM office, and hallways " +
                        "to the north and east.\",\n" +
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
                        "      \"description\": \"You are in the east hallway.  " +
                        "You can see Einstein Bros' Bagels and a stairway.\",\n" +
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
                        "}".replaceAll("\n", "").replaceAll("\r", ""),
                RetrieveJsonFromUrl.convertUrlToString(RetrieveJsonFromUrl.url).
                        replaceAll("\r", ""));
    }
}