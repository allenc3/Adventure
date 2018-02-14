import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class MonsterTest {

    private AdventureGame game;
    private Layout adventure;
    TestingData test;

    @Before
    public void setUp() {
        test = new TestingData();
        adventure = test.getAdventure();
        game = new AdventureGame();
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void getName(){
        assertEquals("Hollow man", adventure.getRooms()[1].getMonstersInRoom().get(0));
    }

    @Test
    public void getAttack(){
        assertEquals(2.0, adventure.getMonsters().get(0).getAttack(), 0.1);
    }

    @Test
    public void getDefense(){
        assertEquals(0.0, adventure.getMonsters().get(0).getDefense(), 0.1);
    }

    @Test
    public void getHealth(){
        assertEquals(5.0, adventure.getMonsters().get(0).getHealth(), 0.1);
    }

    @Test
    public void getOriginalHealth(){
        adventure.getMonsters().get(0).takeDamage(0);
        assertEquals(5.0, adventure.getMonsters().get(0).getOriginalHealth(), 0.1);
    }

    @Test
    public void takeDamage(){
        adventure.getMonsters().get(0).takeDamage(1);
        assertEquals(4.0, adventure.getMonsters().get(0).getHealth(), 0.1);
    }

    @Test
    public void takeNegativeDamage(){
            adventure.getMonsters().get(0).takeDamage(-1);
            assertEquals(5.0, adventure.getMonsters().get(0).getHealth(), 0.1);
    }

    @Test
    public void equals(){
        Gson gson = new Gson();
        Monster dragon = gson.fromJson("{\n" +
                "      \"name\": \"Dragon\",\n" +
                "      \"attack\": 15,\n" +
                "      \"defense\": 10,\n" +
                "      \"health\": 60\n" +
                "    }", Monster.class);
        assertTrue(dragon.equals(adventure.getMonsters().get(9)));
    }

    @Test
    public void equalsNull(){
        try{
            adventure.getMonsters().get(0).equals(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }



}