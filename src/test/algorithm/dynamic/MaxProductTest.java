package test.algorithm.dynamic;


import algorithm.dynamic.MaxProduct;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxProductTest {

    @Test
    public void testSum() {
        MaxProduct maxProduct = new MaxProduct();
        assertEquals(0, maxProduct.maxProduct(new int[]{-2, 0, -1}));
        assertEquals(6, maxProduct.maxProduct(new int[]{2,3,-2,4}));
    }
}
