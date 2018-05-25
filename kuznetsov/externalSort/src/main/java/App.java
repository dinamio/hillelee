import com.muao.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {

    public static void main(String[] args) {
        List integers = new ArrayList<>(Arrays.asList(-2, 17, 31, -6, 4, 0));

        integers = QuickSort.doQuick(integers);
        integers.forEach(System.out::println);
    }
}
