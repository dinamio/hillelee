import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(5, 8, 11, 55, 14, 2, 3, 9, 4);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(integerList);
        integerList.forEach(System.out::println);
    }
}
