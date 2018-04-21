package sort;


import java.util.List;

public class ShellSort
{
    // Shell's sort
    public static List<Integer> sort(List<Integer> list) {

        int h = 1;
        while (h * 3 < list.size()) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < list.size(); i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (list.get(j) < list.get(j - h)) {
                        list.set(j, list.set(j - h, list.get(j)));
                    } else
                        break;
                }
            }
            h = h / 3;
        }
        return list;
    }
}

