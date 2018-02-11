import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LayoutTest {

    private Layout adventure;
    private Layout adventureForTest;
    private Layout endingRoomUnreachable;
    private Layout roomsNotConnected;
    TestingStrings test;

    @Before
    public void setUp() {
        test = new TestingStrings();
        adventure = test.getAdventure();
        adventureForTest = test.getAdventureForTest();
        endingRoomUnreachable = test.getEndingRoomUnreachable();
//        roomsNotConnected = test.getRoomsNotConnected();
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
    public void layoutRooms(){
        assertEquals(8, adventure.getRooms().length);
    }

    @Test
    public void layoutFindRoomSuccess(){
        assertTrue(adventure.getRooms()[1].equals(adventureForTest
                .findRoomByRoomName("SiebelEntry")));
    }

    @Test
    public void layoutFindRoomFail(){
        assertEquals(null, adventureForTest.findRoomByRoomName("ISR"));
    }

    @Test
    public void layoutFindRoomNull(){
        try{
            adventureForTest.findRoomByRoomName(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void layoutEquals(){
        assertTrue(adventure.equals(adventureForTest));
    }

    @Test
    public void layoutEqualsNull(){
        try {
            adventure.equals(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }


    @Test
    public void endingRoomReachableTest(){
        assertFalse(endingRoomUnreachable.isEndingRoomReachable());
    }

    @Test
    public void validateFloorPlan(){
        assertTrue(adventure.isFloorPlanValid());
    }

    @Test
    public void validateFloorPlanFail(){
        assertFalse(roomsNotConnected.isFloorPlanValid());
    }

}