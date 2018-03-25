import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        Main.sortGodun(list);
        list.stream().forEach(System.out::println);
//        List<Integer> nosachList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
//        Main.sortNosach(nosachList);
//        nosachList.stream().forEach(System.out::println);

//        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
//        Main.sortBondarenko(list, 0, list.size() - 1);
//        list.forEach(System.out::println);



    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
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


}
