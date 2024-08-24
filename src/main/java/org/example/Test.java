import org.testng.Assert;
import org.testng.annotations.Test;
package org.example;

public class Test {
    @Test
    public void testFactorialPositiveNumber() {
        Assert.assertEquals(Factorial.factorial(5), 120);
    }

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(Factorial.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        Factorial.factorial(-1);
    }
}
