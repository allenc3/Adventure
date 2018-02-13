import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

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
    public void getName(){
        assertEquals("Allen", adventure.getPlayer().getName());
    }

    @Test
    public void getAttack(){
        assertEquals(5, adventure.getPlayer().getAttack(), 0.1);
    }

    @Test
    public void getDefense(){
        assertEquals(5, adventure.getPlayer().getDefense(), 0.1);
    }

    @Test
    public void getHealth(){
        assertEquals(15, adventure.getPlayer().getHealth(), 0.1);
    }

    @Test
    public void getAndSetOriginalHealth(){
        adventure.getPlayer().setOriginalHealth();
        assertEquals(15, adventure.getPlayer().getOriginalHealth(), 0.1);
    }

    @Test
    public void getLevel(){
        assertEquals(1, adventure.getPlayer().getLevel());
    }

    @Test
    public void getExperience(){
        assertEquals(0, adventure.getPlayer().getExperience());
    }

    @Test
    public void takeDmage(){
        adventure.getPlayer().takeDamage(5);
        assertEquals(10, adventure.getPlayer().getHealth(), 0.1);
    }

    @Test
    public void addItem(){
        Item gun = new Item("gun",20);
        adventure.getPlayer().addItem(gun);
        assertTrue(adventure.getPlayer().getItems().get(1).equals(gun));
    }

    @Test
    public void removeItem(){
        adventure.getPlayer().removeItem(0);
        assertTrue(adventure.getPlayer().getItems().size() == 0);
    }

    @Test
    public void findItem(){
        Item fist = new Item("fist", 1);
        assertTrue(fist.equals(adventure.getPlayer().findItem("fist")));
    }

    @Test
    public void findItemNull(){
        try{
            adventure.getPlayer().findItem(null);
            findItem();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void levelUp(){
        adventure.getPlayer().levelUp();
        assertEquals(2, adventure.getPlayer().getLevel());
    }

    @Test
    public void printLevelUp() {
        adventure.getPlayer().printLevelUp();
        assertEquals("Level up!\r\n" +
                "You are now level 1\r\n" +
                "Health: 0.0 Attack: 5.0 Defense: 5.0\r\n\r\n", outContent.toString());
    }

    @Test
    public void addExp(){
        adventure.getPlayer().addExp(10);
        assertEquals(10, adventure.getPlayer().getExperience());
    }

    @Test
    public void printPlayerInfo(){
        adventure.getPlayer().printPlayerInfo();
        assertEquals("You are Allen\r\n" +
                "Level: 1\r\n" +
                "Health: 15.0\r\n" +
                "Attack: 5.0\r\n" +
                "Defense: 5.0\r\n", outContent.toString());
    }

    @Test
    public void printOneItemsList(){
        adventure.getPlayer().printList();
        assertEquals("You are carrying fist", outContent.toString());
    }

    @Test
    public void printEmptyList(){
        adventure.getPlayer().removeItem(0);
        adventure.getPlayer().printList();
        assertEquals("You are carrying nothing.", outContent.toString());

    }

    @Test
    public void printTwoItemsList(){
        Item Allen = new Item("Allen", 30.0);
        adventure.getPlayer().addItem(Allen);
        adventure.getPlayer().printList();
        assertEquals("You are carrying fist and Allen", outContent.toString());

    }

    @Test
    public void printThreeItemsList(){
        Item Allen = new Item("Allen", 30.0);
        Item Eric = new Item("Eric", 1.0);
        adventure.getPlayer().addItem(Allen);
        adventure.getPlayer().addItem(Eric);
        adventure.getPlayer().printList();
        assertEquals("You are carrying fist, Allen, and Eric", outContent.toString());

    }



}