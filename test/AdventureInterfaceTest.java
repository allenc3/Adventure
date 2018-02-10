import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.*;

public class AdventureInterfaceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    TestingStrings test;

    @Before
    public void setUp() {
        test = new TestingStrings();
        System.setOut(new PrintStream(outContent));
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
    public void checkArgsNull(){
        try {
            assertTrue(AdventureInterface.checkArgsInput(null));
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT,e.getMessage());
        }
    }

    @Test
    public void validUrlSuccess(){
        String[] args = {"siebel.json"};
        assertEquals(test.getSiebelFileContents(), AdventureInterface.
                validUrlOrPath(args).replaceAll("\r", ""));
    }

    @Test
    public void validUrlFail(){
        String[] args = {"sieb.json"};
        assertNull(AdventureInterface.validUrlOrPath(args));
        assertEquals("Bad URL: sieb.json" + System.getProperty("line.separator")
                + "Couldn't find file: sieb.json" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void validUrlNull(){
        try{
            AdventureInterface.validUrlOrPath(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void layoutIsValidSuccess(){
        assertTrue(AdventureInterface.layoutIsValid(test.getAdventure()));
    }

    @Test
    public void layoutIsValidFail(){
        assertFalse(AdventureInterface.layoutIsValid(test.getEndingRoomUnreachable()));
        assertEquals("The layout JSON is not valid. The endingRoom " +
                        "cannot be reached from the " +
                        "startingRoom." + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void layoutIsValidNull(){
        try{
            AdventureInterface.layoutIsValid(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void initializeLayout(){
        assertTrue(test.getAdventure().equals(
                AdventureInterface.initializeLayout(test.getSiebelFileContents())));
    }

    @Test
    public void initializeLayoutNull(){
        try{
            AdventureInterface.initializeLayout(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }




}