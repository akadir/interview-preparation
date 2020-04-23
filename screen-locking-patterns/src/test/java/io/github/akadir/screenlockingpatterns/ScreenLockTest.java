package io.github.akadir.screenlockingpatterns;

import io.github.akadir.screenlockingpatterns.ScreenLock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author akadir
 * Date: 23.04.2020
 * Time: 21:00
 */
public class ScreenLockTest {
    ScreenLock sl = new ScreenLock();

    @Test
    public void basics() {
        assertEquals(0, sl.calculateCombinations('A', 10));
        assertEquals(0, sl.calculateCombinations('A', 0));
        assertEquals(0, sl.calculateCombinations('E', 14));
        assertEquals(1, sl.calculateCombinations('B', 1));
        assertEquals(5, sl.calculateCombinations('C', 2));
        assertEquals(8, sl.calculateCombinations('E', 2));
        assertEquals(256, sl.calculateCombinations('E', 4));
    }
}
