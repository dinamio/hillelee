package sorttesting;

import static sorting.SortingAlgorithms.*;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


public class Test {

    public static void main(String[] args) {

        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt(100)).limit(20).boxed().collect(toList());

        System.out.println("Before sorting: "+list.toString());
        sortNosach(list);
        System.out.println("\nAfter sorting: "+list.toString());

    }
}
