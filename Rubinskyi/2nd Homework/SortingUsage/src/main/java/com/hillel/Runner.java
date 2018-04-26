package com.hillel;

import java.util.ArrayList;
import java.util.List;

import static com.hillel.BubbleSort.BubbleSort.sortRubinskyi;

public class Runner {
    public static void main(String[] args) {
        List<Integer> listRubnskyi = new ArrayList<>();
        sortRubinskyi(listRubnskyi);
    }
}
