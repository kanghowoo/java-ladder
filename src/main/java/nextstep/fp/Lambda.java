package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return getSum(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {

        return getSum(numbers, number -> (number % 2) == 0);

    }

    public static int sumAllOverThree(List<Integer> numbers) {

        return getSum(numbers, number -> number > 3);
    }

    private static int getSum(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::isSummable)
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }
}
