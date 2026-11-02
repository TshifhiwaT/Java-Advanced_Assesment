public class Employee implements IEmployee {

    private String employeeID;
    private String name;
    private double basicSalary;
    private String jobTitle;
    private Positions position;
    private String department;
    private final double TAX = 0.15;
    private final double HOUSE_ALLOWANCE = 0.08;

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
        if(!employeeID.startsWith("EM")){
            throw new IllegalArgumentException("Employee ID should start with EM");
        }
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
        if(basicSalary < 4000){
            throw new IllegalArgumentException("Basic Salary must be more than R4000");
        }
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
        double increase = (basicSalary * percentage);
        if(increase > 5000){
            throw new HighSalaryIncrease("Salary increase of " + increase + " for " + name + " is more than the threshold R5000");
        }
        basicSalary += increase;
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
        return basicSalary + calcHouseAllowance();
    }

    @Override
    public double calcTax() {
        return calcGrossSalary() * TAX;
    }

    @Override
    public double calcNetSalary() {
        return calcGrossSalary() - calcTax();
    }

    @Override
    public String toString() {
        return String.format("""
                Employee          : [%s]%s
                Title             : %s
                Position          : %s
                Department        : %s
                ==============Salary Breakdown===============
                Basic             : R%.1f
                House Allowance   : R%.1f
                Gross             : R%.1f
                Tax Deduction     : R%.1f
                Net               : R%.1f""", employeeID, name, jobTitle, position, department, basicSalary, calcHouseAllowance(), calcGrossSalary(), calcTax(), calcNetSalary());
    }
}
