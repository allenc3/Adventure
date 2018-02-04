import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    private static Layout adventure;
    private static Direction[] directionArrForTest;

    @Before
    public void setUp() throws Exception{
        Gson gson = new Gson();
        adventure = gson.fromJson(JsonStringRetriever.
                convertUrlToString(JsonStringRetriever.url), Layout.class);



        directionArrForTest = gson.fromJson("[\n" +
                "        {\n" +
                "          \"directionName\": \"South\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        }, \n" +
                "        {\n" +
                "          \"directionName\": \"NorthEast\",\n" +
                "          \"room\": \"Siebel1112\"\n" +
                "        }\n" +
                "      ]", Direction[].class);
    }

    @Test
    public void directionName(){
        assertEquals("East",adventure.getRooms()[0].getDirections()[0].getDirectionName());
    }

    @Test
    public void directionRoom(){
        assertEquals("MatthewsStreet",adventure.getRooms()[1].getDirections()[0].getRoom());
    }

    @Test
    public void directionEquals(){
        assertTrue(adventure.getRooms()[3].getDirections()[0].equals(directionArrForTest[0]));
    }

    @Test
    public void directionArrayEquals(){
        assertTrue(Direction.arrayEquals(adventure.getRooms()[3].getDirections(), directionArrForTest));
    }

}