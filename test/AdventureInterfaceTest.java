import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AdventureInterfaceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void checkArgsFalse(){
        System.setOut(new PrintStream(outContent));
        String[] empty = new String[0];
        assertFalse(AdventureInterface.checkArgs(empty));
        assertEquals("No arguments entered!\r\n", outContent.toString());
    }

    @Test
    public void checkArgsTrue(){
        String[] empty = new String[1];
        assertTrue(AdventureInterface.checkArgs(empty));

    }
}