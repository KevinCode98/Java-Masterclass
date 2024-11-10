import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--- TRANSFORM TO UPPERCASE ---");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        System.out.println("--- ADD Random middle initial ---");
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + "." );
        System.out.println(Arrays.toString(names));

        System.out.println("--- ADD reversed name as last name ---");
        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        Arrays.asList(names).forEach(n -> System.out.println(n));

        // Stay in min 9:00 in video 190 :c
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
