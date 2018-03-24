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
    }

    private static List<Integer> sortGodun(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    //сортировка вставками
    public static List<Integer> sortNosach (List<Integer> inputList){
        List<Integer> resultList = new LinkedList<>();
        resultList.add(inputList.get(0));

        for (int i = 1; i< inputList.size(); i++){

            int sizeResult = resultList.size(); // size - в отдельной переменной т.к. во внутреннем цикле он может поменятся

            for (int j=0; j<sizeResult; j++){
                if (inputList.get(i) < resultList.get(j)){
                    resultList.add(j, inputList.get(i));
                    break;
                }
                if (j == resultList.size()-1){
                    resultList.add(inputList.get(i));
                }
            }
        }
        inputList.clear();
        inputList.addAll(resultList);
        return inputList;
    }


}
