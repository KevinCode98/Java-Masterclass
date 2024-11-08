import domain.Employee;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Minnie", "Mouse", "01/02/2015");
        Employee e2 = new Employee("Mickie", "Mouse", "05/08/2000");
        Employee e3 = new Employee("Daffy", "Duck", "01/02/2011");
        Employee e4 = new Employee("Daisy", "Duck", "01/02/2013");
        Employee e5 = new Employee("Goofy", "Dog", "01/02/2020");

        List<Employee> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

        printOrderedList(list, "name");
        System.out.println("------------------------");
        printOrderedList(list, "year");
    }

    public static void printOrderedList(List<Employee> eList, String sortField) {
        int currentYear = LocalDate.now().getYear();

        class MyEmployee {
            final Employee containedEmployee;
            final int yearsWorked;
            final String fullName;

            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]
                );
                fullName = String.join(" ", containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<MyEmployee> list = new ArrayList<>();
        eList.forEach(e -> list.add(new MyEmployee(e)));

        var comparator = new Comparator<MyEmployee>() {
            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equals("name"))
                    return o1.fullName.compareTo(o2.fullName);

                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);
        list.forEach(System.out::println);
    }
}