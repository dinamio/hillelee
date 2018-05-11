import java.util.List;

public class QuickSort {
    private List<Integer> numbers;
    private int number;

    public void sort(List<Integer> integerList) {
        if (integerList == null || integerList.size() == 0){
            return;
        }
        this.numbers = integerList;
        number = integerList.size();
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;

        int pivot = numbers.get(low + (high-low)/2);

        while (i <= j) {

            while (numbers.get(i) < pivot) {
                i++;
            }
            while (numbers.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void swap(int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
