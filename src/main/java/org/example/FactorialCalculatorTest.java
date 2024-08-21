import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();

        Assert.assertEquals(calculator.calculateFactorial(0), 1);
        Assert.assertEquals(calculator.calculateFactorial(1), 1);
        Assert.assertEquals(calculator.calculateFactorial(5), 120);
        Assert.assertEquals(calculator.calculateFactorial(10), 3628800);
    }
}