import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
//        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
//        Main.sortGodun(list);
//        list.stream().forEach(System.out::println);
        List<Integer> kononovList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        Main.sortKononov(kononovList);
        kononovList.stream().forEach(System.out::println);
    }

    private static List<Integer> sortKononov(List<Integer> list) {
        for (int size = list.size(); size > 0; size--) {
            for (int i = 0; i < size - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    Main.swap(list, i, i + 1);
                }
            }
        }
        return list;
    }

    private static void swap(List<Integer> list, Integer index1, Integer index2) {
        Integer tempI = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tempI);
    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
