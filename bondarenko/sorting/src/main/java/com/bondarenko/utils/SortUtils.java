package com.bondarenko.utils;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtils {

    public static void quickSort(List<Integer> list, int start, int end){
        int i = start;
        int j = end;
        int pivot = list.get(start + (end - start)/2);
        while (i <= j) {
            while (list.get(i) < pivot) { i++; }
            while (list.get(j) > pivot) { j--; }
            if (i <= j) {
                Integer tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort(list, start, j);
        if (i < end)
            quickSort(list, i, end);
    }

    public static void bubbleSort(List<Integer> list){
        for (int i =0; i < list.size(); i++){
            for (int j=0; j < i; j++){
                if (list.get(j) > list.get(i)){
                    Integer tmp = list.get(j);
                    list.set(j,  list.get(i));
                    list.set(i, tmp);
                }
            }
        }
    }

    public static <T extends Comparable<? super T>>  void defaultSort(List<T> list){
        Collections.sort(list);
    }

    public static <T> void defaultSort(List<T> list, Comparator<T> comparator){
        Collections.sort(list, comparator);
    }

    public static void shuffle(List<?> list){
        Collections.shuffle(list);
    }

}
