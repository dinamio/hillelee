package service;

import entity.Apple;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 7/27/18.
 */
public class AppleServiceTest {

    AppleService appleService = new AppleService();

    private List<Apple> createApplesList() {
        return Arrays.asList(new Apple("red", 400), new Apple("green", 200), new Apple("red", 600));
    }

    @Test
    public void getRedApples() {
        List<Apple> redApples = appleService.getApplesByPredicate(createApplesList(), (Apple s) -> s.getColor().equals("red"));
        assertEquals(2, redApples.size());
    }

    @Test
    public void getHeavyApples() {
        List<Apple> heavyApples = appleService.getApplesByPredicate(createApplesList(), (apple) -> apple.getWeight() > 300);
        assertEquals(2, heavyApples.size());
    }

    @Test
    public void testSomething() {
        /*Function<Apple, Integer> getWeight = Apple::getWeight;
        Integer red = getWeight.apply(new Apple("red", 3000));
        assertEquals(new Integer(3000),red);*/

        /*List<Integer> list = new ArrayList<>();

        BooleanSupplier runnable = () -> list.add(3);
        list = new ArrayList<>();
        //runnable.getAsBoolean();
        //runnable.getAsBoolean();
        System.out.println(list);*/

        List<Integer> integer = new ArrayList<>();
        integer.stream()
                .map(x -> x*x)
                .collect(Collectors.toList());

        createApplesList().parallelStream()
                //.filter(apple -> apple.getColor().equals("red") && apple.getWeight() > 250)
                //.filter(AppleService::isRedAndHeavy)
                .filter(Apple::isRedAndHeavy)
                .map(apple -> apple.getColor())
                .limit(3)
                .collect(Collectors.toList());

        String collect = Stream.of("This", "Is", "Stream").collect(Collectors.joining());
        System.out.println(collect);

        Map<String, List<Apple>> collectMap = createApplesList().stream().collect(groupingBy(apple -> {
            if (apple.getWeight()<300) return "LIGHT";
            if (apple.getWeight()<500) return "MIDDLE";
            return "HEAVY";
        }));
        System.out.println(collectMap);

    }

    @Test
    public void optionalTest() {
        Optional<Apple> blueApple = Optional.of(new Apple("blue",1000));
        Optional<Apple> emptyApple = Optional.empty();
        Optional<Apple> redApple = Optional.of(new Apple("red",20));
        blueApple.ifPresent(System.out::println);
        emptyApple.ifPresent(System.out::println);
        //Stream<Optional<Apple>> optionalStream = Stream.of(blueApple, emptyApple, redApple);
        Optional<Apple> blue = blueApple.filter(apple -> apple.getColor().equals("red"));
        Apple apple = blueApple.get();
        System.out.println(blue);


    }

}