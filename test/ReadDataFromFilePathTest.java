import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadDataFromFilePathTest {

    private String siebelStringContents;
    TestingData test;

    @Before
    public void setUp() {
        test = new TestingData();
        siebelStringContents = test.getAdventureString();
    }

    @Test
    public void readRelativePathFail(){
        assertEquals(null, ReadDataFromFilePath.readFileWithRelativePath("what"));
    }

    @Test
    public void readRelativePathSuccess(){
        assertEquals(siebelStringContents.replaceAll("\n", ""),
                ReadDataFromFilePath.readFileWithRelativePath("siebel.json")
                        .replaceAll("\n", "")
                        .replaceAll("\r", ""));
    }

    @Test
    public void readAbsolutePathFail(){
        assertEquals(null, ReadDataFromFilePath.readFileWithAbsolutePath("what"));
    }

    @Test
    public void readAbsolutePathSuccess(){
        assertEquals(test.getOldSiebel().replaceAll("\n", ""),
                ReadDataFromFilePath.readFileWithAbsolutePath("C:\\Users\\user\\Desktop" +
                        "\\siebel (4).json")
                        .replaceAll("\n", "")
                        .replaceAll("\r", ""));
    }

    @Test
    public void readFilePathSuccess(){
        assertEquals(test.getOldSiebel().replaceAll("\n", ""),
                ReadDataFromFilePath.readFilePath("C:\\Users\\user\\Desktop\\siebel (4).json")
                        .replaceAll("\n", "")
                        .replaceAll("\r", ""));
    }

    @Test
    public void readFilePathNull(){
        try{
            ReadDataFromFilePath.readFilePath(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }
}