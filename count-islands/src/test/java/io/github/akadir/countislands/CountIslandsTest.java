package io.github.akadir.countislands;

import io.github.akadir.couıntislands.CountIslands;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 23:30
 */
public class CountIslandsTest {
    private CountIslands countIslands;

    @Before
    public void init() {
        countIslands = new CountIslands();
    }

    @Test
    public void testCountIslands() {
        int [][] graph = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        Assert.assertEquals(5, countIslands.countIslands(graph));

        graph = new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        Assert.assertEquals(4, countIslands.countIslands(graph));

        graph = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        Assert.assertEquals(1, countIslands.countIslands(graph));
    }
}
