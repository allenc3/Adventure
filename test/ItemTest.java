import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ItemTest {

    private AdventureGame game;
    private Layout adventure;
    TestingData test;

    @Before
    public void setUp() {
        test = new TestingData();
        adventure = test.getAdventure();
        game = new AdventureGame();
    }

    @Test
    public void getName(){
        assertEquals("Sword", adventure.getRooms()[0].getItems().get(0).getName());
    }

    @Test
    public void getDamage(){
        assertEquals(3, adventure.getRooms()[0].getItems().get(0).getDamage(), 0.1);
    }

    @Test
    public void itemConstructor(){
        assertTrue(new Item("Sword", 3.0)
                .equals(adventure.getRooms()[0].getItems().get(0)));
    }

    @Test
    public void itemEquals(){
        assertTrue(new Item("Spear", 5.0)
                .equals(adventure.getRooms()[1].getItems().get(0)));
    }

}