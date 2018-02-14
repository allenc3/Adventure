import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DuelTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AdventureGame game;
    private Layout adventure;
    private Duel duel;
    TestingData test;

    @Before
    public void setUp() {
        test = new TestingData();
        adventure = test.getAdventure();
        game = new AdventureGame();
        duel = new Duel();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }


    @Test
    public void duelMonsterNull(){
        try {
            duel.duelMonster(null, null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void attackCommandSuccess(){
        assertTrue(duel.attackCommand("attack"));
    }

    @Test
    public void attackCommandFail(){
        assertFalse(duel.attackCommand("attac"));
    }

    @Test
    public void attackCommandNull(){
        try {
            duel.attackCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }

    }

    @Test
    public void attackWithItemSuccess(){
        assertTrue(duel.attackWithItemCommand("attack with item"));
    }

    @Test
    public void attackWithItemFail(){
        assertFalse(duel.attackWithItemCommand("attackwith item"));
    }

    @Test
    public void attackWithItemComNull(){
        try {
            duel.attackWithItemCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void disengageCommand(){
        assertTrue(duel.disengageCommand("disengage"));
    }

    @Test
    public void disengageCommandFail(){
        assertFalse(duel.disengageCommand("disgage"));
    }

    @Test
    public void disengageCommandNull(){
        try {
            duel.disengageCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void statusCommandSuccess(){
        assertTrue(duel.statusCommand("status"));
    }

    @Test
    public void statusCommandFail(){
        assertFalse(duel.statusCommand("satus"));
    }

    @Test
    public void statusCommandNull(){
        try {
            duel.statusCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void listCommandSuccess(){
        assertTrue(duel.listCommand("list"));
    }

    @Test
    public void listCommandFail(){
        assertFalse(duel.listCommand("lit"));
    }

    @Test
    public void listCommandNull(){
        try {
            duel.listCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void playerInfoCommandSuccess(){
        assertTrue(duel.playerInfoCommand("playerINfo"));
    }

    @Test
    public void playerInfoCommandFail(){
        assertFalse(duel.playerInfoCommand("payerINfo"));
    }

    @Test
    public void playerInfoCommandNull(){
        try {
            duel.playerInfoCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void exitCommandSuccess(){
        assertTrue(duel.exitCommand("exit"));
        assertTrue(duel.exitCommand("quit"));
    }

    @Test
    public void exitCommandFail(){
        assertFalse(duel.exitCommand("exi"));
    }

    @Test
    public void exitCommandNull(){
        try {
            duel.exitCommand(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printActions(){
        duel.printPossibleActions();
        assertEquals("ACTIONS: attack, attack with anItem, disengage, " +
                "status, list, playerInfo, exit\r\n", outContent.toString());
    }

    @Test
    public void attackMonster(){
        duel.attackMonster(adventure.getPlayer(), adventure.getMonsters().get(3));
        assertEquals("Allen attacks Dark Spirit for 0.0 damage!\r\n" +
                "Dark Spirit attacks Allen for 14.0 damage!\r\n", outContent.toString());
    }

    @Test
    public void attackMonsterNull(){
        try {
            duel.attackMonster(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void attackWithItem(){
        duel.attackWithItem(adventure.getPlayer(), adventure.getMonsters().get(3),
                "attack with fist");
        assertEquals("Allen attacks Dark Spirit with fist for 0.0 damage!\r\n" +
                "Dark Spirit attacks Allen for 14.0 damage!\r\n", outContent.toString());
    }

    @Test
    public void attackWithItemNull(){
        try {
            duel.attackWithItem(null, null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printStatus(){
        duel.printStatus(adventure.getPlayer(), adventure.getMonsters().get(0));
        assertEquals("Player's Health: ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ 5.0/5.0\r\n" +
                "Monster's Health: ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ 5.0/5.0\r\n",
                outContent.toString());
    }

    @Test
    public void printStatusNull(){
        try {
            duel.printStatus(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void responseToInvalidInput(){
        duel.responseToInvalidInput("me");
        assertEquals("I don't understand 'me'\r\n",outContent.toString());
    }

    @Test
    public void invalidInputNull(){
        try {
            duel.responseToInvalidInput(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printPlayerHealthBar(){
        duel.printPlayerHealthBar(adventure.getPlayer());
        assertEquals("Player's Health: ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ 5.0/5.0\r\n",
                outContent.toString());
    }

    @Test
    public void printPlayerHealthBarNull(){
        try {
            duel.printPlayerHealthBar(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void printMonsterHealthBar(){
        duel.printMonsterHealthBar(adventure.getMonsters().get(0));
        assertEquals("Monster's Health: ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ 5.0/5.0\r\n",
                outContent.toString());
    }

    @Test
    public void printMonsterHealthBarNull(){
        try {
            duel.printMonsterHealthBar(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void removeMonster() {
        adventure.getMonsters().get(0).takeDamage(100);
        assertTrue(duel.removeMonster(adventure, adventure.getRooms()[1],
                adventure.getMonsters().get(0)));
        assertEquals(9, adventure.getMonsters().size());
        assertEquals(1, adventure.getRooms()[1].getMonstersInRoom().size());
    }

    @Test
    public void removeMonsterNull() {
        try{
            duel.removeMonster(null, null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void levelUp(){
        duel.levelUp(adventure.getPlayer(), adventure.getMonsters().get(0));
        assertEquals(1, adventure.getPlayer().getLevel());
    }

    @Test
    public void levelUpNull(){
        try {
            duel.levelUp(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void expToLevelUp1(){
        assertEquals(25, duel.experienceToLevelUp(1));
    }

    @Test
    public void expToLevelUp3(){
        assertEquals(83, duel.experienceToLevelUp(3));
    }

    @Test
    public void expToLevelUpNeg(){
        try{
            duel.experienceToLevelUp(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.LEVEL_LESS_THAN_ONE, e.getMessage());
        }
    }

    @Test
    public void playerIsAlive() {
        assertTrue(duel.playerIsAlive(adventure.getPlayer(), adventure.getMonsters().get(0)));
    }

    @Test
    public void playerIsAliveNull() {
        try{
            duel.playerIsAlive(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }
}

