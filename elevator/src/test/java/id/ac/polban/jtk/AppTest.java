package id.ac.polban.jtk;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        ElevatorController
            .getInstance()
            .run();

        assertTrue(true);
    }
}
