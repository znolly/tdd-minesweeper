

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Write a description of MineTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineTest {
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    Mine mine;
    
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
    public void tesPositionFromMineInZeroZero() {
        mine = new Mine(0, 0);
        String pos = mine.getPosition();
        assertEquals("0, 0", pos);
    }
    
    @Test
    public void tesPositionFromMineInZeroOne() {
        mine = new Mine(0, 1);
        String pos = mine.getPosition();
        assertEquals("0, 1", pos);
    }
}
