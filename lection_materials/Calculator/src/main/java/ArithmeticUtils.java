/**
 * Created by eugen on 7/20/18.
 */
public class ArithmeticUtils {

    public Integer findMax(Integer[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Caanot find max on empty array");
        Integer max = array[0];
        for (Integer i : array) {
            if (i > max)
                max = i;
        }
        return max;
    }
}
