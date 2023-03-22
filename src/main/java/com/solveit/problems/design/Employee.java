public class Employee {

    private final String name;
    private double salary;
    private String designation;
    private String department;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raise(int percentage) {
        this.salary = getRaisedSallalry(this.salary, percentage);
    }

    public static double getRaisedSallalry(double salary, double percentage) {
        double hike= salary * percentage/100;
        return salary + hike;
    }

    public void printSalary() {
        System.out.println(name + ":" + salary);
    }


    public static void main(String[] arg) {
        Employee emp1 = new Employee("aaa", 100000);
        Employee emp2 = new Employee("aaa", 120000);

        emp1.printSalary();
        emp2.printSalary();

        emp1.raise(5);
        emp1.printSalary();

    }

}
