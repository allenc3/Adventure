
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdventureGameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AdventureGame game;
    private Layout adventure;
    TestingData test;

    @Before
    public void setUp() {
        test = new TestingData();
        adventure = test.getAdventure();
        game = new AdventureGame();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void startAdventureGameNull(){
        try{
            game.startAdventureGame(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    // Test commands method
    // takeItem, dropItem, list, and exit is implemented in a similar way
    @Test
    public void goCommandNormal(){
        assertTrue(game.goInADirectionCommand("go east"));
    }

    @Test
    public void goCommandCaps(){
        assertTrue(game.goInADirectionCommand("GO EAST"));
    }

    @Test
    public void goCommandSpaceBefore(){
        assertTrue(game.goInADirectionCommand("   GO EAST"));
    }

    @Test
    public void goCommandSpaceAfter(){
        assertTrue(game.goInADirectionCommand("GO      EAST"));
    }

    @Test
    public void goCommandTabs(){
        assertTrue(game.goInADirectionCommand("GO\t EAST"));
    }

    @Test
    public void goCommandNewLines(){
        assertTrue(game.goInADirectionCommand("GO\n EAST"));
    }

    @Test
    public void goCommandInvalid1(){
        assertFalse(game.goInADirectionCommand("go"));
    }


    @Test
    public void goCommandInvalid2(){
        assertFalse(game.goInADirectionCommand("randomStuff"));
    }

    @Test
    public void goCommandEmpty(){
        assertFalse(game.goInADirectionCommand(""));
    }

    @Test
    public void goCommandNull(){
        try{
            game.goInADirectionCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    // goInADirection, takeItem, and dropItem commands are implemented in a similar way.
    @Test
    public void takeItemCommandNormal(){
        assertTrue(game.takeItemCommand("take me"));
    }

    @Test
    public void takeItemCommandInvalid(){
        assertFalse(game.takeItemCommand("randomStuff"));
    }

    @Test
    public void takeItemCommandNull(){
        try{
            game.takeItemCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void dropItemCommandNormal(){
        assertTrue(game.dropItemCommand("drop me"));
    }

    @Test
    public void dropItemCommandInvalid(){
        assertFalse(game.dropItemCommand("randomStuff"));
    }

    @Test
    public void dropItemCommandNull(){
        try{
            game.dropItemCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    // listCommand and exitCommand are implemented in a similar way
    @Test
    public void listCommand(){
        assertTrue(game.listCommand("list"));
    }

    @Test
    public void listCommandCaps(){
        assertTrue(game.listCommand("LIST"));
    }

    @Test
    public void listCommandSpaces(){
        assertTrue(game.listCommand("      list       "));
    }

    @Test
    public void listCommandTabs(){
        assertTrue(game.listCommand("list\t"));
    }

    @Test
    public void listCommandInvalid(){
        assertFalse(game.listCommand("randomStuff"));
    }

    @Test
    public void listCommandNull(){
        try {
            game.listCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void exitCommandForExit(){
        assertTrue(game.exitCommand("exit"));
    }

    @Test
    public void exitCommandForQuit(){
        assertTrue(game.exitCommand("quit"));
    }

    @Test
    public void exitCommandInvalid(){
        assertFalse(game.exitCommand("randomStuff"));
    }

    @Test
    public void exitCommandNull(){
        try {
            game.exitCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void playerInfoCommandSuccess(){
        assertTrue(game.playerInfoCommand("playerInfo"));
    }

    @Test
    public void playerInfoCommandFail(){
        assertFalse(game.playerInfoCommand("player"));
    }

    @Test
    public void playerInfoNull(){
        try {
            game.playerInfoCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void duelCommandSuccess(){
        assertTrue(game.duelMonsterCommand("duel me"));
    }

    @Test
    public void duelCommandFail(){
        assertFalse(game.duelMonsterCommand("duely"));
    }

    @Test
    public void duelCommandNull(){
        try {
            game.duelMonsterCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printDescriptionSuccess(){
        assertTrue(game.printDescriptionCommand("room description"));
    }

    @Test
    public void printDescriptionFail(){
        assertFalse(game.printDescriptionCommand("roomS description"));
    }

    @Test
    public void printDescriptionCommandNull(){
        try {
            game.printDescriptionCommand(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printActionsTrueInput(){
        game.printPossibleActions(true);
        assertEquals("ACTIONS: go aDirection, take anItem, drop anItem, "
                        + "duel aMonster, list, playerInfo, room description, exit" +
                        System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printActionsFalseInput(){
        game.printPossibleActions(false);
        assertEquals("ACTIONS: drop anItem, "
                        + "duel aMonster, list, playerInfo, room description, exit" +
                        System.getProperty("line.separator"),
                outContent.toString());
    }

    // Testing action methods
    // Test proceedWithAdventure method
    @Test
    public void testStartingRoom(){
        game.proceedWithAdventure(adventure.getRooms()[0], adventure.getStartingRoom(),
                adventure.getEndingRoom());
        assertEquals("You are on Matthews, outside the Siebel Center\r\n" +
                        "Your journey begins here.\r\n" +
                        "This room contains: Sword\r\n" +
                        "There are no monsters in the room!\r\n" +
                        "From here, you can go: East\r\n",
                outContent.toString());
    }

    @Test
    public void testRandomRoom(){
        game.proceedWithAdventure(adventure.getRooms()[1], adventure.getStartingRoom(),
                adventure.getEndingRoom());
        assertEquals("You are in the west entry of Siebel Center.  You can see the " +
                        "elevator, the ACM office, and hallways to the north and east.\r\n" +
                        "This room contains: Spear\r\n" +
                        "Monsters in this room: Hollow man and Skeleton\r\n",
                outContent.toString());
    }

    @Test
    public void testEndingRoom(){
        game.proceedWithAdventure(adventure.getRooms()[6], adventure.getStartingRoom(),
                adventure.getEndingRoom());
        assertEquals("You are in Siebel 1314.  There are" +
                        " happy CS 126 students doing a code review.\r\n" +
                        "You have reached your final destination!\r\n",
                outContent.toString());
    }

    @Test
    public void proceedWithAdventureNull(){
        try {
            game.proceedWithAdventure(null, adventure.getStartingRoom(),
                    adventure.getEndingRoom());
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void proceedWithEndingRoomNull(){
        try {
            game.proceedWithAdventure(adventure.getRooms()[0], adventure.getStartingRoom(),
                    null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void proceedWithStartingRoomNull(){
        try {
            game.proceedWithAdventure(adventure.getRooms()[0], null,
                    adventure.getEndingRoom());
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void findNextRoomSuccess(){
        Room nextRoom = game.findNextRoom(adventure, adventure.getRooms()[0],
                "go east");
        assertTrue(adventure.getRooms()[1].equals(nextRoom));
    }

    @Test
    public void findNextRoomFail(){
        game.findNextRoom(adventure, adventure.getRooms()[0],
                "go west");
        assertEquals("I can't go west" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void findNextRoomFailOutput(){
        game.findNextRoom(adventure, adventure.getRooms()[0],
                "go WESTYYYY   YYYYYY");
        assertEquals("I can't go WESTYYYY   YYYYYY" + System.getProperty("line.separator"),
                outContent.toString());
    }

    // Take items null test implemented in a similar way.
    @Test
    public void findNextRoomLayoutNull(){
        try {
            game.findNextRoom(null, adventure.getRooms()[0],
                    "go SOUTH");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void findNextRoomNullRoom(){
        try {
            game.findNextRoom(adventure, null, "go SOUTH");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void findNextRoomStringNull(){
        try {
            game.findNextRoom(adventure, adventure.getRooms()[1], null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void takeItemSuccess(){
        game.takeItem(adventure.getRooms()[0], "take sword", adventure.getPlayer());
        assertEquals("Sword", adventure.getPlayer().getItems().get(1).getName());
        assertTrue(adventure.getRooms()[0].getItems().size() == 0);
    }

    @Test
    public void takeItemFail(){
        game.takeItem(adventure.getRooms()[0], "take RANDOM", adventure.getPlayer());
        assertEquals("I can't take RANDOM", outContent.toString());
    }

    @Test
    public void takeItemMonstersInRoom(){
        game.takeItem(adventure.getRooms()[1], "take spear", adventure.getPlayer());
        assertEquals("There are still monsters here, I can’t take that."
                , outContent.toString());
    }

    @Test
    public void takeItemNull(){
        try {
            game.takeItem(null, "take RANDOM", adventure.getPlayer());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void dropItemSuccess(){

        game.dropItem(adventure.getRooms()[0], "drop fist", adventure.getPlayer());
        assertTrue(adventure.getRooms()[0].getItems().get(1).getName().equals("fist"));
        assertTrue(adventure.getPlayer().getItems().size() == 0);
    }

    @Test
    public void dropItemFail(){
        game.dropItem(adventure.getRooms()[0], "drop random", adventure.getPlayer());
        assertEquals("I can't drop random", outContent.toString());
    }

    @Test
    public void dropItemNull(){
        try {
            game.dropItem(null, "drop me", adventure.getPlayer());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void duelMonsterFail(){
        game.duelMonster(adventure, adventure.getRooms()[1],"duel hollow ma",
                adventure.getPlayer());
        assertEquals("I can't duel hollow ma\r\n\r\n", outContent.toString());
    }

    @Test
    public void duelMonsterNull(){
        try {
            game.duelMonster(null, adventure.getRooms()[1], null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void responseToInvalidInput(){
        game.responseToInvalidInput("CS126 is so fun!");
        assertEquals("I don't understand 'CS126 is so fun!'", outContent.toString());
    }

    @Test
    public void responseToInvalidInputSpace(){
        game.responseToInvalidInput("   ");
        assertEquals("I don't understand '   '", outContent.toString());
    }

    @Test
    public void responseToInvalidNull(){
        try {
            game.responseToInvalidInput(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void initializeForNull(){
        game.initializeForNullValues(adventure);
        assertEquals(0, adventure.getRooms()[0].getMonstersInRoom().size());
    }

    @Test
    public void initializeForNullError(){
        try {
            game.initializeForNullValues(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }

    }



}