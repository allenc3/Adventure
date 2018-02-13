import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LayoutTest {

    private Layout adventure;
    private Layout adventureForTest;
    private Layout endingRoomUnreachable;
    private Layout roomsNotConnected;
    TestingData test;

    @Before
    public void setUp() {
        test = new TestingData();
        adventure = test.getAdventure();
        adventureForTest = test.getAdventureCopiedString();
        endingRoomUnreachable = test.getEndingRoomUnreachable();
        roomsNotConnected = test.getRoomsNotConnected();
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
    public void layoutPlayer(){
        assertEquals("Allen", adventure.getPlayer().getName());
    }

    @Test
    public void layoutMonsters(){
        assertEquals(10, adventure.getMonsters().size());
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
    public void roomConnectedToStarting(){
        try{
            adventure.roomConnectedToStartingRoom(null, adventure.getRooms()[0]);
            fail();
        } catch (IllegalArgumentException e) {
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

    @Test
    public void removeMonster(){
        adventure.removeMonster(adventure.getMonsters().get(0));
        assertEquals(9, adventure.getMonsters().size());
    }

    @Test
    public void removeMonsterNull(){
        try{
            adventure.removeMonster(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

}