package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortingAlgorithms {



    public static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
    }


    public static List<Integer> sortSolopov(List<Integer> list){
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
    public static List<Integer> sortKyrychenko(List<Integer> list) {

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

        ArrayList lesser = new ArrayList();
        ArrayList greater = new ArrayList();
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

}
