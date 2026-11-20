import java.util.Scanner;

class Employee {
    String name;
    int id;
    String gmail;
    double salary;

    void insert(Scanner sc) {
        System.out.print("Enter Employee Name: ");
        name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Gmail: ");
        gmail = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        salary = sc.nextDouble();
    }

    void display() {
        System.out.println("\n----- Employee Details -----");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Gmail: " + gmail);
        System.out.println("Salary: " + salary);
    }
}

class day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();
        emp.insert(sc);
        emp.display();

        sc.close();
    }
}
