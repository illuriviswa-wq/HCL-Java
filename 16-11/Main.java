import java.util.*;
import java.util.function.*;

@FunctionalInterface
interface Demo {
    void display();
}

public class Main{
    public static void main(String[] args) {
        List<Integer> attendance = Arrays.asList(95, 45, 80, 30, 100);

        Predicate<Integer> p = a -> a >= 75;
        Consumer<Integer> c = a -> System.out.println(a);

        System.out.println("Eligible Attendance:");
        attendance.stream()
                  .filter(p)
                  .forEach(c);

        Demo d = () -> System.out.println("Hello Java");
        d.display();

        Consumer<String> con = a -> System.out.println(a);
        con.accept("Consumer Example");

        Supplier<String> s = () -> "Welcome to Java";
        System.out.println(s.get());

        Predicate<Integer> check = a -> a > 50;
        System.out.println(check.test(60));

        Demo obj = () -> System.out.println("Lambda Expression");
        obj.display();
    }
}
