import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.printf("----------- CHALLENGE 1 -------------%n");
        System.out.println("----------- Using an Anonymous class --------------");
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        printWords.accept("Let's split this up into an array");


        System.out.println("----------- Using an Lambda expression --------------");
        Consumer<String> printWords2 = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts)
                System.out.println(part);
        };

        printWords2.accept("Let's split this up into an array");


        System.out.println("----------- Using an Lambda expression with Foreach --------------");
        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printWordsForEach.accept("Let's split this up into an array");


        System.out.println("----------- Using an Lambda expression with Foreach into the method --------------");
        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };

        printWordsConcise.accept("Let's split this up into an array");

        System.out.printf("%n%n----------- CHALLENGE 2 -------------%n");
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1)
                    returnVal.append(source.charAt(i));
            }

            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("Let's split this up in an array"));

        System.out.printf("%n%n----------- CHALLENGE 3 -------------%n");
        System.out.printf(everySecondChar.apply("1234567890"));

        System.out.printf("%n%n----------- CHALLENGE 4 and 5 -------------%n");
        System.out.print(everySecondCharacter(everySecondChar, "1234567890"));

        System.out.printf("%n%n----------- CHALLENGE 6 and 7 -------------%n");
        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava2 = () -> {
            return "I love Java!";
        };
        System.out.println(iLoveJava.get());
        System.out.println(iLoveJava2.get());

    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1)
                returnVal.append(source.charAt(i));
        }

        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> fn, String source) {
        return fn.apply(source);
    }
}
