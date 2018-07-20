import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 7/20/18.
 */
@RunWith(Parameterized.class)
public class ArithmeticUtilsTesting {

    ArithmeticUtils arithmeticUtils = new ArithmeticUtils();

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return asList(new Object[][]{
                {new Integer[]{2,3},3},{new Integer[]{-2,-3},-2}
        });
    }

    Integer[] array;

    Integer max;

    public ArithmeticUtilsTesting(Integer[]array, Integer max) {
        this.array = array;
        this.max = max;
    }

    @Test
    public void shouldFindMaxInSimpleArray() {
        Integer expectedResult = arithmeticUtils.findMax(array);

        assertEquals(expectedResult, max);
    }

    /*@Test
    public void shouldFindMaxInNegativeArray() {
        Integer[] array = {-2,-3};
        Integer expectedResult = -2;

        Integer max = arithmeticUtils.findMax(array);

        assertEquals(expectedResult, max);
    }*/

    @Test(expected = IllegalArgumentException.class)
    public void shouldFindMaxInEmptyArray() {
        Integer[] array = {};

        arithmeticUtils.findMax(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFindMaxInNullArray() {

        arithmeticUtils.findMax(null);
    }


}
