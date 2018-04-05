package com.hillel.BubbleSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BubbleSort {
    private static void fillUnsortedList(List<Integer> list) {
        int length = 20;
        for (int i = 0; i < length; i++) {
            list.add(new Random().nextInt(51) - 25); /*[-25;25]*/ }
        System.out.println("Unsorted list Rubinskyi: \n" + list); }

    public static void sortRubinskyi(List<Integer> list) {
        fillUnsortedList(list);

        List<Integer> first = new ArrayList<>(list.size() / 2);
        for (int i = 0; i < list.size() / 2; i++) {
            first.add(list.get(i));   }
        List<Integer> last = new ArrayList<>(list.size() / 2);
        for (int i = list.size() / 2; i < list.size(); i++) {
            last.add(list.get(i)); }

        new Thread(() -> bubbleSort(first)).start();
        new Thread(() -> bubbleSort(last)).start();
        for (int i = 0; i < 100500; i++) {int j = 0;} /*TODO make normal synchronization*/

        List<Integer> resultRubinskyi =  mergeSortRubinskyi(first, last);
        System.out.println("Sorted list Rubinskyi \n" + resultRubinskyi); }

    private static void bubbleSort(List<Integer> methodList) {
        int tmp;
        for (int i = methodList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (methodList.get(j) > methodList.get(j + 1)) {
                    tmp = methodList.get(j);
                    methodList.set((j), methodList.get(j + 1));
                    methodList.set(j + 1, tmp); } } } }

    private static List<Integer> mergeSortRubinskyi(List<Integer> first, List<Integer> last) {
        List<Integer> result = new ArrayList<>(first.size() + last.size());
        int i = 0, j = 0;
        for (int k = 0; k < first.size() + last.size(); k++) {
            if (i > first.size() - 1) {
                int a = last.get(j);
                result.add(k, a);
                j++;                    }
            else if (j > last.size() - 1) {
                int a = first.get(i);
                result.add(k, a);
                i++;                        }
            else if (first.get(i) < last.get(j)) {
                int a = first.get(i);
                result.add(k, a);
                i++; }
            else {
                int b = last.get(j);
                result.add(k, b);
                j++; }
        }   return result; }
}
