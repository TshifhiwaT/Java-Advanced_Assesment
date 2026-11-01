public class Employee implements IEmployee {

    private String employeeID;
    private String name;
    private double basicSalary;
    private String jobTitle;
    private Positions position;
    private String department;
    private final double TAX = 0.15;
    private final double HOUSE_ALLOWANCE = 0.8;

    public Employee(String employeeID, String name, String jobTitle, Positions position, String department, double basicSalary) {
        setEmployeeID(employeeID);
        setName(name);
        setBasicSalary(basicSalary);
        setJobTitle(jobTitle);
        setPosition(position);
        setDepartment(department);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double raiseSalary(double percentage) {
        basicSalary += (basicSalary * percentage);
        return basicSalary;
    }

    public Positions promote(int years){
        if(years >= 3 && years <= 5){
            if(position == Positions.Junior){
                position = Positions.Intermediate;
            }else if(position == Positions.Intermediate){
                position = Positions.Senior;
            }
        }else if(years >= 6 && years <= 10){
            if(position == Positions.Intermediate){
                position = Positions.Senior;
            }else if(position == Positions.Senior){
                position = Positions.Director;
            }
        }else if(years > 10){
            if(position == Positions.Senior){
                position = Positions.Director;
            }else if(position == Positions.Director){
                position = Positions.Executive;
            }
        }
        return position;
    }

    @Override
    public double calcHouseAllowance() {
        return (basicSalary * HOUSE_ALLOWANCE);
    }

    @Override
    public double calcGrossSalary() {
        return basicSalary = calcHouseAllowance();
    }

    @Override
    public double calcTax() {
        return calcGrossSalary() * TAX;
    }

    @Override
    public double calcNetSalary() {
        return calcGrossSalary() - calcTax();
    }


}
