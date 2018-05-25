package getsort;


import sort.ShellSort;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GetSort
{
    public static void main( String[] args )
    {
        List<Integer> list = IntStream.iterate(0, i -> new Random().nextInt(100)).limit(20).boxed().collect(toList());

        System.out.println("Before sort: " + list);
        ShellSort.sort(list);
        System.out.println("After sort: " + list);
    }
}
