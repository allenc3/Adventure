
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
    TestingStrings test;

    @Before
    public void setUp() {
        test = new TestingStrings();
        adventure = test.getAdventure();
        game = new AdventureGame();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

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
    public void determineNextRoomSuccess(){
        Room nextRoom = game.findNextRoom(adventure, adventure.getRooms()[0],
                "go east");
        assertTrue(adventure.getRooms()[1].equals(nextRoom));
    }

    @Test
    public void determineNextRoomFail(){
        game.findNextRoom(adventure, adventure.getRooms()[0],
                "go west");
        assertEquals("I can't go west" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void determineNextRoomFailOutput(){
        game.findNextRoom(adventure, adventure.getRooms()[0],
                "go WESTYYYY   YYYYYY");
        assertEquals("I can't go WESTYYYY   YYYYYY" + System.getProperty("line.separator"),
                outContent.toString());
    }

    // Take items null test implemented in a similar way.
    @Test
    public void determineNextRoomLayoutNull(){
        try {
            game.findNextRoom(null, adventure.getRooms()[0],
                    "go SOUTH");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void determineNextRoomNullRoom(){
        try {
            game.findNextRoom(adventure, null, "go SOUTH");
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void determineNextRoomStringNull(){
        try {
            game.findNextRoom(adventure, adventure.getRooms()[1], null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void takeItemSuccess(){
        ArrayList<Item> tempInventory = new ArrayList<>();
        game.takeItem(adventure.getRooms()[0], "take sword", adventure.getPlayer());
        assertTrue(tempInventory.get(0).getName().equalsIgnoreCase("sword"));
        assertTrue(adventure.getRooms()[0].getItems().size() == 0);
    }

    @Test
    public void takeItemFail(){
        ArrayList<Item> tempInventory = new ArrayList<>();
        game.takeItem(adventure.getRooms()[0], "take RANDOM", adventure.getPlayer());
        assertEquals("I can't take RANDOM" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void dropItemSuccess(){

        ArrayList<Item> tempInventory = new ArrayList<>();
        Item Allen = new Item("Allen", 30.0);
        tempInventory.add(Allen);
        game.dropItem(adventure.getRooms()[0], "drop Allen", adventure.getPlayer());
        assertTrue(adventure.getRooms()[0].getItems().get(1).getName().equals("Allen"));
        assertTrue(tempInventory.size() == 0);
    }

    @Test
    public void dropItemFail(){
        ArrayList<Item> tempInventory = new ArrayList<>();
        game.dropItem(adventure.getRooms()[0], "drop random", adventure.getPlayer());
        assertEquals("I can't drop random" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void printOneItemsList(){
        ArrayList<Item> tempInventory = new ArrayList<>();
        Item Allen = new Item("Allen", 30.0);
        tempInventory.add(Allen);
        adventure.getPlayer().addItem(Allen);
        assertEquals("You are carrying Allen" + System.getProperty("line.separator"),
                outContent.toString());

    }

    @Test
    public void printEmptyList(){
        ArrayList<Item> tempInventory = new ArrayList<>();
        adventure.getPlayer().printList();
        assertEquals("You are carrying nothing." + System.getProperty("line.separator"),
                outContent.toString());

    }

    @Test
    public void printTwoItemsList(){
        ArrayList<Item> tempInventory = new ArrayList<>();
        Item Allen = new Item("Allen", 30.0);
        tempInventory.add(Allen);
        Item Eric = new Item("Eric", 1.0);
        tempInventory.add(Allen);
        tempInventory.add(Eric);
        adventure.getPlayer().addItem(Allen);
        adventure.getPlayer().addItem(Eric);
        adventure.getPlayer().printList();
        assertEquals("You are carrying Allen and Eric" +
                        System.getProperty("line.separator"), outContent.toString());

    }

    @Test
    public void printThreeItemsList(){
        Item Allen = new Item("Allen", 30.0);
        Item Eric = new Item("Eric", 1.0);
        Item Paul = new Item("Paul", 0.5);
        adventure.getPlayer().addItem(Allen);
        adventure.getPlayer().addItem(Eric);
        adventure.getPlayer().printList();
        adventure.getPlayer().addItem(Paul);
        assertEquals("You are carrying Allen, Eric, and Paul" +
                        System.getProperty("line.separator"), outContent.toString());

    }

    @Test
    public void responseToInvalidInput(){
        game.responseToInvalidInput("CS126 is so fun!");
        assertEquals("I don't understand 'CS126 is so fun!'"+
                        System.getProperty("line.separator"), outContent.toString());
    }

    @Test
    public void responseToInvalidInputSpace(){
        game.responseToInvalidInput("   ");
        assertEquals("I don't understand '   '"+
                System.getProperty("line.separator"), outContent.toString());
    }

    // Testing outputs
    @Test
    public void testStartingRoom(){
        game.proceedWithAdventure(adventure.getRooms()[0], adventure.getStartingRoom(),
                adventure.getEndingRoom());
        assertEquals("You are on Matthews, outside the Siebel Center\r\n" +
                        "Your journey begins here.\r\n" +
                        "This room contains: coin\r\n" +
                        "From here, you can go: East\r\n",
                outContent.toString());
    }

    @Test
    public void testRandomRoom(){
        game.proceedWithAdventure(adventure.getRooms()[1], adventure.getStartingRoom(),
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




}