import domain.Employee;

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
    }
}
