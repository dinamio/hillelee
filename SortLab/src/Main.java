package SortLab.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = fillingList();
        Main.sortGodun(list);

        //sortNosach(list);
        //sortSolopov(list);
        //Main.sortBondarenko(list, 0, list.size() - 1);
        //sortKyrychenko(list);
        //recQuickSortKuznetsov(list);
        //bubbleSortBorysov(list);

        list.stream().forEach(System.out::println);


	List<Integer> listRubnskyi = new ArrayList<>();
        fillUnsortedList(listRubnskyi);
        sortRubinskyi(listRubnskyi);  
    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    private static List<Integer> fillingList() {
        return IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
    }


 private static List<Integer> sortSolopov(List<Integer> list){
        int temp, j;
        for(int i = 0; i < list.size() - 1; i++){
            if (list.get(i) > list.get(i+1)) {
                temp = list.get(i+1);
                list.set(i+1, list.get(i));
                j = i;
                while (j > 0 && temp < list.get(j-1)) {
                    list.set(j,list.get(j - 1));
                    j--;
                }
                list.set(j,temp);
      }
        }
        return list;
    }

    //сортировка вставками
    public static List<Integer> sortNosach (List<Integer> list){

        for (int i = 1; i< list.size(); i++){

            for (int j=0; j<i; j++){
                if (list.get(i) < list.get(j)){
                    Integer tmp = list.get(i);
                    list.remove(i);
                    list.add(j, tmp);
                    break;
                }
            }
        }
        return list;
    }

    // insertion sort
    private static List<Integer> sortKyrychenko(List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j - 1) > list.get(j)) {
                    Integer temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
      
    // quick sort
    public static void sortBondarenko(List<Integer> list, int start, int end) {
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
            sortBondarenko(list, start, j);
        if (i < end)
            sortBondarenko(list, i, end);
    }

    public static List recQuickSortKuznetsov(List<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }

        ArrayList lesser = new ArrayList<>();
        ArrayList greater = new ArrayList<>();
        int lastElementPos = list.size()-1;
        int pivot = list.get(lastElementPos);

        for (int i = 0; i < lastElementPos; i++) {
            if (list.get(i) < (pivot)) {
                lesser.add(list.get(i));
            } else {
                greater.add(list.get(i));
            }
        }

        lesser = (ArrayList) recQuickSortKuznetsov(lesser);
        greater = (ArrayList) recQuickSortKuznetsov(greater);

        lesser.add(pivot);
        lesser.addAll(greater);

        return lesser;
    }

    public static List<Integer> bubbleSortBorysov (List<Integer> list){

        for (int barrier =0; barrier < list.size() ; barrier++){
            for (int index=0; index < barrier; index++){

                if (list.get(index) > list.get(barrier)){
                    Integer tmp = list.get(index);
                    list.set(index,  list.get(barrier));
                    list.set(barrier, tmp);
                }
            }
        }
        return list;
    }


/*DONT COPY AFTER ME PLZ*/
    private static void fillUnsortedList(List<Integer> list) {
        int length = 20;
        for (int i = 0; i < length; i++) {
            list.add(new Random().nextInt(51) - 25); /*[-25;25]*/ }
        System.out.println("Unsorted list Rubinskyi: \n" + list); }

    private static void sortRubinskyi(List<Integer> list) {
        List<Integer> first = new ArrayList<>(list.size() / 2);
        for (int i = 0; i < list.size() / 2; i++) {
            first.add(list.get(i));   }
        List<Integer> last = new ArrayList<>(list.size() / 2);
        for (int i = list.size() / 2; i < list.size(); i++) {
            last.add(list.get(i)); }

        new Thread(() -> bubbleSort(first)).start();
        new Thread(() -> bubbleSort(last)).start();
        for (int i = 0; i < 100500; i++) { } /*TODO make normal synchronization*/

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

    public static void quickSortVS(List<Integer> arr) {
        realQuickSortVS(arr, 0, arr.size()-1);
    }

    private static void realQuickSortVS(List<Integer> arr, int p, int r) {
        if(p < r) {
            /* PARTITION */
            Integer x = arr.get(r);
            Integer i = p - 1;
            for(int j = p; j <= r - 1; j++) {
                if(arr.get(j) <= x) {
                    i++;
                    /* EXCHANGE */
                    int tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
            /* EXCHANGE */
            int tmp = arr.get(i+1);
            arr.set(i+1, arr.get(r));
            arr.set(r, tmp);
            /* PARTITION END */
            int q = i + 1;
            realQuickSortVS(arr, p, q - 1);
            realQuickSortVS(arr, q + 1, r);
        }
    }

}
