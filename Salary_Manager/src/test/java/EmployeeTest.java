import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {

    Employee employee;

    @BeforeEach
    void setupEmployee(){
        employee = new Employee("EM123", "Mike", "Developer", Positions.Junior, "IT", 25000);
    }

    @Test
    void testRaiseSalary(){
        double raisePercentage = 0.15;
        double expectedSalary = 28750.0;

        double actualSalary = employee.raiseSalary(raisePercentage);

        assertEquals(expectedSalary, actualSalary);
    }

    @Test
    void testHighSalaryIncrease(){
        assertThrows(HighSalaryIncrease.class,
                () -> employee.raiseSalary(0.25));

        assertEquals(25000.0, employee.getBasicSalary());
    }

    @Test
    void testCalcHouseAllowance(){
        double expectedAllowance = 2000.0;
        double actualAllowance = employee.calcHouseAllowance();

        assertEquals(expectedAllowance, actualAllowance);
    }

    @Test
    void testCalcGrossSalary(){
        double expectedGross = 27000.0;
        double actualGross = employee.calcGrossSalary();

        assertEquals(expectedGross, actualGross);
    }

    @Test
    void testCalcTax(){
        double expectedTax = 4050.0;
        double actualTax = employee.calcTax();

        assertEquals(expectedTax, actualTax);
    }

    @Test
    void testCalcNetSalary(){
        double expectedNet = 22950.0;
        double actualNet = employee.calcNetSalary();

        assertEquals(expectedNet, actualNet);
    }

}
