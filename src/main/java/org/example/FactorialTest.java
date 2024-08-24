import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
package org.example;

public class FactorialTest {
    @Test
    public void testFactorialPositiveNumber() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void testFactorialZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    public void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
    }
}
