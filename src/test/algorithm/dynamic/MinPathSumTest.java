package test.algorithm.dynamic;

import algorithm.dynamic.MinPathSum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinPathSumTest {

    @Test
    public void minPathSumTest() {
        MinPathSum minPathSum = new MinPathSum();
        assertEquals(7, minPathSum.minPathSum(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
