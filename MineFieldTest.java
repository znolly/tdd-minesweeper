

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
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    MineField minefield;
    
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
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
    public void testPrintAllMineField3Rows3Cols9Mines() {
        MineField minefield = new MineField(3, 3, 9);
        String expectedOutput = "* * * \r\n* * * \r\n* * * \r\n";
        assertPrintedGrid(minefield, expectedOutput);
    }
    
    @Test
    public void testPrintAllMineField4Rows4Cols16Mines() {
        minefield = new MineField(4, 4, 16);
        String expectedOutput = "* * * * \r\n* * * * \r\n* * * * \r\n* * * * \r\n";
        assertPrintedGrid(minefield, expectedOutput);
    }
    
    private void assertPrintedGrid(MineField mField, String expectedOutput) {
        try {
            mField.printAllGrid();
            String printedOutput = outputStream.toString();
            assertEquals(expectedOutput, printedOutput);
        } finally {
            System.setOut(originalOut);
        }
    }
    
    @Test
    public void testCalculateHintsFromFixedGrid333() {
        Object[][] gridProposed = {
            {0, 0, new Mine(1,2)},          //  0   0   *
            {0, new Mine(2,2), 0},          //  0   *   0
            {new Mine(3,1), 0, 0}           //  *   0   0
        };
        
        minefield = new MineField(gridProposed);
        String expectedOutput = """
            1 2 * \r
            2 * 2 \r
            * 2 1 \r
            """;
        assertPrintedGrid(minefield, expectedOutput);
    }
    
    @Test
    public void testCalculateHintsFromFixedGrid444() {
        Object[][] gridProposed = {
            {0, 0, 0, new Mine(1,2)},          //  0   0   0   *
            {0, 0, new Mine(2,2), 0},          //  0   0   *   0
            {0, new Mine(2,2), 0, 0},          //  0   *   0   0
            {new Mine(3,1), 0, 0, 0}           //  *   0   0   0
        };
        
        minefield = new MineField(gridProposed);
        String expectedOutput = """
            0 1 2 * \r
            1 2 * 2 \r
            2 * 2 1 \r
            * 2 1 0 \r
            """;
        assertPrintedGrid(minefield, expectedOutput);
    }
}
