import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AdventureOutputTest {

    private static Layout adventure;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();



    @Before
    public void setUp() throws Exception{
        Gson gson = new Gson();

        adventure = gson.fromJson(RetrieveJsonFromUrl.convertUrlToString(RetrieveJsonFromUrl.url),
                Layout.class);
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void testStartingRoom(){
        AdventureOutput.proceedWithAdventure(adventure.getRooms()[0], false,
                adventure.getEndingRoom());
        assertEquals("You are on Matthews, outside the Siebel Center\r\n" +
                        "Your journey begins here.\r\n" +
                        "This room contains: coin\r\n" +
                        "From here, you can go: East\r\n",
                outContent.toString());
    }

    @Test
    public void testNextRoom(){
        AdventureOutput.proceedWithAdventure(adventure.getRooms()[1], true,
                adventure.getEndingRoom());
        assertEquals("You are in the west entry of Siebel Center.  " +
                        "You can see the elevator, the ACM office, " +
                        "and hallways to the north and east.\r\n" +
                        "This room contains: sweatshirt and key\r\n" +
                        "From here, you can go: West, Northeast, North, and East\r\n",
                outContent.toString());
    }

    @Test
    public void testEndingRoom(){
        AdventureOutput.proceedWithAdventure(adventure.getRooms()[6], true,
                adventure.getEndingRoom());
        assertEquals("You are in Siebel 1314.  There are" +
                        " happy CS 126 students doing a code review.\r\n" +
                        "You have reached your final destination!\r\n",
                outContent.toString());
    }

    @Test
    public void testProceedWithAdventureNull(){
        try {
            AdventureOutput.proceedWithAdventure(null, true,
                    adventure.getEndingRoom());
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void testProceedWithEndingRoomNull(){
        try {
            AdventureOutput.proceedWithAdventure(adventure.getRooms()[0], true,
                    null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }
}