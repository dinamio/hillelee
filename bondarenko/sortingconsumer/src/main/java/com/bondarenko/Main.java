package com.bondarenko;


import com.bondarenko.tasks.SortTask;
import com.bondarenko.utils.SortUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        List<Integer> unsortedList = createUnsortedList(10);

        List<SortTask<List<Integer>>> tasks = new ArrayList<>();
        tasks.add(new SortTask<>(unsortedList, "Quick sort", (p) -> SortUtils.quickSort(p, 0, p.size() -1)));
        tasks.add(new SortTask<>(unsortedList, "Bubble sort", (p) -> SortUtils.bubbleSort(p)));
        tasks.add(new SortTask<>(unsortedList, "Default sort", (p) -> SortUtils.defaultSort(p)));
        tasks.add(new SortTask<>(unsortedList, "Default sort(reverse)", (p) -> SortUtils.defaultSort(p, Comparator.reverseOrder())));
        tasks.forEach(SortTask::doJob);

    }

    private static List<Integer> createUnsortedList(final int count) {
        return IntStream.iterate(0, i -> new Random().nextInt())
                        .limit(count)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
