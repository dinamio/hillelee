import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sort sort=new Sort();
        Random rand = new Random();
        List list= new LinkedList<Integer>();
        for (int i=0;i<10;i++) list.add(rand.nextInt(100));
        sort.bubbleSort(list);


    }
}
