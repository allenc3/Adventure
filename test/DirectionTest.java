
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;

public class DirectionTest {

    private Layout adventure;
    private Direction[] directionArrForTest;
    TestingStrings test;

    @Before
    public void setUp() {
        test = new TestingStrings();
        adventure = test.getAdventure();
        directionArrForTest = test.getDirectionArrForTest();
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
    public void directionEqualsNull(){
        try{
            directionArrForTest[0].equals(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void directionArrayEquals(){
        assertTrue(Direction.arrayEquals(adventure.getRooms()[3].
                getDirections(), directionArrForTest));
    }

    @Test
    public void arraysEqualsArr1Null(){
        try{
            Direction.arrayEquals(null, directionArrForTest);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void arraysEqualsArr2Null(){
        try{
            Direction.arrayEquals(directionArrForTest, null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

}