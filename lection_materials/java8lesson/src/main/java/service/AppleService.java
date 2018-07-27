package service;

import entity.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by eugen on 7/27/18.
 */
public class AppleService {

    public List<Apple> getApplesByPredicate(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isReadAndHeavy(Apple apple) {
        return apple.getColor().equals("red") && apple.getWeight() >250;
    }
}
