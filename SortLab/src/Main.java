import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        Main.sortGodun(list);
        list.stream().forEach(System.out::println);
        //List<Integer> yourSurnameList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        //Main.sortYourSurname(list);
        //list.stream().forEach(System.out::println);
    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

//test: some method
}
