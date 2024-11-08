import domain.Employee;
import domain.EmployeeComparator;
import domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10_015, "Meg", 2019, "Target"),
                new StoreEmployee(10_515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10_105, "Tom", 2020, "Macys"),
                new StoreEmployee(10_215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10_322, "Bud", 2016, "Target")
        ));

        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<>();

        // Using local class
        class NameSort<T> implements Comparator<StoreEmployee> {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, c4);
        sortIt(storeEmployees, new Comparator<>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        sortIt(storeEmployees, Comparator.comparing(Employee::getName));
    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        list.forEach(System.out::println);
    }
}
