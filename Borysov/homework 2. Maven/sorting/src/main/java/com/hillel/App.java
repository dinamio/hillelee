package com.hillel;

import java.util.List;


public class App {
    //сортировка пузырьком
    public static List<Integer> sortBorysov(List<Integer> list) {

        for (int barrier = 0; barrier < list.size(); barrier++) {
            for (int index = 0; index < barrier; index++) {

                if (list.get(index) > list.get(barrier)) {
                    Integer tmp = list.get(index);
                    list.set(index, list.get(barrier));
                    list.set(barrier, tmp);
                }
            }
        }
        return list;
    }
}
