import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

<<<<<<< HEAD
=======
import static java.util.stream.Collectors.averagingDouble;
>>>>>>> Solopov
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        Main.sortGodun(list);
        list.stream().forEach(System.out::println);
<<<<<<< HEAD
        //List<Integer> yourSurnameList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        //Main.sortYourSurname(list);
        //list.stream().forEach(System.out::println);
=======

        List<Integer> solopovList = IntStream.iterate(0, i -> new Random().nextInt()).limit(20).boxed().collect(toList());
        com.company.Main.sortSolopov(solopovList);
        solopovList.stream().forEach(System.out::println);
>>>>>>> Solopov
    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
    }


<<<<<<< HEAD
=======
    private static List<Integer> sortSolopov(List<Integer> list){ //selection sort
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



>>>>>>> Solopov
}
