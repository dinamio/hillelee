import org.junit.Test;
import service.Calculator;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 7/20/18.
 */
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void shouldAdd2And3() {
        Integer expectedResult = 5;

        Integer actualResult = calculator.add(2, 3);

        assertEquals(expectedResult,actualResult);
    }
}
