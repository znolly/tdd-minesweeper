

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Write a description of MineFieldTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineFieldTest {
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testPrintAllMineField3Rows3Cols2Mines() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        MineField minefield = new MineField(3, 3, 2);
        
        try {
            minefield.printAllGrid();
            String printedOutput = outputStream.toString();
            String expectedOutput = """
                1 2 * 
                1 * 2 
                1 1 1 
                """;
            assertEquals(expectedOutput, printedOutput);
        } finally {
            System.setOut(originalOut);
        }
    }
}
