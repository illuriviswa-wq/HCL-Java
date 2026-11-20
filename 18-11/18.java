import java.util.*;
import java.util.stream.*;

class Employee {

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Department: " + department
                + ", Salary: " + salary;
    }
}

class day3 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "Ravi", "IT", 50000),
            new Employee(2, "Raj", "HR", 30000),
            new Employee(3, "Kiran", "IT", 70000),
            new Employee(4, "Arjun", "Finance", 45000),
            new Employee(5, "Sai", "HR", 60000)
        );

        // 1. FILTER()
        System.out.println("\n1. FILTER");
        employees.stream()
            .filter(e -> e.salary > 40000)
            .forEach(System.out::println);

        // 2. MAP()
        System.out.println("\n2. MAP");
        employees.stream()
            .map(e -> e.name.toUpperCase())
            .forEach(System.out::println);

        // 3. SORTED()
        System.out.println("\n3. SORTED");
        employees.stream()
            .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
            .forEach(System.out::println);

        // 4. DISTINCT()
        System.out.println("\n4. DISTINCT");
        employees.stream()
            .map(e -> e.department)
            .distinct()
            .forEach(System.out::println);

        // 5. PEEK()
        System.out.println("\n5. PEEK");
        employees.stream()
            .peek(e -> System.out.println("Processing: " + e.name))
            .forEach(System.out::println);

        // 6. SKIP()
        System.out.println("\n6. SKIP");
        employees.stream()
            .skip(2)
            .forEach(System.out::println);

        // 7. REDUCE()
        System.out.println("\n7. REDUCE");
        double totalSalary = employees.stream()
            .map(e -> e.salary)
            .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total Salary: " + totalSalary);

        System.out.println("\n8. ALLMATCH");
        boolean result1 = employees.stream()
            .allMatch(e -> e.salary > 6000);

        System.out.println(result1);

        System.out.println("\n9. ANYMATCH");
        boolean result2 = employees.stream()
            .anyMatch(e -> e.salary > 60000);

        System.out.println(result2);

        // 10. NONEMATCH()
        System.out.println("\n10. NONEMATCH");
        boolean result3 = employees.stream()
            .noneMatch(e -> e.salary < 20000);

        System.out.println(result3);

        // 11. FINDANY()
        System.out.println("\n11. FINDANY");
        Optional<Employee> result4 = employees.stream()
            .filter(e -> e.salary > 40000)
            .findAny();

        result4.ifPresent(System.out::println);

        // 12. TOARRAY()
        System.out.println("\n12. TOARRAY");
        String[] names = employees.stream()
            .map(e -> e.name)
            .toArray(String[]::new);

        System.out.println(Arrays.toString(names));

        // 13. COUNT()
        System.out.println("\n13. COUNT");
        long count = employees.stream()
            .filter(e -> e.salary > 40000)
            .count();

        System.out.println("Count: " + count);

        System.out.println("\n14. FOREACH");
        employees.stream()
            .forEach(System.out::println);

        System.out.println("\n15. GROUPINGBY");
        Map<String, List<Employee>> group = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department));

        System.out.println(group);

        System.out.println("\n16. PARTITIONINGBY");
        Map<Boolean, List<Employee>> partition = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.salary > 40000));

        System.out.println(partition);

        System.out.println("\n17. OPTIONAL.OF");
        Optional<String> value1 = Optional.of("Hello");

        System.out.println(value1);

        System.out.println("\n18. OPTIONAL.OFNULLABLE");
        String name = null;

        Optional<String> value2 = Optional.ofNullable(name);

        System.out.println(value2);

        System.out.println("\n19. OPTIONAL.EMPTY");
        Optional<String> value3 = Optional.empty();

        System.out.println(value3);
    }
}
