import java.util.List;

public class Sort {
    public static List<Integer> selectSort(List<Integer> list){
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

    public static List<Integer> bubbleSort(List<Integer> list) {
        for (int size = list.size(); size != 1; --size) {
            for (int i = 0; i < size - 1; i++) {
                int temp1 = list.get(i + 1);
                int temp2 = list.get(i);
                if (temp2 > temp1) {
                    list.set(i, temp1);
                    list.set(i + 1, temp2);
                }
            }
        }
        return list;
    }



}
