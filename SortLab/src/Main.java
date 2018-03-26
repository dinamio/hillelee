import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        Main.sortGodun(list);
        list.stream().forEach(System.out::println);


        List<Integer> solopovList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        sortSolopov(solopovList);
        solopovList.stream().forEach(System.out::println);

//        List<Integer> nosachList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
//        Main.sortNosach(nosachList);
//        nosachList.stream().forEach(System.out::println);

    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
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



}
