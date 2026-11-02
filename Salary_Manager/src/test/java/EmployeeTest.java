import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {

    static Employee employee;

    @BeforeAll
    static void setupEmployee(){
        employee = new Employee("EM123", "Mike", "Developer", Positions.Junior, "IT", 25000);
    }

    @Test
    @Order(1)
    void testRaiseSalary(){
        double raisePercentage = 0.15;
        double expectedSalary = 28750.0;

        double actualSalary = employee.raiseSalary(raisePercentage);

        assertEquals(expectedSalary, actualSalary);
    }

    @Test
    @Order(2)
    void testHighSalaryIncrease(){
        assertThrows(HighSalaryIncrease.class,
                () -> employee.raiseSalary(0.25));
    }

    @Test
    @Order(3)
    void testCalcHouseAllowance(){
        double expectedAllowance = 2300.0;
        double actualAllowance = employee.calcHouseAllowance();

        assertEquals(expectedAllowance, actualAllowance);
    }

    @Test
    @Order(4)
    void testCalcGrossSalary(){
        double expectedGross = 31050.0;
        double actualGross = employee.calcGrossSalary();

        assertEquals(expectedGross, actualGross);
    }

    @Test
    @Order(5)
    void testCalcTax(){
        double expectedTax = 4657.5;
        double actualTax = employee.calcTax();

        assertEquals(expectedTax, actualTax);
    }

    @Test
    @Order(6)
    void testCalcNetSalary(){
        double expectedNet = 26392.5;
        double actualNet = employee.calcNetSalary();

        assertEquals(expectedNet, actualNet);
    }

}
