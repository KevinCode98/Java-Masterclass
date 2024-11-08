import domain.Employee;
import domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10_001, "Ralph", 2015),
                new Employee(10_005, "Carole", 2021),
                new Employee(10_022, "Jane", 2013),
                new Employee(10_151, "Laura", 2020),
                new Employee(10_050, "Jim", 2018)
        ));

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Store Members: ");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10_015, "Meg", 2019, "Target"),
                new StoreEmployee(10_515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10_105, "Tom", 2020, "Macys"),
                new StoreEmployee(10_215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10_322, "Bud", 2016, "Target")
        ));

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        storeEmployees.forEach(System.out::println);
        System.out.println("With pig Latin Names: ");
        addPigLatinName(storeEmployees);
    }


    public static void addPigLatinName(List<? extends StoreEmployee> list) {
        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee implements
                Comparable<DecoratedEmployee> {
            private final String pigLatinName;
            private final Employee originalInstance;


            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());
        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (var dEmployee : newList) {
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }
    }
}
