
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.*;

public class ReadDataFromUrlTest {

    /**
     * Code below derived from:
     * https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    TestingStrings test;
    @Before
    public void setUp(){
        test = new TestingStrings();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(System.out);
    }

    @Test
    public void validUrl(){
        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        assertEquals(test.getAdventureString(),
                ReadDataFromUrl.parseUrlToString(url).replaceAll("\r",""));
    }

    @Test
    public void unirestException(){
        // no u in courses
        String unirestErrorUrl = "https://corses.engr.illinois.edu/cs126/adventure/siebel.json";
        ReadDataFromUrl.parseUrlToString(unirestErrorUrl);
        assertEquals("Network not responding" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void malformedUrlException(){
        // Missing h in http
        String malformedErrorUrl = "ttps://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        ReadDataFromUrl.parseUrlToString(malformedErrorUrl);
        assertEquals("Bad URL: " + malformedErrorUrl + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void faultyUrl(){
        // Missing j in json
        String malformedErrorUrl = "https://courses.engr.illinois.edu/cs126/adventure/siebel.son";
        ReadDataFromUrl.parseUrlToString(malformedErrorUrl);
        assertEquals("Error: 404\r\n" + "Bad URL: " +
                        malformedErrorUrl + System.getProperty("line.separator"),
                outContent.toString());
    }


    @Test
    public void nullUrl(){
        try{
            ReadDataFromUrl.parseUrlToString(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }



    /**
     * Difference only in line separator(CRLF windows, LF unix, CR mac) so used replaceAll method.
     */
    @Test
    public void stringRetrieverTest() {
        assertEquals(test.getAdventureString(),
                ReadDataFromUrl.parseUrlToString(ReadDataFromUrl.url)
                        .replaceAll("\r",""));
    }
}