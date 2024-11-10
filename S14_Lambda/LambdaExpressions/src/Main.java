import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"
        ));

        list.forEach(System.out::println);

        System.out.println("------------------------------");
        list.forEach(myString -> System.out.println(myString));

        System.out.println("------------------------------");
        String prefix = "nato";

        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        int result = calculator((var a, var b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator((a, b) ->
                a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramden");

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        proccessPoint(firstPoint[0], firstPoint[1], p1);
        System.out.println("------------------------------");
        coords.forEach(s -> proccessPoint(s[0], s[1], p1));


        System.out.println("------------------------------");
        coords.forEach(s -> proccessPoint(s[0], s[1],
                (lat, lng) ->
                        System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        System.out.println("------------------------------");
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(System.out::println);

        System.out.println("------------------------------");
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(System.out::println);

        System.out.println("----- DELETE ELEMENTS -----");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(System.out::println);

        System.out.println("----- CHANGE ELEMENTS -----");
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(System.out::println);

        System.out.println("----- FILL ELEMENTS -----");
        String[] emptyString = new String[10];
        System.out.println(Arrays.toString(emptyString));
        Arrays.fill(emptyString, " ");
        System.out.println(Arrays.toString(emptyString));

        Arrays.setAll(emptyString, (i) -> (i + 1) + ".");
        System.out.println(Arrays.toString(emptyString));

        Arrays.setAll(emptyString, (i) -> (i + 1) + "." +
                switch (i) {
                    case 0 -> "One";
                    case 1 -> "Two";
                    case 2 -> "Three";
                    default -> "";
                });

        System.out.println(Arrays.toString(emptyString));

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = ramdomlySelectedValues(15, names,
                () -> new Random().nextInt(0, names.length));

        System.out.println(Arrays.toString(randomList));
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation = " + result);
        return result;
    }

    public static String[] ramdomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++)
            selectedValues[i] = values[s.get()];

        return selectedValues;
    }

    public static <T> void proccessPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}
