import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String name = "Kevin";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Carrillo");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Carrillo"))
                .andThen(s -> s.split(" "));

        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Carrillo"))
                .andThen(s -> s.split( " "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);

        System.out.println(f1.apply(name));

        // Video 194 = - min 5 :c
    }
}