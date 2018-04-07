package com.bondarenko;

import com.bondarenko.utils.PrintUtils;
import com.bondarenko.utils.SortUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        List<Integer> unsortedList = createUnsortedList(10);

        doJob(unsortedList, "Quick sort", (p) -> SortUtils.quickSort(p, 0, p.size() -1));
        doJob(unsortedList, "Bubble sort", (p) -> SortUtils.bubbleSort(p));
        doJob(unsortedList, "Default sort", (p) -> SortUtils.defaultSort(p));
        doJob(unsortedList, "Default sort(reverse)", (p) -> SortUtils.defaultSort(p, Comparator.reverseOrder()));
    }



    private static void doJob(List<Integer> unsortedList, String name, Consumer<List<Integer>> consumer){
        PrintUtils.printDelimiter(name);
        consumer.accept(unsortedList);
        PrintUtils.printCollection(unsortedList);
        SortUtils.shuffle(unsortedList);
    }

    private static List<Integer> createUnsortedList(final int count) {
        return IntStream.iterate(0, i -> new Random().nextInt())
                        .limit(count)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
