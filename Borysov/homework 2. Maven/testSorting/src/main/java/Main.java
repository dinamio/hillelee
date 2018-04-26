
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.hillel.App.sortBorysov;
import static java.util.stream.Collectors.toList;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        System.out.println(list);
        sortBorysov(list);
        System.out.println(list);
    }
}
