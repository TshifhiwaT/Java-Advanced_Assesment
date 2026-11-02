public class EmployeeRunner {
    public static void main(String[] args) {
        Employee[] employee = new Employee[4];
        employee[0] = new Employee("EM123", "Mike", "Developer", Positions.Junior, "IT", 25000);
        employee[1] = new Employee("EM124", "Thabo", "Recruiter", Positions.Director, "HR", 26000);
        employee[2] = new Employee("EM125", "Jessica", "Tester", Positions.Intermediate, "IT", 31000);
        employee[3] = new Employee("EM126", "Lerato", "Accountant", Positions.Senior, "Finance", 34000);

        for (Employee value : employee) {
            value.raiseSalary(0.15);
            value.promote(7);
            System.out.println(value.toString());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        }

    }
}
